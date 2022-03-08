package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Slf4j
public class DateTimeFormatterDemo_format {

    private static DateTimeFormatter noTimeZoneFormatter = DateTimeFormatter.ISO_DATE_TIME;
    private static DateTimeFormatter utcZonedFormatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("UTC"));
    private static DateTimeFormatter taipeiZonedFormatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Taipei"));

    /***
     * Conclusion
     * How to choose timezone in format() :
     * 1. if has timeZone configured
     *  Zone in DateTimeFormatter > Zone in ZonedDateTime 
     * 2. if no timeZone configured ( for LocalDateTime )
     *  print no timezone
     * 3. Default Timezone doesn't affect the format() method
     */
    public static void main(String[] args) {
        /***
         * Default timezone is UTC
         */
        String defaultTimeZone = "UTC";
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
        LocalDateTime localDateTime = LocalDateTime.of(2022, 2, 22, 22, 22, 22);
        log.info("Default timezone is {},  noTimeZoneFormatter format LocalDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(localDateTime));
        log.info("Default timezone is {}, utcZonedFormatter format LocalDateTime:{}", defaultTimeZone, utcZonedFormatter.format(localDateTime));
        log.info("Default timezone is {}, taipeiZonedFormatter format LocalDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(localDateTime));
        System.out.println();
        /***
         * Default timezone is UTC,  noTimeZoneFormatter format LocalDateTime:2022-02-22T22:22:22
         * Default timezone is UTC, utcZonedFormatter format LocalDateTime:2022-02-22T22:22:22
         * Default timezone is UTC, taipeiZonedFormatter format LocalDateTime:2022-02-22T22:22:22
         */

        ZonedDateTime utcZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        log.info("Default timezone is {},  noTimeZoneFormatter  format utcZonedDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(utcZonedDateTime));
        log.info("Default timezone is {},  utcZonedFormatter format utcZonedDateTime:   {}", defaultTimeZone, utcZonedFormatter.format(utcZonedDateTime));
        log.info("Default timezone is {},  taipeiZonedFormatter format utcZonedDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(utcZonedDateTime));
        System.out.println();
        /***
         * Default timezone is UTC,  noTimeZoneFormatter  format utcZonedDateTime:2022-02-22T22:22:22Z[UTC]
         * Default timezone is UTC,  utcZonedFormatter format utcZonedDateTime:   2022-02-22T22:22:22Z[UTC]
         * Default timezone is UTC,  taipeiZonedFormatter format utcZonedDateTime:2022-02-23T06:22:22+08:00[Asia/Taipei]
         */
        ZonedDateTime taipeiZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Taipei"));
        log.info("Default timezone is {},  noTimeZoneFormatter format taipeiZonedDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(taipeiZonedDateTime));
        log.info("Default timezone is {},  utcZonedFormatter format   taipeiZonedDateTime:{}", defaultTimeZone, utcZonedFormatter.format(taipeiZonedDateTime));
        log.info("Default timezone is {},  taipeiZonedDateTime format taipeiZonedDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(taipeiZonedDateTime));
        System.out.println();
        /***
         * Default timezone is UTC,  noTimeZoneFormatter format taipeiZonedDateTime:2022-02-22T22:22:22+08:00[Asia/Taipei]
         * Default timezone is UTC,  utcZonedFormatter format   taipeiZonedDateTime:2022-02-22T14:22:22Z[UTC]
         * Default timezone is UTC,  taipeiZonedDateTime format taipeiZonedDateTime:2022-02-22T22:22:22+08:00[Asia/Taipei]
         */


        defaultTimeZone = "Asia/Taipei";
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
        log.info("Default timezone is {},  noTimeZoneFormatter format LocalDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(localDateTime));
        log.info("Default timezone is {}, utcZonedFormatter format LocalDateTime:{}", defaultTimeZone, utcZonedFormatter.format(localDateTime));
        log.info("Default timezone is {}, taipeiZonedFormatter format LocalDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(localDateTime));
        /***
         * Default timezone is Asia/Taipei,  noTimeZoneFormatter format LocalDateTime:2022-02-22T22:22:22
         * Default timezone is Asia/Taipei, utcZonedFormatter format LocalDateTime:2022-02-22T22:22:22
         * Default timezone is Asia/Taipei, taipeiZonedFormatter format LocalDateTime:2022-02-22T22:22:22
         */

        log.info("Default timezone is {},  noTimeZoneFormatter  format utcZonedDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(utcZonedDateTime));
        log.info("Default timezone is {},  utcZonedFormatter format utcZonedDateTime:   {}", defaultTimeZone, utcZonedFormatter.format(utcZonedDateTime));
        log.info("Default timezone is {},  taipeiZonedFormatter format utcZonedDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(utcZonedDateTime));
        /***
         * Default timezone is Asia/Taipei,  noTimeZoneFormatter  format utcZonedDateTime:2022-02-22T22:22:22Z[UTC]
         * Default timezone is Asia/Taipei,  utcZonedFormatter format utcZonedDateTime:   2022-02-22T22:22:22Z[UTC]
         * Default timezone is Asia/Taipei,  taipeiZonedFormatter format utcZonedDateTime:2022-02-23T06:22:22+08:00[Asia/Taipei]
         */
        
        log.info("Default timezone is {},  noTimeZoneFormatter format taipeiZonedDateTime:{}", defaultTimeZone, noTimeZoneFormatter.format(taipeiZonedDateTime));
        log.info("Default timezone is {},  utcZonedFormatter format   taipeiZonedDateTime:{}", defaultTimeZone, utcZonedFormatter.format(taipeiZonedDateTime));
        log.info("Default timezone is {},  taipeiZonedDateTime format taipeiZonedDateTime:{}", defaultTimeZone, taipeiZonedFormatter.format(taipeiZonedDateTime));
        /***
         * Default timezone is Asia/Taipei,  noTimeZoneFormatter format taipeiZonedDateTime:2022-02-22T22:22:22+08:00[Asia/Taipei]
         * Default timezone is Asia/Taipei,  utcZonedFormatter format   taipeiZonedDateTime:2022-02-22T14:22:22Z[UTC]
         * Default timezone is Asia/Taipei,  taipeiZonedDateTime format taipeiZonedDateTime:2022-02-22T22:22:22+08:00[Asia/Taipei]
         */
    }
    
    
}
