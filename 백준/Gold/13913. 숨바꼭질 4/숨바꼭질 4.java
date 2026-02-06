import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
    static int N;
    static int K;
    static int[] time = new int[100001];
    static int[] path = new int[100001];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N,K);
        System.out.println(time[K]);
        System.out.print(sb);
    }
    
    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        time[start] = 0;

        while (!q.isEmpty()) {
            int curAxis = q.poll();
            
            if (curAxis == target) {
                Stack<Integer> stack = new Stack<>();
                stack.push(curAxis);
                
                int index = curAxis;
                while (index != N) {
                    index = path[index];
                    stack.push(index);
                }

                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }

                return;
            }
            
            int step1 = curAxis - 1;
            int step2 = curAxis + 1;
            int step3 = curAxis * 2;
            
            if (step1 >= 0 && step1 <= 100000) {
                if (time[step1] == 0) {
                    q.add(step1);
                    path[step1] = curAxis;
                    time[step1] = time[curAxis] + 1;
                } 
            }

            if (step2 >= 0 && step2 <= 100000) {
                if (time[step2] == 0) {
                    q.add(step2);
                    path[step2] = curAxis;
                    time[step2] = time[curAxis] + 1;
                }
            }
            
            if (step3 >= 0 && step3 <= 100000) {
                if (time[step3] == 0) {
                    q.add(step3);
                    path[step3] = curAxis;
                    time[step3] = time[curAxis] + 1;
                }
            }
        }
    }
}
