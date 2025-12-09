import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Scores {
    private List<Integer> scores;

    public Scores(int n) {
        this.scores = new ArrayList<>(n);
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public void sortScores() {
        Collections.sort(scores, Collections.reverseOrder());
    }

    public int getLastPlace() {
        return scores.get(scores.size() - 1);
    }

    public List<Integer> getScores() {
        return List.copyOf(scores);
    }
}
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int taesuScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine());
        Scores scores = new Scores(p);
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores.addScore(score);
        }

        if (n == p) {
            scores.sortScores();
            if (taesuScore <= scores.getLastPlace()) {
                System.out.println("-1");
                return;
            }
        }

        int betterThanTaesu = (int) scores.getScores().stream()
                .filter(score -> score > taesuScore)
                .count();

        int place = betterThanTaesu + 1;
        System.out.println(place);
    }
}