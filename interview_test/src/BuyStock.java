/**
 * @Author: Chenglin Ding
 * @Date: 17.04.2021 08:39
 * @Description:
 */
public class BuyStock {
    public static void main(String[] args) {
        int [] prices = {2,2,2,1,1};
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            int min = prices[i];
            int temp = 0;
            for(int j = i; j < prices.length; j++){
                temp = Math.max(temp,prices[j] - prices[i]);
            }
            res = Math.max(temp, res);
        }

        System.out.println(res);
    }
}
