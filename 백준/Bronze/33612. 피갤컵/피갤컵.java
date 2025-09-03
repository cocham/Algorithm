import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final DateTimeFormatter SPACE_FMT = DateTimeFormatter.ofPattern("yyyy M");
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        YearMonth base = YearMonth.parse("2024-08");
        YearMonth result = base.plusMonths((n - 1) * 7);
        
        System.out.println(result.format(SPACE_FMT));
    }
}