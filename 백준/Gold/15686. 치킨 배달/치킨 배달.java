import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static int minDis = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if (arr[i][j] == 2) {
                    chickens.add(new int[]{i,j});
                } else if (arr[i][j] == 1) {
                    houses.add(new int[]{i,j});
                }
            }
        }
        
        visited = new boolean[chickens.size()];
        dfs(0,0);
        System.out.print(minDis);
    }
    
    static void dfs(int start, int depth) {

        if (depth == M) {
            calc();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    static void calc() {
        int totalDist = 0;
        
        for (int j = 0; j < houses.size(); j++) {
            int[] house = houses.get(j);
            int hr = house[0];
            int hc = house[1];
            int minR = Integer.MAX_VALUE;
            
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    int[] chicken = chickens.get(i);
                    int cr = chicken[0];
                    int cc = chicken[1];
                    
                    int dist = Math.abs(cr - hr) + Math.abs(cc - hc);
                    minR = Math.min(dist, minR);
                }
            }
            
            totalDist += minR;

        }
        
        minDis = Math.min(totalDist, minDis);
        
    }
}
