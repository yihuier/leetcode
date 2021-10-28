package from1300;

import java.util.HashSet;

public class Solution1346 {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int value : arr) {
            if (integerHashSet.contains(value * 2) || (value % 2 == 0 && integerHashSet.contains(value / 2))) {
                return true;
            }
            integerHashSet.add(value);
        }

        return false;
    }
}
