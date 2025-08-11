package Arrays.Medium;

public class BuySell {

    public static int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for(int i = 1 ; i < prices.length ;i++){
            int presProfit = prices[i] - mini;
            profit = Math.max(profit , presProfit);
            mini = Math.min(mini , prices[i]);
        }
        return profit;
    }

    static int maxprofit(int[] prices){

        int n = prices.length;
        int minimum = prices[0];
        int maxProfit = 0;

        for(int i = 0 ; i < n ; i++){
            if(prices[i] < minimum){
                minimum = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit , prices[i] - minimum);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxprofit(prices));
    }
    
}
