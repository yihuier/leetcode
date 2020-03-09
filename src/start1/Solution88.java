package start1;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将nums1的数据全部往后挪n个位置
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        // nums1从n开始遍历到n + m - 1
        // nums2从0开始遍历到n - 1
        // 根据大小合并
        int i = n;
        int j = 0;
        int k = 0;
        while (i < m + n && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums1[k++] = nums1[i++];
        }

        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
