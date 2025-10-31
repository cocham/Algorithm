import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Entry {
        String word;
        String meaning;

        Entry(String w, String m) {
            this.word = w;
            this.meaning = m;
        };
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<Character, List<Entry>> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            dict.computeIfAbsent(key.charAt(0), k -> new ArrayList<Entry>())
            .add(new Entry(key, value));
        }
        
        for (List<Entry> list : dict.values()) {
            list.sort(Comparator.comparing(e -> e.word));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringBuilder part = new StringBuilder();
            String sentence = br.readLine();
            boolean match = false;

            for (int idx = 0; idx < sentence.length(); idx++) {
                char c = sentence.charAt(idx);
                List<Entry> values = dict.get(c);
                if (values == null) continue;

                for (Entry e: values) {
                    int end = idx + e.word.length();
                    if (end <= sentence.length() && sentence.regionMatches(idx, e.word, 0, e.word.length())) {
                        part.append(e.meaning);
                        match = true;
                    }
                }
            }

            if (!match) {
                sb.append("-1\n");
            } else {
                sb.append(part).append('\n');
            }
        }
        
        System.out.print(sb);
        
    }
}