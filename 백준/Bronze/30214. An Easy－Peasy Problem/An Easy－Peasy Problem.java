import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fstHalf = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        if (fstHalf * 2 >= end) {
            System.out.println("E");
        } else {
            System.out.println("H");
        }
    }
}