import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        int[] eatTimes = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            eatTimes[i] = Integer.parseInt(br.readLine());
        }
        
        int target = n - s;
        int eaten = 0;
        int answer = -1;
        
        int time = 0;
        while (eaten < target) {
            for (int i = 1; i <= m; i++) {
                if (time % eatTimes[i] == 0) {
                    eaten ++;
                
                if (eaten == target) {
                    answer = i;
                    break;
                    }
                }
            }
            time++;
        }
    
    System.out.println(answer);
    }   
}