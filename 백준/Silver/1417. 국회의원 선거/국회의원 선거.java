import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candidateCnt = Integer.parseInt(br.readLine());
        int dasomVotes = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < candidateCnt - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        int buy = 0;
        
        if (candidateCnt == 1) {
            System.out.println(buy);
            return;
        }
        
        while (pq.peek() >= dasomVotes) {
            int votes = pq.poll();
            votes--;
            dasomVotes++;
            buy++;
            pq.add(votes);
        }
        
        System.out.println(buy);
    }
}