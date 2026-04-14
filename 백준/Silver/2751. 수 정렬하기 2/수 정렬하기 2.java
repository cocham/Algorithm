import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static boolean[] visited = new boolean[2000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
                
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            visited[n + 1000000] = true;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 2000000; i++) {
            if (visited[i]) {
                sb.append(i - 1000000).append('\n');   
            }
        }

        System.out.print(sb);
    }
}
