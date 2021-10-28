package from400;

public class Solution459 {

    /**
     * 很一般的做法，逐个比较
     */
    public boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i < s.length(); i++) {
            // 找到一个和首个字母相同的字母的位置
            if (s.charAt(0) == s.charAt(i)) {
                // 如果不能被划分为相等的几个部分，则说明这个位置不符合规则
                if (s.length() % i != 0) continue;

                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    int index = i + j;
                    while (index < s.length()) {
                        if (s.charAt(j) != s.charAt(index)) {
                            flag = false;
                            break;
                        }

                        index += i;
                    }

                    if (!flag) break;
                }

                if (flag) return true;
            }
        }

        return false;
    }
}
