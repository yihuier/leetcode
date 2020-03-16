package start400;

import java.util.Arrays;

public class Solution455 {

    /**
     * 先排序，然后从小到大逐个比较计数
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentNum = 0;
        int i = 0,j = 0;

        while (i < g.length) {
            while (j < s.length && g[i] > s[j]) j++;
            if (j >= s.length) break;

            contentNum++;
            i++;
            j++;
        }

        return contentNum;
    }
}
