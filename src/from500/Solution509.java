package from500;

public class Solution509 {

    /**
     * 非递归，斐波那契
     */
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int result = 0;
        int lastFirst = 0;
        int lastSecond = 1;
        int i = 2;

       while (i <= N) {
           result = lastFirst + lastSecond;
           lastFirst = lastSecond;
           lastSecond = result;

           i++;
       }

       return result;
    }
}
