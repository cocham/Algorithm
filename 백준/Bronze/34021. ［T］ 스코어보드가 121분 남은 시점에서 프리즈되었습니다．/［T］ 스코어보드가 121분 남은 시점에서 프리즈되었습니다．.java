import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testN = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        
        for (int i = 0; i < testN; i++) {
            st = new StringTokenizer(br.readLine());

            int pplNum = Integer.parseInt(st.nextToken());
            int minuate = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
                
            st = new StringTokenizer(br.readLine());
            int freezeTime = left;
            
            for (int j = 0; j < pplNum; j++) {
                int solve = Integer.parseInt(st.nextToken());
                if (solve >= 0) {
                    freezeTime = Math.max(freezeTime, minuate - solve);
                }
            }
            
            sb.append("The scoreboard has been frozen with ")
				.append(freezeTime).append(' ')
				.append(freezeTime == 1 ? "minute" : "minutes")
				.append(" remaining.").append('\n');
		}

		System.out.print(sb);      
        }
    }