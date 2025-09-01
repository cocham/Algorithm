import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 1; k <= 4; k++) map.put(k, 0);
        int fstgrade = 0;
        int cnt = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int grade = Integer.parseInt(st.nextToken());
            int cls = Integer.parseInt(st.nextToken());
            if (grade > 1){
                map.put(cls, map.getOrDefault(cls, 0) + 1);
            }else{
                fstgrade++;
            }
        }
        System.out.println(map.get(1) + map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(fstgrade);
    }
}