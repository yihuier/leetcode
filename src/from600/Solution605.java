package from600;

/**
 * @author yihuier
 */
public class Solution605 {
    // 有时候，不需要考虑太多，直接算就可以了
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
            i++;
        }
        return count >= n;
    }
}
