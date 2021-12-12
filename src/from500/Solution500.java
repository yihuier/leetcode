package from500;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author yihuier
 */
public class Solution500 {
    private static final Set<String> FIRST_ROW_KEY_SET = Set.of("q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P");
    private static final Set<String> SECOND_ROW_KEY_SET = Set.of("a", "s", "d", "f", "g", "h", "j", "k", "l", "A", "S", "D", "F", "G", "H", "J", "K", "L");
    private static final Set<String> THIRD_ROW_KEY_SET = Set.of("z", "x", "c", "v", "b", "n", "m", "Z", "X", "C", "V", "B", "N", "M");

    // 我以为这样会快一点，没想到更慢了。
    public String[] findWords(String[] words) {
        List<String> resultWords = new LinkedList<>();
        for (String word : words) {
            String[] chars = word.split("");
            Set<String> useKeySet;
            if (FIRST_ROW_KEY_SET.contains(chars[0])) {
                useKeySet = FIRST_ROW_KEY_SET;
            } else if (SECOND_ROW_KEY_SET.contains(chars[0])) {
                useKeySet = SECOND_ROW_KEY_SET;
            } else {
                useKeySet = THIRD_ROW_KEY_SET;
            }
            boolean isEligible = true;
            for (String ch : chars) {
                if (!useKeySet.contains(ch)) {
                    isEligible = false;
                    break;
                }
            }
            if (isEligible) {
                resultWords.add(word);
            }
        }

        String[] outWords = new String[resultWords.size()];
        resultWords.toArray(outWords);
        return outWords;
    }
}
