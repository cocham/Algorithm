import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());        
        for (int i = 0; i < 2 * N; i++) dq.addLast(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++){
            int j = Integer.parseInt(st.nextToken());
            for (int i = 0; i < j - 1; i++){
                dq.addLast(dq.removeFirst());
            }
            sb.append(dq.peekFirst());
            sb.append(' ');
        }
        
        System.out.println(sb);
    }
}