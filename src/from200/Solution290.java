package from200;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {

    public boolean wordPattern(String pattern, String str) {
        // null判断

        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        String[] strings = str.split(" ");

        if (pattern.length() != strings.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (!pMap.containsKey(ch)) {
                if (sMap.containsKey(strings[i])) return false;

                pMap.put(ch, strings[i]);
                sMap.put(strings[i], ch);
                continue;
            }

            if (!pMap.get(ch).equals(strings[i])) return false;
        }

        return true;
    }
}
