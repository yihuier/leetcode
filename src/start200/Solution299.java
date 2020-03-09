package start200;

import java.util.HashSet;
import java.util.Set;

public class Solution299 {

    /**
     * 用numCount来记录除了完全匹配的其他数字出现的次数
     * 用used来记录完全匹配的位置
     */
    public static String getHint(String secret, String guess) {
//        Set<Integer> set = new HashSet<>();
        int[] numCount = new int[10];
        boolean[] used = new boolean[secret.length()];
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                countA++;
//                set.add(i);
                used[i] = true;
            } else {
                numCount[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
//            if (set.contains(i)) continue;
            if (used[i]) continue;
            int index = guess.charAt(i) - '0';
            if (numCount[index] > 0) {
                numCount[index]--;
                countB++;
            }
        }

        return countA + "A" + countB + "B";
    }
}
