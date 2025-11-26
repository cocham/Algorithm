import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] pillar = new int[1001];
        StringTokenizer st;
        
        int maxH = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            if (h > maxH) {
                maxH = h;
                maxIdx = l;
            }
            
            pillar[l] = h;
        }
        
        
        int sum = 0;

        int curLeftMaxH = 0;
        for (int i = 0; i < maxIdx; i++) {
            if (pillar[i] > curLeftMaxH) {
                curLeftMaxH = pillar[i];
            }
            sum += curLeftMaxH;
        }
        
        int curRightMaxH = 0;
        for (int i = 1000; i > maxIdx; i--) {
            if (pillar[i] > curRightMaxH) {
                curRightMaxH = pillar[i];
            }
            sum += curRightMaxH;
        }
        
        sum += maxH;
        System.out.println(sum);
    } 
}