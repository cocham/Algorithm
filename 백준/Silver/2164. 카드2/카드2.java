import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        
        while(queue.size() > 1) {
            queue.poll();
            queue.addLast(queue.poll());
        }
        
        System.out.println(queue.poll());
        
    }
}