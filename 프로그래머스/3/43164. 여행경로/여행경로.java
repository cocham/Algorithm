import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    static boolean[] visited;
    static int limit;
    static ArrayList<String> roots = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        limit = tickets.length;
        
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(roots);
        return roots.get(0).split(" ");
    }
    
    static void dfs(String start, String route, int cnt, String[][] tickets) {
        
        if (cnt == limit) {
            roots.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
    }
}