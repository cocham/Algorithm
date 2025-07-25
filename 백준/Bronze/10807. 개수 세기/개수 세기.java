import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
//import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer :: parseInt)
            .toArray();
        int V = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        for(int n : arr){
            if (n == V){
                cnt += 1;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.newLine();
        
        bw.flush();
        
    }
}