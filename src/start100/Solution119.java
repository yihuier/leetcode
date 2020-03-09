package start100;

import java.util.Arrays;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        Integer[] rowList = new Integer[rowIndex + 1];
        rowList[0] = 1;

        if (rowIndex == 0) return Arrays.asList(rowList);

        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            // 新一层的数，从下标为1的位置开始求(因为下标为0的位置一直都是1)
            // 每一层下标为i的数=上一层下标为i-1与下标为i的和
            // 由于如果直接赋值下一个数还需要用到下标为i的值，所以用一个变量prev保存
            for (int j = 1; j < i; j++) {
                int current = rowList[j];
                rowList[j] = prev + current;
                prev = current;
            }
            // 最后一个数也不需要计算，一直为1
            rowList[i] = 1;
        }

        return Arrays.asList(rowList);
    }
}
