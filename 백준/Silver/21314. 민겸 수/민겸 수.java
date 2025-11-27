import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s[] = br.readLine().split("");
        
        String max = "";
        int Mcnt = 0;
        for (String spell : s) {
            if (spell.equals("M")) {
                Mcnt ++;
            }
            if (spell.equals("K")) {
                if (Mcnt != 0) {
                    max += "5" + "0".repeat(Mcnt);
                } else {
                    max += "5";
                }
                Mcnt = 0;
            }
        }
        
        if (Mcnt != 0) {
            max += "1".repeat(Mcnt);
        }
    
        String min = "";
        int mcnt = 0;
        for (String spell : s) {
            if (spell.equals("M")) {
                mcnt ++;
            }
            if (spell.equals("K")) {
                if (mcnt != 0) {
                    if (mcnt == 1) {
                        min += "1";
                    } else {
                        min += "1" + "0".repeat(mcnt - 1);
                    }
                } 
                min += "5";
                mcnt = 0;
            }
        }
        if (mcnt != 0) {
            if (mcnt == 1) {
                min += "1";
            } else {
                min += "1" + "0".repeat(mcnt - 1);
            }
        }
        
        System.out.println(max);
        System.out.println(min);
    } 
}