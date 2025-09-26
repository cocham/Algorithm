import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, ArrayList<Integer>> promises = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String sunbae = st.nextToken();
            int week = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int needMoney = Integer.parseInt(st.nextToken());
            ArrayList<Integer> promiseDetails = new ArrayList<>();
            promises.put(sunbae, new ArrayList<>(Arrays.asList(week, day, needMoney)));
        }
        
        boolean[][] visited = new boolean[11][7];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String sunbae = st.nextToken();
            int haveMoney = Integer.parseInt(st.nextToken());
            
            ArrayList<Integer> p = promises.get(sunbae);
            if (p != null) {
                int needMoney = p.get(2);
                if (needMoney <= haveMoney) {
                    int week = p.get(0);
                    int day = p.get(1);
                    visited[week][day] = true;
                }
            }
        }
        
        int max = 0;
        int eat = 0;
        
        for (int w = 1; w <= 10; w++) {
            for (int d = 0; d < 7; d++) {
                if (visited[w][d]) {
                    eat++;
                } else {
                    if (eat > max) {
                        max = eat;
                    }
                    eat = 0;
                }
            }
        }

        if (eat > max) {
            max = eat;
        }

        System.out.print(max);
    }
}   