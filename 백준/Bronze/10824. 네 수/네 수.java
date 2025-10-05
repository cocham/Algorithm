import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long aplusB = Long.parseLong(st.nextToken() + st.nextToken());
        long cplusD = Long.parseLong(st.nextToken() + st.nextToken());
        
        System.out.print(aplusB + cplusD);
    }
}