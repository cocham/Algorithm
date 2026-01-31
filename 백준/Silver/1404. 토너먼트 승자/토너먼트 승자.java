import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        double[][] arr = new double[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
                arr[j][i] = 1.0 - arr[i][j];
            }
        }
        
        double[] round1 = new double[8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                round1[i] = arr[i][i + 1];
            } else {
                round1[i] = arr[i][i - 1];
            }
        }
        
        double[] round2 = new double[8];
        for (int i = 0; i < 8; i++) {
            double sum = 0; 
            if (i == 0 || i == 1) {
                for (int j = 2; j <= 3; j++) {
                    sum += round1[j] * arr[i][j];
                }
            } else if (i == 2 || i == 3) {
                for (int j = 0; j <= 1; j++) {
                    sum += round1[j] * arr[i][j];
                }
            } else if (i == 4 || i == 5) {
                for (int j = 6; j <= 7; j++) {
                    sum += round1[j] * arr[i][j];
                }
            } else if (i == 6 || i == 7) {
                for (int j = 4; j <= 5; j++) {
                    sum += round1[j] * arr[i][j];
                }
            }
            round2[i] = sum * round1[i];
        }
        
        double[] round3 = new double[8];
        for (int i = 0; i < 8; i++) {
            double sum = 0; 
            if (i < 4) {
                for (int j = 4; j <= 7; j++) {
                    sum += round2[j] * arr[i][j];
                }
            } else {
                for (int j = 0; j <= 3; j++) {
                    sum += round2[j] * arr[i][j];
                }
            }
            round3[i] = sum * round2[i];
        }
        
        for (int i = 0; i < 8; i++) {
            sb.append(round3[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}