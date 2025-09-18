import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lampN = Integer.parseInt(st.nextToken());
        int guardN = Integer.parseInt(st.nextToken());
        int patrolN = Integer.parseInt(st.nextToken());
        
        Map<String, List<Integer>> patrolMap = new HashMap<>();
        
        for (int i = 0; i < guardN; i++) {
            st = new StringTokenizer(br.readLine());
            String guard = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            List<Integer> list = new ArrayList<>();
            for (int x = a; x <= lampN; x += d) {
                list.add(x);
            } 
            patrolMap.put(guard, list);
        }
        
        boolean[] on = new boolean[lampN + 1];
        for (int i = 0; i < patrolN; i++) {
            String name = br.readLine();
            List<Integer> list = patrolMap.get(name);
            for (int pos : list) {
                on[pos] = !on[pos];
            }
        }
        
        int cnt = 0;
        for (boolean b : on) {
            if (b) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}