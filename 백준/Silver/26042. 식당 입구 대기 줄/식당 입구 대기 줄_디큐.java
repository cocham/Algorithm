import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> lines = new ArrayDeque<>();
        int maxLine = 0;
        int minNum = 100000;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
                
            if (type == 1) {
                int num = Integer.parseInt(st.nextToken());
                lines.addLast(num);
                
                int currLen = lines.size();
                if (maxLine < currLen) {
                    maxLine = currLen;
                    minNum = lines.peekLast();
                } else if (maxLine == currLen) {
                    minNum = Math.min(minNum, lines.peekLast());
              } 
            } else if (type == 2) {
               lines.pollFirst();
            }  
        }
        sb.append(maxLine).append(' ').append(minNum).append('\n');
        System.out.print(sb);
    }
}
