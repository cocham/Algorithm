import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                maxDp[0] = minDp[0] = n0;
                maxDp[1] = minDp[1] = n1;
                maxDp[2] = minDp[2] = n2;
            } else {
                int beforeMax0 = maxDp[0], beforeMax1 = maxDp[1], beforeMax2 = maxDp[2];
                int beforeMin0 = minDp[0], beforeMin1 = minDp[1], beforeMin2 = minDp[2];
                
                maxDp[0] = Math.max(beforeMax1, beforeMax0) + n0;
                maxDp[1] = Math.max(Math.max(beforeMax0, beforeMax1), beforeMax2) + n1;
                maxDp[2] = Math.max(beforeMax1, beforeMax2) + n2;
                
                minDp[0] = Math.min(beforeMin0, beforeMin1) + n0;
                minDp[1] = Math.min(Math.min(beforeMin0, beforeMin1), beforeMin2) + n1;
                minDp[2] = Math.min(beforeMin1, beforeMin2) + n2;
            }
        }
        
        System.out.print(Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) 
                         + " " +
                        Math.min(Math.min(minDp[0], minDp[1]), minDp[2]));
    }
}
