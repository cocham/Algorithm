import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
    static class Country implements Comparable<Country> {
        int Id;
        private int goldCnt;
        private int silverCnt;
        private int bronzeCnt;

        public Country(int countryId, int goldCnt, int silverCnt, int bronzeCnt) {
            this.Id = countryId;
            this.goldCnt = goldCnt;
            this.silverCnt = silverCnt;
            this.bronzeCnt = bronzeCnt;
        }

        @Override
        public int compareTo(Country c) {
            if (this.goldCnt != c.goldCnt) {
                return c.goldCnt - this.goldCnt;
            }
            if (this.silverCnt != c.silverCnt) {
                return c.silverCnt - this.silverCnt;
            }
            return c.bronzeCnt - this.bronzeCnt;
        }

        public boolean isSameRecord(Country c) {
            return this.goldCnt == c.goldCnt && this.silverCnt == c.silverCnt && this.bronzeCnt == c.bronzeCnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int countryId = Integer.parseInt(st.nextToken());
            int goldCnt = Integer.parseInt(st.nextToken());
            int silverCnt = Integer.parseInt(st.nextToken());
            int bronzeCnt = Integer.parseInt(st.nextToken());

            Country country = new Country(countryId, goldCnt, silverCnt, bronzeCnt);
            countries.add(country);
        }

        Collections.sort(countries);
        Country target = countries.stream()
                                .filter(c -> c.Id == K)
                                .findFirst()
                                .orElseThrow();

        long betterCount = countries.stream()
                .filter(c -> c.compareTo(target) < 0)
                .count();

        System.out.println(betterCount + 1);
    }
}