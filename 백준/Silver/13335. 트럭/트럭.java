import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        Queue<Integer> waiting = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            waiting.add(Integer.parseInt(st.nextToken()));
        }
        
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        
        int currentWeight = 0;
        int time = 0;
        while(!bridge.isEmpty()) {
            time++;
            
            currentWeight -= bridge.poll();
            
            if (!waiting.isEmpty()) {
                int next = waiting.peek();
                
                if (currentWeight + next <= l) {
                    waiting.poll();
                    currentWeight += next;
                    bridge.add(next);
                } else {
                    bridge.add(0);
                }
            }
        }
        
        System.out.println(time);
    }
}