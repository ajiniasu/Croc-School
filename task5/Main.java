import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


public class Main {


    public static void main(String[] args) {
        var matrix = MatrixExample.B;

        // Используем пул потоков для выполнения в нескольких потоках
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        printResult("detMultiThread", matrix, () -> detMultiThread(matrix.getMatrix(), executor));

        // Закрываем пул потоков после использования
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long detMultiThread(long[][] a, ExecutorService executor) {
        if (a.length == 1) {
            return a[0][0];
        }

        var result = new long[1]; // Используем массив для совместной записи результата между потоками
        for (var i = 0; i < a.length; i++) {
            var sign = (i % 2 == 0 ? 1 : -1);
            final int row = i;
            executor.execute(() -> {
                result[0] += sign * a[row][0] * detOneThread(minor(a, row));
            });
        }

        // Ждем завершения выполнения всех задач в пуле
        try {
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result[0];
    }


    private static long detOneThread(long[][] a) {
        if (a.length == 1) {
            return a[0][0];
        }
        var result = 0L;
        for (var i = 0; i < a.length; i++) {
            var sign = (i % 2 == 0 ? 1 : -1);
            result = result + sign * a[i][0] * detOneThread(minor(a, i));
        }

        return result;
    }



    public static long[][] minor(final long[][] original, int exceptRow) {
        long[][] minor = new long[original.length-1][original.length-1];
        var minorLength = minor.length;
        for (int i = 0; i < exceptRow; i++) {
            System.arraycopy(original[i], 1, minor[i], 0, minorLength);
        }
        for (int i = exceptRow + 1; i < original.length; i++) {
            System.arraycopy(original[i], 1, minor[i - 1], 0, minorLength);
        }
        return minor;
    }

    /**
     * Выводит в консоль результат работы.
     *
     * @param method
     *          название метода расчета
     * @param matrix
     *          матрица из предложенных для примера
     * @param executor
     *          алгоритм расчета определителя матрицы
     */
    private static void printResult(String method, MatrixExample matrix, Supplier<Long> executor) {
        var start = System.currentTimeMillis();
        var det = executor.get();
        var executionTime = (System.currentTimeMillis() - start);
        System.out.println("Method -> " + method);
        System.out.println("Matrix name -> " + matrix.name());
        System.out.println("Matrix dimension -> " + matrix.getMatrix().length);
        System.out.println("Matrix determinant  = " + det + (det != matrix.getDeterminant() ? " ERROR!" : ""));
        System.out.println("Execution time -> " + executionTime);
        System.out.println();
    }
}