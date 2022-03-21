package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Slf4j
public class DateTimeFormatterDemo_parse {

    private static DateTimeFormatter noTimeZoneFormatter = DateTimeFormatter.ISO_DATE_TIME;
    private static DateTimeFormatter utcZonedFormatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("UTC"));
    private static DateTimeFormatter taipeiZonedFormatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Taipei"));

    /***
     * Conclusion
     * 1. Default timezone doesn't affect the result
     * 2. Priority : timezone in DateTimeFormatter > timezone in source string 
     */
    public static void main(String[] args) {
        /***
         * Default timezone is UTC
         */
        String defaultTimeZone = "UTC";
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
        String format = "2022-02-22T22:22:22+01:00";
        log.info("Default timezone is {},  noTimeZoneFormatter parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, noTimeZoneFormatter));
        log.info("Default timezone is {}, utcZonedFormatter    parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, utcZonedFormatter));
        log.info("Default timezone is {}, taipeiZonedFormatter parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, taipeiZonedFormatter));
        System.out.println();

        defaultTimeZone = "Asia/Taipei";
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
        log.info("Default timezone is {},  noTimeZoneFormatter parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, noTimeZoneFormatter));
        log.info("Default timezone is {}, utcZonedFormatter    parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, utcZonedFormatter));
        log.info("Default timezone is {}, taipeiZonedFormatter parse 2022-02-22 22:22:22=>{}", defaultTimeZone, ZonedDateTime.parse(format, taipeiZonedFormatter));
        //Default timezone is UTC,  noTimeZoneFormatter parse 2022-02-22 22:22:22=>2022-02-22T22:22:22+01:00
        //Default timezone is UTC, utcZonedFormatter    parse 2022-02-22 22:22:22=>2022-02-22T21:22:22Z[UTC]
        //Default timezone is UTC, taipeiZonedFormatter parse 2022-02-22 22:22:22=>2022-02-23T05:22:22+08:00[Asia/Taipei]
        
        //Default timezone is Asia/Taipei,  noTimeZoneFormatter parse 2022-02-22 22:22:22=>2022-02-22T22:22:22+01:00
        //Default timezone is Asia/Taipei, utcZonedFormatter    parse 2022-02-22 22:22:22=>2022-02-22T21:22:22Z[UTC]
        //Default timezone is Asia/Taipei, taipeiZonedFormatter parse 2022-02-22 22:22:22=>2022-02-23T05:22:22+08:00[Asia/Taipei]
    }
    
    
}
