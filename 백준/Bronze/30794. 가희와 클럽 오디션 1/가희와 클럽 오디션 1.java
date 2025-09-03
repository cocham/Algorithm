import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Integer> SCORE_TABLE = Map.of(
        "miss", 0,
        "bad", 200,
        "cool", 400,
        "great", 600,
        "perfect", 1000
    );
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int level = Integer.parseInt(st.nextToken());
        String verdict = st.nextToken();
        
        int score = SCORE_TABLE.get(verdict);
        System.out.println(level * score);
        
    }
}