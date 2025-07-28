import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++){
            String s = br.readLine();
            bw.write("" + s.charAt(0) + s.charAt(s.length() - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}