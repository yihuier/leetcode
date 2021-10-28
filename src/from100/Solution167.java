package from100;

public class Solution167 {


    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;

        while ((numbers[i] << 1) < target) {
            int remain = target - numbers[i];
            int low = i + 1;
            int high = numbers.length - 1;

            while (low <= high) {
                int mid = low + ((high - low) >> 1);

                if (numbers[mid] == remain)
                    return new int[] {i + 1, mid + 1};
                else if (numbers[mid] < remain) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            i++;
        }

        return new int[0];
    }
    /**
     * 使用二分查找
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0;

        while ((numbers[i] << 1) < target) {
            int remain = target - numbers[i];
            int remainIndex = binarySearch(numbers, remain, i + 1, numbers.length - 1);

            if (remainIndex != -1) {
                return new int[] {i + 1, remainIndex + 1};
            }

            i++;
        }

        return new int[0];
    }

    private static int binarySearch(int [] numbers, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + ((right - left) >> 1);

        if (numbers[mid] == target) return mid;
        if (numbers[mid] < target) return binarySearch(numbers, target, mid + 1, right);

        return binarySearch(numbers, target, left, mid - 1);
    }
}
