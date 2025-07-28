import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] arr = br.readLine().split(" ");
        long A = Long.parseLong(arr[0]);
        long B = Long.parseLong(arr[1]);
        
        bw.write(Long.toString((A + B) * (A - B)));
        bw.flush();
        bw.close();
        br.close();
            
    }
}