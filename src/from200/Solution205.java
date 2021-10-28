package from200;

import java.util.HashMap;

public class Solution205 {

    /**
     * 使用hashMap保存映射关系
     */
    public boolean isIsomorphic2(String s, String t) {
        // 两个都为null
        if (s == null && t == null) return true;
        // 有且仅有一个为null
        if (s == null || t == null) return false;

        // s -> t 的映射
        HashMap<Character, Character> stMapping = new HashMap<>();
        // t -> s 的映射
        HashMap<Character, Character> tsMapping = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);

            if (stMapping.containsKey(charOfS)) {
                if (stMapping.get(charOfS) != charOfT) return false;
            } else {
                if (tsMapping.containsKey(charOfT)) return false;

                stMapping.put(charOfS, charOfT);
                tsMapping.put(charOfT, charOfS);
            }
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        // 两个都为null
        if (s == null && t == null) return true;
        // 有且仅有一个为null
        if (s == null || t == null) return false;

        int[] sMapping = new int[256];
        int[] tMapping = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);
            if (sMapping[charOfS] != tMapping[charOfT]) return false;

            sMapping[charOfS] = i + 1;
            tMapping[charOfT] = i + 1;
        }

        return true;
    }
}
