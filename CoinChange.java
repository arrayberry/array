public class CoinChange {

    private int coinChange(int[] coins, int numCoins, int amount) {
        if (amount<0) return 0;
        if (amount==0) return 1;
        if (numCoins<=0 && amount>0)
            return 0;
        return coinChange(coins, numCoins-1, amount) +
               coinChange(coins, numCoins, amount-coins[numCoins-1]);
    }

    public static void main(String[] argv) {

        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 3, 5));
    }
}
