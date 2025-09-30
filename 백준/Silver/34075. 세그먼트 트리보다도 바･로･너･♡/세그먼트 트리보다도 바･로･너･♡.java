import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<String>> algoMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String algo = st.nextToken();
            int diff = Integer.parseInt(st.nextToken());
            algoMap.computeIfAbsent(diff, k -> new ArrayList<>()).add(algo);
        }
        
        for (List<String> list : algoMap.values()) {
            Collections.sort(list);
        }
       
        int m = Integer.parseInt(br.readLine());
        Map<String, List<String>> memberFavs = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int tier = Integer.parseInt(st.nextToken());
            List<String> rec = pickTwo(algoMap, tier);
            memberFavs.put(name, rec);
        }
        
 
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String mem = "";
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String query = st.nextToken();
            
            if (query.equals("-")) {
                mem = name;
                sb.append("hai!").append('\n');
            } else if (query.contains("ga")) {
                List<String> favs = memberFavs.get(mem);
                String fav1 = favs.get(0);
                String fav2 = favs.get(1);
                sb.append(fav2).append(" yori mo ").append(fav1).append('\n');
            }
        }

        System.out.print(sb);
    }
    
    static List<String> pickTwo(TreeMap<Integer, List<String>> algoMap, int tier) {
        List<String> ans = new ArrayList<>();
        
        Integer leftKey = algoMap.floorKey(tier);
        Integer rightKey = algoMap.ceilingKey(tier);
        
        if (leftKey == null) leftKey = rightKey;
        if (rightKey == null) rightKey = leftKey;
        
        Map<Integer, Integer> idx = new HashMap<>();
        
        while (ans.size() < 2) {
            Candidate lc = nextCandidate(algoMap, idx, tier, leftKey);
            Candidate rc = nextCandidate(algoMap, idx, tier, rightKey);
            
            if (lc == null && rc == null) break;
            
            Candidate pick;
            if (lc == null) {
                pick = rc;
            } else if (rc == null) {
                pick = lc;
            } else {
                int cmpDist = Integer.compare(lc.dist, rc.dist);
                if (cmpDist < 0) {
                    pick = lc;
                } else if (cmpDist > 0) {
                    pick = rc;
                } else {
                    int cmpName = lc.name.compareTo(rc.name);
                    pick = (cmpName <= 0) ? lc : rc; 
                }
            }
            
            ans.add(pick.name);
            idx.put(pick.diff, idx.getOrDefault(pick.diff, 0) + 1);
            
            List<String> list = algoMap.get(pick.diff);
            int usedIdx = idx.get(pick.diff);
            if (usedIdx >= list.size()) {
                if (pick.diff <= tier && leftKey != null) {
                    leftKey = algoMap.lowerKey(leftKey);
                }
                if (pick.diff >= tier && rightKey != null) {
                    rightKey = algoMap.higherKey(rightKey);
                }
            }
        }

        return ans;
    }
    
    static Candidate nextCandidate(TreeMap<Integer, List<String>> algoMap, 
                                      Map<Integer, Integer> idx,
                                      int tier,
                                      Integer key) {
        if (key == null) return null;
        
        List<String> list = algoMap.get(key);
        int at = idx.getOrDefault(key, 0);
        
        if (at < list.size()) {
            return new Candidate(key, Math.abs(key - tier), list.get(at));
        }
        return null;
    }
    
    static class Candidate {
        final int diff;
        final int dist;
        final String name;
        Candidate(int diff, int dist, String name) {
            this.diff = diff;
            this.dist = dist;
            this.name = name;
        }
    }
}