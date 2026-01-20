import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static boolean[] used = new boolean[26];
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            sb.append(process(line)).append('\n');
        }

        System.out.print(sb);
    }

    static String process(String line) {
        String[] words = line.split(" ");
        int wordIdx = fstStep(words);

        if (wordIdx != -1) {
            return formatFirst(words, wordIdx);
        } 

        int charIdx = secStep(line);
        if (charIdx != -1) {
            return formatAny(line, charIdx);
        }
        
        return line;
    }

    static int fstStep(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char fstSpell = Character.toLowerCase(words[i].charAt(0));
            if (!used[fstSpell - 'a']) {
                used[fstSpell - 'a'] = true;
                return i;
            }
        }
        return -1;
    }

    static int secStep(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ' ') continue;

            char lower = Character.toLowerCase(c);
            if (!used[lower - 'a']) {
                used[lower - 'a'] = true;
                return i;
            }
        }
        return -1;
    }

    static String formatFirst(String[] words, int targetIdx) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == targetIdx) {
                res.append("[").append(words[i].charAt(0))
                .append("]")
                .append(words[i].substring(1));
            } else {
                res.append(words[i]);
            }
            if (i < words.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    static String formatAny(String line, int targetIdx) {
        StringBuilder res = new StringBuilder();

        res.append(line.substring(0, targetIdx))
            .append("[")
            .append(line.charAt(targetIdx))
            .append("]")
            .append(line.substring(targetIdx + 1));

        return res.toString();
    }
    
}