class Solution {    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    static void dfs(int[] numbers, int target, int idx, int curSum) {
        if (idx == numbers.length) {
            if (curSum == target) {
                count++;
            }
            return;
        }
        
        dfs(numbers, target, idx + 1, curSum + numbers[idx]);
        dfs(numbers, target, idx + 1, curSum - numbers[idx]);
    }
}