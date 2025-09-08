import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Map<String, List<String>> couples = new HashMap<>();
        
        int people = Integer.parseInt(br.readLine());
        for (int p = 0; p < people; p++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            String ring = st.nextToken();
            if (!ring.equals("-")) {
                couples.computeIfAbsent(ring, k -> new ArrayList<>()).add(person);
            }
        }
        
        Collection<List<String>> valueLists = couples.values(); 
        for (List<String> list : valueLists) {
            if (list.size() == 2) {
                count++;
                sb.append(list.get(0)).append(" ").append(list.get(1)).append('\n');
            }
        }
        
        System.out.println(count);
        System.out.print(sb);
    }
}