import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> line = new ArrayDeque<>();
        Map<Integer, List<Integer>> lines = new HashMap<>();
        
        int lineLen = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            if (st.countTokens() == 2) {
                st.nextToken();
                int student = Integer.parseInt(st.nextToken());
                line.add(student);
                
                int currLen = line.size();
                if (currLen >= lineLen) {
                    lineLen = currLen;
                    lines.computeIfAbsent(lineLen, k -> new ArrayList<>()).add(student);
                    }
            } else {
                line.poll();
            } 
        }
        
        int maxKey = Collections.max(lines.keySet());
        int minStudent = Collections.min(lines.get(maxKey));
        StringBuilder sb = new StringBuilder();

        sb.append(maxKey).append(' ').append(minStudent).append('\n');
        System.out.print(sb);
    }
}