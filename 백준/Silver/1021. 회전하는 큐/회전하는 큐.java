import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
            
        int[] idx = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            dq.addLast(i);
        }
        
        int answer = 0;
        for(int n : idx){
            int pos = 0;
            for (int x : dq){
                if (x == n) break;
                pos++;
            }
            
            int cnt = Math.min(pos, dq.size() - pos);
            if (cnt == pos){
                for (int i = 0; i < cnt; i++){
                    dq.addLast(dq.removeFirst());
                    answer += 1; 
                }
            }
            else {                
                for (int i = 0; i < cnt; i++){
                    dq.addFirst(dq.removeLast());
                    answer += 1;
                }
            }
            dq.removeFirst();   
       }
       System.out.println(answer);
    }
}