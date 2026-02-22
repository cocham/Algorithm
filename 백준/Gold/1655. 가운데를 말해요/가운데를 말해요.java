import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> leftQ = new PriorityQueue<>((a , b) -> b - a);
        PriorityQueue<Integer> rightQ =  new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (leftQ.size() == rightQ.size()) {
                leftQ.add(n);
            } else {
                rightQ.add(n);
            }
            
            if (!rightQ.isEmpty() && leftQ.peek() > rightQ.peek()) {
                int leftSide = leftQ.poll();
                int rightSide = rightQ.poll();
                
                rightQ.add(leftSide);
                leftQ.add(rightSide);
            }
            
            sb.append(leftQ.peek()).append('\n');
        }
        
        System.out.print(sb);
    }    
}