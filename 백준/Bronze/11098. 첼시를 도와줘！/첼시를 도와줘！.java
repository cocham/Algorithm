import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test; t++){
            int pNum = Integer.parseInt(br.readLine());
            
            long maxPrice = 0;
            String bestPlayer = "";
            
            for (int p = 0; p < pNum; p++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long price = Long.parseLong(st.nextToken());
                String player = st.nextToken();
                
                if (price > maxPrice) {
                    maxPrice = price;
                    bestPlayer = player;
                }
            }
            sb.append(bestPlayer).append('\n'); 
        }
        System.out.print(sb);
    }           
}
