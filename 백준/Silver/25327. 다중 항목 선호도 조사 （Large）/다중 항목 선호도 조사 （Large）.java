import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        final String sep = "|";
        final String dash = "-";
        
        Map<String, Integer> allQuest = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            String fruit = st.nextToken();
            String color = st.nextToken();
            
            String[] S = {subject, dash};
            String[] F = {fruit, dash};
            String[] C = {color, dash};
            
            for (String sub : S) {
                for (String fru : F) {
                    for (String col : C) {
                        String key = sub + sep + fru + sep + col;
                        allQuest.put(key, allQuest.getOrDefault(key, 0) + 1);
                    }
                }
            }            
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            String fruit = st.nextToken();
            String color = st.nextToken();
            
            String key = subject + sep + fruit + sep + color;
            int cnt = allQuest.getOrDefault(key, 0);
            
            sb.append(cnt).append('\n');
        }
        
        System.out.print(sb);
    }
}