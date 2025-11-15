import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> heights = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            long H = Integer.parseInt(br.readLine());
            heights.add(H);
        }
        
        int c = 0;
        while (t > 0 && !heights.isEmpty()) {
            long k = heights.peek();
            if (k < h) {
                break;
            }

            if (k == 1) {
                break;
            }

            if (k >= h) {
                k = heights.poll();
                heights.add((long) Math.floor(k / 2));
                t--;
                c++;
            }
        }
        
        long ans = heights.peek();
        if (ans >= h) {
            System.out.println("NO");
            System.out.println(ans);
        } else {
            System.out.println("YES");
            System.out.println(c);
        }
    }
}