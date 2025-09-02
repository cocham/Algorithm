import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(br.readLine());
        
        Map<Integer,int[]> box = new HashMap<>();
        
        for (int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int[] b = box.computeIfAbsent(p, k -> new int[]{r, r, c, c});
            if (r < b[0]) b[0] = r;
            if (r > b[1]) b[1] = r;
            if (c < b[2]) b[2] = c;
            if (c > b[3]) b[3] = c;
        }
        
        int bestId = -1;
        long bestArea = -1;
        
        for (Map.Entry<Integer, int[]> e : box.entrySet()){
             int id = e.getKey();
             int[] b = e.getValue();
             long area = (long)(b[1] - b[0] + 1) * (long)(b[3] - b[2] + 1);
             if (area > bestArea || (area == bestArea && id < bestId)){
                 bestId = id;
                 bestArea = area;
             }
        }
        System.out.println(bestId + " " + bestArea);
    }
}