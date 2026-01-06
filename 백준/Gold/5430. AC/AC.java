import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            String[] orders = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            
            Deque<Integer> nums = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (st.hasMoreTokens()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            
            boolean isReversed = false;
            boolean isError = false;
            for (String command : orders) {
                if (command.equals("R")) {
                    isReversed = !isReversed;
                } else if (command.equals("D")) {
                    if (nums.isEmpty()) {
                        isError = true;
                        break;
                    } else if (isReversed) {
                        nums.pollLast();
                    } else {
                        nums.poll();
                    }
                }
            }
            
            if (isError) {
                sb.append("error").append('\n');
            } else {
                sb.append('[');
                while(!nums.isEmpty()) {
                    if (isReversed) {
                        sb.append(nums.pollLast());
                        while (!nums.isEmpty()) {
                            sb.append(',').append(nums.pollLast());
                        }
                    } else {
                        sb.append(nums.poll());
                        while (!nums.isEmpty()) {
                            sb.append(',').append(nums.poll());
                        }
                    }
                } 
                sb.append(']').append('\n');
            }
        }

        System.out.print(sb);
    } 
}