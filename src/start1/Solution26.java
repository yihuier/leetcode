package start1;

public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }
}
