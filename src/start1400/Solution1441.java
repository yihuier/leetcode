package start1400;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yihuier
 *  @Date 2020/12/1 17:15
 *  @Description 由于target是严格递增的，所以，一个数不在target中要么是push之后又pop
 *  要么是还有读取到那个数
 */
public class Solution1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();

        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i == target[index]) {
                result.add("Push");
                index++;
            } else {
                result.add("Push");
                result.add("Pop");
            }

            if (index >= target.length) {
                break;
            }
        }

        return result;
    }
}
