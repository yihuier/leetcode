package from1;

public class Solution58 {

    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i + 1 < s.length() && s.charAt(i + 1) != ' ') {
                    count = 0;
                }
            } else {
                count++;
            }
        }

        return count;
    }

//    public int lengthOfLastWord(String s) {
//        if (s == null) return 0;
//
//        s = s.trim();
//        if (s.isEmpty()) return 0;
//
//        return s.length() - 1 - s.lastIndexOf(" ");
//    }
}
