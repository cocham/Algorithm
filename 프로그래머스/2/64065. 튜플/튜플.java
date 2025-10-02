import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] tuples = s.split("\\},\\{");
        Arrays.sort(tuples, (a, b) -> a.length() - b.length());
        // [3], [2,3],  [4,2,3], [2,3,4,1]
        // Point: 3이 첫번째 요소로 와야함. 
        // 그럼 [2,3]에선 2가 2번째 요소가 된다는 것을 주목

        for (String tuple : tuples){
            String[] nums = tuple.split(",");
            for (String numString : nums) {
                int num = Integer.parseInt(numString);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        // System.out.print(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}