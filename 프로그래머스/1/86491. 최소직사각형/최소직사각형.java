class Solution {
    public int solution(int[][] sizes) {
        int maxSize = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] wallet : sizes) {
            int maxW = Math.max(wallet[1], wallet[0]);
            int maxH = Math.min(wallet[1], wallet[0]);
            
            maxWidth = Math.max(maxW, maxWidth);
            maxHeight = Math.max(maxH, maxHeight);
        }
        
        return maxWidth * maxHeight;

    }
}