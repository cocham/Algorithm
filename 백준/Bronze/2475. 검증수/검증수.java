import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long sum = 0;
        for (int n : arr){
            sum += n * n;
        }
        bw.write(Long.toString(sum % 10));
        bw.flush();
        bw.close();
        br.close();
    }
}