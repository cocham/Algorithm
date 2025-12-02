import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] obs = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            obs[n] = true;
        }
        
        boolean isPass = false;  
        int ans = -1;  
        for (int k = 1; ; k++) {
            boolean[] visited = new boolean[N + 1];
            int pos = 1;    

            if (isPass) {
                break;
            }

            while(true) {
                if (pos == Z) {
                    isPass = true;
                    ans = k;
                    break;
                }
                
                if (visited[pos]) {
                    break;
                } 

                if (obs[pos]) {
                    break;
                }
                visited[pos] = true;
                
                pos += k;  
                if (pos > N) {
                    pos -= N;
                }
            }
        }
        
        System.out.print(ans);
    }
}