import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String fstLine = br.readLine();
        int idx = Integer.parseInt(br.readLine());
        
        bw.write(fstLine.charAt(idx - 1));
        bw.flush();
        
        br.close();
        bw.close();
    }
}
