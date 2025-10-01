import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Deque<String> line = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            line.addLast(br.readLine());
        }
        

        while(line.size() > 1) {
            String p = line.removeFirst();
            String[] person =  p.split(" ");
            int rotation = Integer.parseInt(person[1]) - 1;
            
            for (int i = 0; i < rotation; i++) {
                String peek = line.removeFirst();
                line.addLast(peek);
            }

            line.removeFirst();
        }
        
        String[] ans = line.peek().split(" ");

        System.out.print(ans[0]);
    }
}