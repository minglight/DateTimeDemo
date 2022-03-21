package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
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
        
        log.info("default timezone = {}", TimeZone.getDefault().getDisplayName()); //default timezone = sun.util.calendar.ZoneInfo[id="Asia/Taipei",offset=28800000,dstSavings=0,useDaylight=false,transitions=42,lastRule=null]
        
        ZonedDateTime zd = ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.of("Asia/Tokyo"));
        String s = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss Z").format(zd);
        System.out.println(s);

//        ZonedDateTime truncated = ZonedDateTime.of(2022, 2, 22, 13, 35, 56, 0, ZoneId.systemDefault()).truncatedTo(ChronoUnit.MINUTES);
//        System.out.println("truncated=" + truncated);
        
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        log.info("simpleDateFormat timezone = {}", simpleDateFormat.getTimeZone().getDisplayName());
        log.info("use system default timezone, system timezone={}, date format timezone={}, format={}", TimeZone.getDefault().getDisplayName(), simpleDateFormat.getTimeZone().getDisplayName(),simpleDateFormat.format(date));
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
        log.info("overwrite system default timezone, system timezone={}, date format timezone={}, format={}", TimeZone.getDefault().getDisplayName(), simpleDateFormat.getTimeZone().getDisplayName(),simpleDateFormat.format(date));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        log.info("set SimpleDateFormat timezone, system timezone={}, date format timezone={}, format={}", TimeZone.getDefault().getDisplayName(), simpleDateFormat.getTimeZone().getDisplayName(), simpleDateFormat.format(date));
        //use system default timezone,       system timezone=Taipei Standard Time, date format timezone=Taipei Standard Time, format=2022-03-21 14:34:29 +0800
        //overwrite system default timezone,  system timezone=Japan Standard Time, date format timezone=Taipei Standard Time, format=2022-03-21 14:34:29 +0800
        //set SimpleDateFormat timezone,      system timezone=Japan Standard Time, date format timezone=Pacific Standard Time, format=2022-03-20 23:34:29 -0700


    }
    
}
