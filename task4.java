import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Программа для подсчета частоты появления каждого символа в текстовом файле и
 * записи результатов в другой файл.
 */

public class task4 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            // Открываем файл для чтения
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

            // Инициализируем карту для подсчета частоты символов
            Map<Character, Integer> characterFrequency = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                // Убираем пробелы и переводы строк, а затем перебираем символы
                line = line.replaceAll("[\\s]+", "");
                for (char character : line.toCharArray()) {
                    characterFrequency.put(character, characterFrequency.getOrDefault(character, 0) + 1);
                }
            }

            // Закрываем файл после чтения
            reader.close();

            // Сортируем карту по частоте в убывающем порядке
            Map<Character, Integer> sortedCharacterFrequency = characterFrequency.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            // Открываем файл для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            // Записываем результат в файл
            for (Map.Entry<Character, Integer> entry : sortedCharacterFrequency.entrySet()) {
                writer.write("'" + entry.getKey() + "'=" + entry.getValue() + ", ");
            }

            // Закрываем файл после записи
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
