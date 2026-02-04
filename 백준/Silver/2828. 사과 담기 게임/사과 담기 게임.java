import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());
        
        int start = 1;
        int end = M;
        int move = 0;
        
        for (int j = 0; j < J; j++) {
            int drop = Integer.parseInt(br.readLine());
            if (drop < start) {
                int curMove = start - drop;
                start -= curMove;
                end -= curMove;
                move += curMove;
            } else if (drop > end) {
                int curMove = drop - end;
                move += curMove;
                end += curMove;
                start += curMove;
            }
        }

        System.out.print(move);
        
    }
}
