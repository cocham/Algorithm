import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, x});
            }
            
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] out = q.poll();
                boolean isMax = true;
                
                for (int i = 0; i < q.size(); i++) {
                    if (q.get(i)[1] > out[1]) {
                        isMax = false;
                    }
                }
                
                if (isMax) {
                    cnt++;
                    if (out[0] == idx) {
                        sb.append(cnt + "\n");
                        break;
                    }
                }
                if (!isMax) {
                    q.add(out);
                }
            }
            
        }
        
        System.out.print(sb);
    }
}
