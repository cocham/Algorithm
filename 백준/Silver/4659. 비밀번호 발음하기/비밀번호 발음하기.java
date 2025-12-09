import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static class PassWord {
    private String passWord = "";
    private final String vowels = "aeiou";

    public PassWord(String passWord) {
        if (isAcceptable(passWord)) {
            this.passWord = passWord;
        }
    }

    private boolean isAcceptable(String passWord) {
        if (isContainVowel(passWord) && !isSequenceSpellType(passWord) && !isSequenceSpells(passWord)) {
            return true;
        }
        return false;
    }

    public boolean isContainVowel(String passWord) {
        if (passWord.contains("a")
                || passWord.contains("e")
                || passWord.contains("i")
                || passWord.contains("o")
                || passWord.contains("u")) {
            return true;
        }
        return false;
    }

    public boolean isSequenceSpellType(String passWord) {
        String[] str = passWord.split("");
        boolean flag = false;
        for (int i = 0; i <= str.length - 3; i++) {
            if (flag) {
                break;
            }

            String c1 = str[i];
            String c2 = str[i + 1];
            String c3 = str[i + 2];

            if (vowels.contains(c1) && vowels.contains(c2) && vowels.contains(c3)) {
                flag = true;
            } else if (!vowels.contains(c1) && !vowels.contains(c2) && !vowels.contains(c3)) {
                flag = true;
            }
        }

        return flag;
    }

    public boolean isSequenceSpells(String passWord) {
        String[] str = passWord.split("");
        boolean flag = false;
        for (int i = 0; i <= str.length - 2; i++) {
            String c1 = str[i];
            String c2 = str[i + 1];
            String c1c2 = c1 + c2;

            if (c1.equals(c2)) {
                if (flag) break;
                if (!c1c2.equals("ee") && !c1c2.equals("oo")) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    public String getPassWord() {
        return passWord;
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String pw = br.readLine();
            if (pw.equals("end")) {
                break;
            }

            PassWord passWord = new PassWord(pw);
            if (passWord.getPassWord().isBlank()) {
                sb.append("<").append(pw).append(">").append(" is not acceptable.").append('\n');
                continue;
            }
            sb.append("<").append(pw).append(">").append(" is acceptable.").append('\n');
        }

        System.out.print(sb);
    }
}

