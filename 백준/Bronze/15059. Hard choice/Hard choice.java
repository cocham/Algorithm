import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        
        int chickenN = Integer.parseInt(st.nextToken());
        int beefN = Integer.parseInt(st.nextToken());
        int pastaN = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int requeChicken = Integer.parseInt(st.nextToken());
        int requeBeef = Integer.parseInt(st.nextToken());
        int requePasta = Integer.parseInt(st.nextToken());
        
        if (requeChicken > chickenN) {
            cnt += (requeChicken - chickenN);
        }
        if (requeBeef > beefN) {
            cnt += (requeBeef - beefN);
        }
        if (requePasta > pastaN) {
            cnt += (requePasta - pastaN);
        }
        
        System.out.println(cnt);
    }
}