package start1400;

/**
 *  @author yihuier
 *  @Date 2020/12/16 10:16
 *  @Description
 */
public class Solution1470 {

    /**
     * 数组的遍历
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int i = 0;
        int j = n;
        int k = 0;

        while (i < n && j < nums.length) {
            result[k++] = nums[i];
            result[k++] = nums[j];

            i++;
            j++;
        }

        return result;
    }
}
