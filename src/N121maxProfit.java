package src;

class NmaxProfit {
    public int maxProfit(int[] prices){
        if (prices.length < 2)
            return 0;

        int maxPro = 0;
        int minPrice = prices[0];

        for (int price: prices){
            minPrice = Math.min(price, minPrice);
            maxPro = Math.max(price - minPrice, maxPro);
        }
        return maxPro;
    }
}
