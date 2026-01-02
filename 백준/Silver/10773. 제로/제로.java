import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                queue.pollLast();
            } else {
                queue.addLast(n);
            }
        }
        
        int qSum = queue.stream()
            .mapToInt(Integer::intValue)
            .sum();
        
        System.out.println(qSum);
    }
}