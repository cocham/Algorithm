import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int speakLength = br.readLine().length();
        int requireLength = br.readLine().length();
        
        if (speakLength >= requireLength){
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}