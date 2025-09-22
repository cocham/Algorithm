class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int length = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < length; i++) {
            int q1Num = queue1[i];
            int q2Num = queue2[i];
            sum1 += q1Num;
            sum2 += q2Num;
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        long total = (sum1 + sum2) / 2;
        int[] arr = new int[2 * length];
        System.arraycopy(queue1, 0, arr, 0, length);
        System.arraycopy(queue2, 0, arr, length, length);
        
        int q1 = 0;
        int q2 = length;
        long sum = sum1;
        
        while (q1 < q2) {
            if (sum == total) {
                break;
            }
            
            if (sum < total && q2 == 2 * length - 1) {
                break;
            }
            
                       
            if (sum > total) {
                sum -= arr[q1];
                q1++;
            } else if (sum < total) {
                sum += arr[q2];
                q2++;
            }
            
            answer++;
        }
        
        if (sum != total) {
            answer = -1;
        }
        
        return answer;
    }
}