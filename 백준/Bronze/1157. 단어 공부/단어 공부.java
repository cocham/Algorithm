import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toLowerCase();
        
        Map<Character, Integer> spell = new HashMap<>();
        for(char c : line.toCharArray()) {
            spell.put(c, spell.getOrDefault(c, 0) + 1);
        }
        
        int maxCnt = 0;
        char maxChar = '?';
        for (Map.Entry<Character, Integer> entry : spell.entrySet()) {
            char curChar = entry.getKey();
            int curCnt = entry.getValue();

            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                maxChar = curChar;
            } else if (curCnt == maxCnt) {
                maxChar = '?';
            }
        }
        
        System.out.print(String.valueOf(maxChar).toUpperCase());
    }
}