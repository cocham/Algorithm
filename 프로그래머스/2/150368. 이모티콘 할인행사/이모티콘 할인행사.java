class Solution {
    static int[] discount = {10,20,30,40};
    static int[] dc;
    static int userCnt;
    static int totalPay;
    
    public int[] solution(int[][] users, int[] emoticons) {
        dc = new int[emoticons.length];
        
        dfs(0,users,emoticons);
        int[] answer = {userCnt, totalPay};
        return answer;
    }
    
    static void dfs(int emoIdx, int[][] users, int[] emoticons) {
        if (emoIdx == emoticons.length) {
            int curUserCnt = 0;
            int curPay = 0;
            
            for (int[] user : users) {
                int userDc = user[0];
                int userPay = user[1];
                int thisPay = 0;
                
                for (int i = 0; i < emoticons.length; i++) {
                    int emoDc = dc[i];
                    if (emoDc >= userDc) {
                        int emoCost = emoticons[i] - (emoticons[i] * dc[i] / 100);
                        thisPay += emoCost;
                    }
                }
                
                if (thisPay >= userPay) {
                    curUserCnt++;
                } else {
                    curPay += thisPay;
                }
            }
            
            if (curUserCnt > userCnt) {
                userCnt = curUserCnt;
                totalPay = curPay;
            } if (userCnt == curUserCnt && curPay > totalPay) {
                totalPay = curPay;
            }
            
            return;
        }
        
        
        for (int i = 0; i < 4; i++) {
            dc[emoIdx] = discount[i];
            dfs(emoIdx + 1, users, emoticons);
        }
    }
}