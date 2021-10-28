package from100;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    /**
     * 每一层除了第一个和最后一个数固定为1
     * 中间的数由上一层分别对应计算可得
     * 所以先确定第一层，[1]，之后的每一层都可逐个推导出来
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) return list;

        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        list.add(innerList);

        for (int i = 1; i < numRows; i++) {
            innerList = new ArrayList<>();
            innerList.add(1);
            List<Integer> preInnerList = list.get(i - 1);

            for (int j = 0; j < preInnerList.size() - 1; j++) {
                innerList.add(preInnerList.get(j) + preInnerList.get(j + 1));
            }

            innerList.add(1);
            list.add(innerList);
        }

        return list;
    }
}
