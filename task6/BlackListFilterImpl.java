package task6;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class BlackListFilterImpl implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();

        for (String comment : comments) {
            if (!containsBlackListedWords(comment, blackList)) {
                filteredComments.add(comment);
            }
        }

        comments.clear();
        comments.addAll(filteredComments);
    }

    private boolean containsBlackListedWords(String comment, Set<String> blackList) {
        StringTokenizer tokenizer = new StringTokenizer(comment, " \t\n\r\f.,;:!?'\"");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase(); // приводим к нижнему регистру для регистронезависимого сравнения
            if (blackList.contains(word)) {
                return true;
            }
        }

        return false;
    }
}