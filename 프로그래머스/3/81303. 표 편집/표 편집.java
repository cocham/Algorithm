import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n];
        int[] down = new int[n];
        Stack<Integer> deleted = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        down[n - 1] = -1;
        
        for (String s : cmd) {
            char order = s.charAt(0);
            
            if (order == 'U') {
                int row = Integer.parseInt(s.substring(2));

                while (row-- > 0) {
                    k = up[k];
                }
            } else if (order == 'D') {
                int row = Integer.parseInt(s.substring(2));

                while (row-- > 0) {
                    k = down[k];
                }
            } else if (order == 'C') {
                deleted.push(k);
                
                if (up[k] != -1) {
                    down[up[k]] = down[k];
                }
                
                if (down[k] != -1) {
                    up[down[k]] = up[k];
                }
                
                k = down[k] == -1 ? up[k] : down[k];
            } else if (order == 'Z') {
                int restore = deleted.pop();
                
                if (up[restore] != -1) {
                    down[up[restore]] = restore;
                }
                
                if (down[restore] != -1) {
                    up[down[restore]] = restore;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        
        while(!deleted.isEmpty()) {
            sb.setCharAt(deleted.pop(), 'X');
        }
        
        return sb.toString();
        
    }
}