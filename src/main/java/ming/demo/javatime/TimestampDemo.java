package ming.demo.javatime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class TimestampDemo {

    public static void main(String[] args) {

        
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        long utcEpoch = Instant.now().toEpochMilli();
        System.out.println("Default TimeZone is UTC,  instant epochMilli = " + utcEpoch);
        long utcDate = new Date().getTime();
        System.out.println("Default TimeZone is UTC,  Date timestamp diff = " + (utcDate-utcEpoch));
        long utcSystem = System.currentTimeMillis();
        System.out.println("Default TimeZone is UTC,  System current millis  diff = " + (utcSystem-utcEpoch));
//        Default TimeZone is UTC,  instant epochMilli = 1646206385276
//        Default TimeZone is UTC,  Date timestamp diff = 23
//        Default TimeZone is UTC,  System current millis  diff = 23
        
        
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
        long taipeiEpoch = Instant.now().toEpochMilli();
        System.out.println("Default TimeZone is Asia/Taipei,  instant epochMilli  diff = " + (taipeiEpoch-utcEpoch));
        long tiapeiDate = new Date().getTime();
        System.out.println("Default TimeZone is Asia/Taipei,  Date timestamp  diff = " + (tiapeiDate-utcEpoch));
        long taipeiSystem = System.currentTimeMillis();
        System.out.println("Default TimeZone is Asia/Taipei,  System current millis  diff = " + (taipeiSystem-utcEpoch));
        long zdt = ZonedDateTime.now().toEpochSecond() * 1000;
        System.out.println("Default TimeZone is Asia/Taipei,  System current millis  diff = " + (zdt-utcEpoch));
//        Default TimeZone is Asia/Taipei,  instant epochMilli  diff = 28
//        Default TimeZone is Asia/Taipei,  Date timestamp  diff = 28
//        Default TimeZone is Asia/Taipei,  System current millis  diff = 30
//        Default TimeZone is Asia/Taipei,  System current millis  diff = -880
    }
}
