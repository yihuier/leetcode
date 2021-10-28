package from200;

public class Solution268 {

    /**
     *  正常做法
     */
    public int missingNumber2(int[] nums) {
        byte[] tmp = new byte[nums.length + 1];

        for (int num : nums) {
            tmp[num] = 1;
        }

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 1) return i;
        }

        // 随便返回的数
        return -1;
    }

    /**
     * 利用高斯求和公式 sum = (1 + n) * n / 2
     * 因为这里从0开始，共有nums.length + 1个数
     * 所以带入公式为 sum = (0 + nums.length) * (nums.length + 1) / 2
     */
    public int missingNumber(int[] nums) {
        int exceptedSum = nums.length * (nums.length + 1) / 2;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return exceptedSum - sum;
    }


}
