import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> works = new LinkedHashMap<String, Integer>() {{
            put("Re", 0);
            put("Pt", 0);
            put("Cc", 0);
            put("Ea", 0);
            put("Tb", 0);
            put("Cm", 0);
            put("Ex", 0);
        }};
        
        int total = 0;
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            
            while(st.hasMoreTokens()) {
                String work = st.nextToken();
                total += 1;
                if(works.containsKey(work)) {
                    works.put(work, works.get(work) + 1);
                }

            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String key : works.keySet()) {
            int work = works.get(key);
            double ratio = (double)work / total;
            sb.append(key).append(' ').append(work).append(' ').append(String.format("%.2f", ratio)).append('\n');
        }
        sb.append("Total ").append(total).append(" 1.00").append('\n');
        
        System.out.print(sb);
    }
}