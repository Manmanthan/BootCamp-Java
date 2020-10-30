package Questions.DynamicProgramming;

public class CoinChange {
    public static void main(String[] args){
        int[] coins = {1, 2, 3};
        System.out.println(coinChange(coins, 3, 4));
    }

    public static int coinChange(int[] coins, int num, int value) {
        if (value == 0)
            return 1;
        if (value< 0)
            return 0;
        if (num <= 0 && value >= 0)
            return 0;
        return coinChange(coins, num - 1, value) +
                coinChange(coins, num, value - coins[num-1]);
    }
}
