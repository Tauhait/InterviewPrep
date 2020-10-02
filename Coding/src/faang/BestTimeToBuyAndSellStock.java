package faang;

public class BestTimeToBuyAndSellStock {
	
	// Time O(N*N)
//	public int maxProfit(int[] prices) {         
//        int len = prices.length;
//        int maxProfit = 0;        
//        for(int i = 0; i < len; i++)
//            for(int j = i + 1; j < len; j++)
//                if((prices[j] - prices[i]) > maxProfit) maxProfit = prices[j] - prices[i];
//        return maxProfit;
//    }
	
	// Time O(N)
	public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;  
        for(int price : prices) {
            if(price < minPrice) minPrice = price;
            if(price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }
	

}
