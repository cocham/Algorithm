import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] grounds = new int[257];
        Arrays.fill(grounds, 0);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int idx = Integer.parseInt(st.nextToken());
                grounds[idx]++;
            }
        }
        
        int bestHeight = -1;
        int minTime = Integer.MAX_VALUE;

        for (int target = 0; target < 257; target++) {
            int removeBlocks = 0;
            int addBlocks = 0;

            for (int h = 0; h < 257; h++) {
                if (grounds[h] == 0) continue;

                int diff = h - target;
                
                if (diff < 0) {
                    addBlocks += (-diff) * grounds[h];
                } else if (diff > 0) {
                    removeBlocks += diff * grounds[h];
                }
            }
            
            if (b + removeBlocks >= addBlocks) {
                int time = (removeBlocks * 2) + addBlocks;
                
                if (time <= minTime) {
                    minTime = time;
                    bestHeight = target;
                }
            }
        }

        System.out.println(minTime + " " + bestHeight);
    
    }
}