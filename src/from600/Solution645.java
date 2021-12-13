package from600;

import java.util.Arrays;

/**
 * @author yihuier
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int prev = 0;
        int duplicatedNum = 0;
        int missNum = 0;
        for (int num : nums) {
            if (prev == num) {
                duplicatedNum = prev;
                if (missNum != 0) {
                    break;
                }
            } else if (prev + 2 == num) {
                missNum = prev + 1;
                if (duplicatedNum != 0) {
                    break;
                }
            }
            prev = num;
        }

        if (missNum == 0) {
            missNum = nums.length;
        }

        return new int[] {duplicatedNum, missNum};
    }
}
