class Solution {
    static int maxCnt;
    static int maxSold;
    static int[] discountRates = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        
        dfs(0, discounts, users, emoticons);
        int[] answer = {maxCnt, maxSold};
        return answer;
    }
    
    static void dfs(int depth, int[] discounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int curCnt = 0;
            int curSold = 0;
            
            for (int[] user : users) {
                int userDis = user[0];
                int userPay = user[1];
                int userSum = 0;
                
                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i] >= userDis) {
                        userSum += emoticons[i] - (emoticons[i] * discounts[i] / 100);
                    }
                }
                
                if (userSum >= userPay) {
                    curCnt++;
                } else {
                    curSold += userSum;
                }
            }
            
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                maxSold = curSold;
            } else if (curCnt == maxCnt && curSold > maxSold) {
                maxSold = curSold;
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discounts[depth] = discountRates[i];
            dfs(depth + 1, discounts, users, emoticons);
        }
        
    }
}