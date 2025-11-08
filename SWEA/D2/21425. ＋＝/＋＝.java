
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while (true) {
                if (a > n || b > n) {
                    break;
                } else {
                    if (a < b) {
                    a += b;
                } else {
                    b += a;
                    }
                }
				cnt++;
            }
		sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}