import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int maxPrize = 0;
        
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prize = 0;
            
            int dice1 = Integer.parseInt(st.nextToken());
            int dice2 = Integer.parseInt(st.nextToken());
            int dice3 = Integer.parseInt(st.nextToken());
            ArrayList<Integer> dices = new ArrayList<>(List.of(dice1, dice2, dice3));

            Collections.sort(dices);
            if (dices.get(0) == dices.get(2)) {
                prize = 10000 + dices.get(0) * 1000;
            } else if (dices.get(0) == dices.get(1) || dices.get(1) == dices.get(2)) {
                prize = 1000 + dices.get(1) * 100;
            } else {
                prize = dices.get(2) * 100;
            }
            
            if (prize > maxPrize) {
                maxPrize = prize;
            }
        }
        
        System.out.println(maxPrize);
    }
}
