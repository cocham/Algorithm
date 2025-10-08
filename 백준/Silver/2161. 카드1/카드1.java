import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            nums.addLast(i);
        }
        
        while(nums.size() > 1) {
            int top = nums.removeFirst();
            sb.append(top).append(' ');
            int newTop = nums.removeFirst();
            nums.addLast(newTop);
        }
        
        sb.append(nums.peekFirst());
        System.out.print(sb);
    }
}