class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        int[] answer = new int[2];

        for (int h = 3; h <= totalSize; h++) {
            if (totalSize % h == 0) {
                int w = totalSize / h;
                if ((h - 2) * (w - 2) == yellow) {
                    answer = new int[]{w, h};
                    break;
                }
            }
        }
            
        return answer;
    }
    
    
}