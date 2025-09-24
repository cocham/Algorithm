import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isPossible = true;
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        outer: for (int i = 0; i < m; i++) {
            int booksNum = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int bottomNum = Integer.parseInt(st.nextToken());
            for (int j = 1; j < booksNum; j++) {
                int topNum = Integer.parseInt(st.nextToken());
                if (bottomNum < topNum) {
                    isPossible = false;
                    break outer;
                }
                
                bottomNum = topNum;
                }
            }

        if (isPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}