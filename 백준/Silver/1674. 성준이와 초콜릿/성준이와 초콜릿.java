import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Food {
        int type;
        int time;
        double quantity;

        Food(int type, int time, double quantity) {
            this.type = type;
            this.time = time;
            this.quantity = quantity;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Food> foods = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        String line = "";
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            if (!st.hasMoreTokens()) break;

            String input = st.nextToken();

            if (input.equals("Query")) {
                int T = Integer.parseInt(st.nextToken());
                times.add(T);
            } else if (input.equals("Chocolate")) {
                int T = Integer.parseInt(st.nextToken());
                double N = Double.parseDouble(st.nextToken());
                foods.add(new Food(0, T, N));
            } else if (input.equals("Coffee")) {
                int T = Integer.parseInt(st.nextToken());
                double N = Double.parseDouble(st.nextToken());
                foods.add(new Food(1, T, N));
            }
        }

        Collections.sort(times);
        
        for (int time : times) {
            double totalR = 0.0;

            for (Food food : foods) {
                if (food.time > time) continue;

                int dt = time - food.time;
                double currentR = 0.0;

                if (food.type == 0) {
                    currentR += (8 * food.quantity) - (dt / 12.0);
                } else {
                    currentR += (2 * food.quantity) - ((double)dt * dt / 79.0);
                }

                if (currentR > 0) {
                    totalR += currentR;
                }
            }

            double result = Math.max(1.0, totalR);

            sb.append(time).append(" ")
                .append(String.format("%.1f", result))
                .append('\n');
        }

    
        System.out.print(sb);
    } 
}