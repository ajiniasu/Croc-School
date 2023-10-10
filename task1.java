import java.util.Scanner;

public class task1 {

    /**
     * Метод для проверки, является ли строка палиндромом.
     * str - строка, проходящая проверку на палиндром.
     * return true в том случае, если строка является палиндромом.
     * return false в том случае, если строка не явяется палиндромом.
     */
    public static boolean isPalindrome(String str) {
        // Удаляем пробелы и приводим все символы к нижнему регистру
        String newStr = str.replaceAll("\\s+", "").toLowerCase();

        int length = newStr.length();
        for (int i = 0; i < length / 2; i++) {
            // Сравниваем символы с обоих концов строки
            if (newStr.charAt(i) != newStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


    //Главный метод программы. Запрашивает у пользователя ввод строки и выводит результат проверки на палиндром.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку для проверки на палиндром:");
        String input = scanner.nextLine();
        // Проверяем, является ли введенная строка палиндромом
        if (isPalindrome(input)) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }
    }
}