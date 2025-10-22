import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        final double gold = 1.618;
        Map<String, Integer> materials = new HashMap<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String material = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            materials.put(material, materials.getOrDefault(material, 0) + amount);
        }

        List<Integer> finalAmounts = new ArrayList<>(materials.values());
        boolean delicious = false;

        OuterLoop: for (int i = 0; i < finalAmounts.size(); i++) {
            for (int j = 0; j < finalAmounts.size(); j++) {
                if (i == j) {
                    continue;
                }
                
                int ai = finalAmounts.get(i);
                int aj = finalAmounts.get(j);

                if ((int)Math.floor(ai * gold) == aj) {
                    delicious = true;
                    break OuterLoop;
                }
            }
        }

        if (delicious) {
            System.out.println("Delicious!");
        } else {
            System.out.println("Not Delicious...");
        }       
    }
}