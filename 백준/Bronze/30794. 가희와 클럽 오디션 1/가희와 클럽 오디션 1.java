import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("miss", 0);
        hashMap.put("bad", 200);
        hashMap.put("cool", 400);
        hashMap.put("great", 600);
        hashMap.put("perfect", 1000);
        
        int lv = Integer.parseInt(st.nextToken());
        String verdict = st.nextToken();
        
        System.out.println(lv * hashMap.get(verdict));
        
    }
}