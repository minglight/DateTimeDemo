package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class TimezoneTest {

    public static void main(String[] args) {
        
        log.info("default timezone = {}", TimeZone.getDefault()); //default timezone = sun.util.calendar.ZoneInfo[id="Asia/Taipei",offset=28800000,dstSavings=0,useDaylight=false,transitions=42,lastRule=null]
        
        ZonedDateTime zd = ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.of("Asia/Tokyo"));
        String s = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss Z").format(zd);
        System.out.println(s);

        ZonedDateTime truncated = ZonedDateTime.of(2022, 2, 22, 13, 35, 56, 0, ZoneId.systemDefault()).truncatedTo(ChronoUnit.MINUTES);
        System.out.println("truncated=" + truncated);
        
    }
    
}
