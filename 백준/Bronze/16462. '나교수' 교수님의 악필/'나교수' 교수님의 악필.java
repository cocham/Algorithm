import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        int average = 0;
        
        long allScore = 0;
        for (int i = 0; i < n; i++) {
            String score = br.readLine();
            if (score.equals("100")) {
                allScore += 100;
            } else {
                score = score.replaceAll("[06]", "9");
                allScore += Long.parseLong(score);
            }
        }
        
        System.out.println(Math.round((double) allScore / n));
    }
}