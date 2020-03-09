package start200;

public class Solution292 {

    /**
     * 由于当剩下4个的时候，轮到谁，谁就会输。
     * 所以只要我能够每次拿完之后剩下的石头数量是4的倍数，那么我就能够胜利，并且我每次肯定会这么做，如果可以的话
     * 所以这就要看一开始第一次我能不能拿走之后让桌上的石头剩下4的倍数。
     * 所以当n不是4倍数时能够胜利
     */
    public boolean canWinNim(int n) {
        if(n <= 0) return false;

        return (n % 4) != 0;
    }
}
