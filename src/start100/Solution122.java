package start100;

public class Solution122 {

    public int maxProfit(int[] prices) {
        if (prices == null) return 0;

        int sum = 0;

        // 不管以后，只管今天和明天。如果明天的价比今天高，那么今天买明天直接买
        // 然后明天再根据后天的价格决定要不要买
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }

        return sum;
    }
}
