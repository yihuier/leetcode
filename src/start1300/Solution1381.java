package start1300;

/**
 *  @author yihuier
 *  @Date 2020/12/3 17:03
 *  @Description
 */
public class Solution1381 {

    /**
     * 借助数组和一个表示当前栈顶位置的curIndex
     */
    class CustomStack {

        private final int[] incrementValues;

        private int curIndex;

        private final int maxSize;

        public CustomStack(int maxSize) {
            this.incrementValues = new int[maxSize];
            this.curIndex = -1;
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (curIndex >= maxSize - 1) {
                return;
            }

            incrementValues[++curIndex] = x;
        }

        public int pop() {
            if (curIndex < 0) {
                return -1;
            }

            return incrementValues[curIndex--];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k; i++) {
                if (i > maxSize - 1) {
                    break;
                }

                incrementValues[i] += val;
            }
        }
    }
}
