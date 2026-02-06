import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int A;
    static int B;
    static boolean[] visited = new boolean[10000];
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int num;
        String path;
        
        Node (int num, String path) {
            this.num = num;
            this.path = path;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[10000];
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs(A, B);
        }
        
        System.out.print(sb);
    }
    
    static void bfs(int start, int target) {
        visited[start] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, ""));
        
        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int num = curNode.num;
            
            if (num == target) {
                sb.append(curNode.path).append('\n');
                return;
            }
            
            int nextD = (num * 2) % 10000;
            if (!visited[nextD]) {
                visited[nextD] = true;
                q.add(new Node(nextD, curNode.path + "D"));
            }
              
            int nextS = (num == 0) ? 9999 : num - 1;
            if (!visited[nextS]) {
                visited[nextS] = true;
                q.add(new Node(nextS, curNode.path + "S"));
            }
            
            int nextL = (num % 1000 * 10) + (num / 1000);
            if (!visited[nextL]) {
                visited[nextL] = true;
                q.add(new Node(nextL, curNode.path + "L"));
            }
            
            int nextR = (num % 10 * 1000) + (num / 10);
            if (!visited[nextR]) {
                visited[nextR] = true;
                q.add(new Node(nextR, curNode.path + "R"));
            }
        }
    }
}
