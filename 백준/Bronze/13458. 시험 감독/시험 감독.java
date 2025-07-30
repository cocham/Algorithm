import java.io.*;
import java.util.*;

public class Main{ 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine().trim());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToLong(Long::parseLong)
                          .toArray();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken()); 
        long C = Long.parseLong(st.nextToken());
        
        long answer = 0;
        for (long n : arr){
            answer += 1;
            
            if (n > B){
                long rem = n - B;
                answer += (rem / C);
                if (rem % C != 0) answer += 1;
            }
        }
        System.out.println(answer);
    }
}