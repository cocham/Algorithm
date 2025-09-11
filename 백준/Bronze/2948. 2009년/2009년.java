import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.time.LocalDate;
    
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        
        LocalDate date = LocalDate.of(2009, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekEnglish = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        System.out.println(dayOfWeekEnglish);
    }
}