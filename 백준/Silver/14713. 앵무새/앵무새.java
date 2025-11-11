import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Queue<String>> sentences = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            Queue<String> q = new LinkedList<>();
            String[] sentence = br.readLine().split(" ");
            for (int j = 0; j < sentence.length; j++) {
                q.offer(sentence[j]);
            }
            sentences.add(q);
        }
        
        boolean flg = true;
        for (String s : br.readLine().split(" ")) {
            boolean matched = false;
            for (int i = 0; i < sentences.size(); i++) {
                Queue<String> q  = sentences.get(i);
                if (q.peek() != null && q.peek().equals(s)){
                    q.poll();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                flg = false;
                break;
            }
        }

        boolean allEmpty = sentences.stream().allMatch(Queue::isEmpty);
        if (flg && allEmpty) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
            
    }
} 