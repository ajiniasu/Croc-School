package task6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        // Создаем экземпляр BlackListFilterImpl
        BlackListFilterImpl filter = new BlackListFilterImpl();

        // Создаем список комментариев
        List<String> comments = new ArrayList<>();
        comments.add("Это очень хорошая программа!");
        comments.add("программа отстой, удалил");
        comments.add("негры негры негры");

        // Создаем черный список
        Set<String> blackList = new HashSet<>();
        blackList.add("отстой");
        blackList.add("негры");

        // Выводим исходные комментарии
        System.out.println("Изначальные комментарии:");
        for (String comment : comments) {
            System.out.println(comment);
        }

        // Применяем фильтр
        filter.filterComments(comments, blackList);

        // Выводим отфильтрованные комментарии
        System.out.println("\nОтфильтрованные комментарии:");
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}