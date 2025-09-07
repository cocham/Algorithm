import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long amount = Long.parseLong(st.nextToken());
        int items = Integer.parseInt(st.nextToken());
        int buyItems = Integer.parseInt(st.nextToken());
        Map<String, Long> priceMap = new HashMap<>();
        
        for (int i = 0; i < items; i++) {
            st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            priceMap.put(item, price);   
        }
        
        long needMoney = 0;
        boolean isPossible = true;
        for (int i = 0; i < buyItems; i++) {
            String wishItem = br.readLine();
            needMoney += priceMap.get(wishItem);
            if (needMoney > amount) {
                isPossible = false;
                break;
            }
        }
        if (isPossible){
            System.out.println("acceptable");
        } else {
            System.out.println("unacceptable");
        }
    }
}