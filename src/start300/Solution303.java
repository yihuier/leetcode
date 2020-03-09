package start300;

public class Solution303 {

    class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j ) {
            return sums[j + 1] - sums[i];
        }

//        private int[] nums;

//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int i, int j) {
//            int sum = 0;
//
//            for (int ii = i; ii <= j; ii++) {
//                sum += nums[ii];
//            }
//
//            return sum;
//        }
    }

}



