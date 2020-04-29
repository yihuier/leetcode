package start500;

/**
 *  @author yihuier
 *  @Date 2020/4/29 19:51
 *  @Description
 */
public class Solution551 {

    /**
     * 比较简单的一道题，但是需要注意是连续的两个以上的L
     */
    public boolean checkRecord(String s) {
        int remainAbsent = 1;
        int remainLate = 2;

        for (Character c : s.toCharArray()) {
            if (c == 'A') {
                remainAbsent--;
            } else if (c == 'L') {
                remainLate--;
            }

            if (c != 'L') {
                remainLate = 2;
            }

            if (remainAbsent < 0 || remainLate < 0) {
                return false;
            }
        }

        return true;
    }
}
