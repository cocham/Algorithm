import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] people;
    static boolean[] selected;
    static ArrayList<Integer>[] graph;
    static int minDiff = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        selected = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            int near = Integer.parseInt(st.nextToken());
            for (int j = 0; j < near; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        dfs(1);
        if (minDiff == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        } 
        System.out.print(minDiff);
    }
    
    static void dfs(int idx) {
        if (idx == N + 1) {
            if (isSelected() && bfs()) {
                calc();
            }
            return;
        }
        
        selected[idx] = true;
        dfs(idx + 1);
        
        selected[idx] = false;
        dfs(idx + 1);
    }
    
    static void calc() {
        int t = 0;
        int f = 0;
        
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                t += people[i];
            } else {
                f += people[i];
            }
        }
        
        minDiff = Math.min(minDiff, Math.abs(t - f));
    }
    
    
    static boolean bfs() {
        boolean[] tVisited = new boolean[N + 1];
        boolean[] fVisited = new boolean[N + 1];
        Queue<Integer> tq = new LinkedList<>();
        Queue<Integer> fq = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            if (tq.size() == 1 && fq.size() == 1) {
                break;
            } else if (tq.size() == 0 && selected[i]) {
                tq.add(i);
                tVisited[i] = true;
            } else if (fq.size() == 0 && !selected[i]){
                fq.add(i);
                fVisited[i] = true;
            }
        }
        
        while (!tq.isEmpty()) {
            int cur = tq.poll();
            
            for (int n : graph[cur]) {
                if (selected[n] && !tVisited[n]) {
                    tVisited[n] = true;
                    tq.add(n);
                }
            }
        }
        
        while (!fq.isEmpty()) {
            int cur = fq.poll();
            
            for (int n : graph[cur]) {
                if (!selected[n] && !fVisited[n]) {
                    fVisited[n] = true;
                    fq.add(n);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (selected[i] && !tVisited[i]) {
                return false;
            }
            
            if (!selected[i] && !fVisited[i]) {
                return false;
            }
        }
        
        return true;
    }
        
    
    static boolean isSelected() {
        int isTrue = 0;
        int isFalse = 0;
        
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                isTrue++;
            } else {
                isFalse++;
            }
        }
        
        if (isTrue != 0 && isFalse != 0) {
            return true;
        }
        
        return false;
    }
}