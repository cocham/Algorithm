import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // cnt[subject][fruit][color], 각 차원 0..2 (kor/eng/math, apple/pear/orange, red/blue/green)
        int[][][] cnt = new int[3][3][3];

        // N명 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = idxSub(st.nextToken());   // 0..2
            int f = idxFruit(st.nextToken()); // 0..2
            int c = idxColor(st.nextToken()); // 0..2
            cnt[s][f][c]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String qs = st.nextToken();
            String qf = st.nextToken();
            String qc = st.nextToken();

            // 각 축의 탐색 범위 결정 (‘-’이면 0..2, 아니면 고정 인덱스)
            int s0, s1, f0, f1, c0, c1;

            if (qs.equals("-")) { s0 = 0; s1 = 2; } else { s0 = s1 = idxSub(qs); }
            if (qf.equals("-")) { f0 = 0; f1 = 2; } else { f0 = f1 = idxFruit(qf); }
            if (qc.equals("-")) { c0 = 0; c1 = 2; } else { c0 = c1 = idxColor(qc); }

            int sum = 0;
            for (int s = s0; s <= s1; s++) {
                for (int f = f0; f <= f1; f++) {
                    for (int c = c0; c <= c1; c++) {
                        sum += cnt[s][f][c];
                    }
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    private static int idxSub(String s) {
        switch (s) {
            case "kor":  return 0;
            case "eng":  return 1;
            case "math": return 2;
            default:     throw new IllegalArgumentException("subject: " + s);
        }
    }

    private static int idxFruit(String s) {
        switch (s) {
            case "apple":  return 0;
            case "pear":   return 1;
            case "orange": return 2;
            default:       throw new IllegalArgumentException("fruit: " + s);
        }
    }

    private static int idxColor(String s) {
        switch (s) {
            case "red":   return 0;
            case "blue":  return 1;
            case "green": return 2;
            default:      throw new IllegalArgumentException("color: " + s);
        }
    }
}
