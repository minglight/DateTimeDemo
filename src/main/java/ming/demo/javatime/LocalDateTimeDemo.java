package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2021, Month.JULY, 10, 10, 22, 30);
        log.info("dt={}", dt); //dt=2021-07-10T10:22:30
        log.info("dt.getDayOfWeek()={}", dt.getDayOfWeek()); //dt.getDayOfWeek()=SATURDAY
        
        dt = dt.plus(30, ChronoUnit.HOURS);
        log.info("dt plus 30 hours ={}", dt); //2021-07-11T16:22:30
        
        ZonedDateTime zdt = dt.atZone(ZoneId.of("Asia/Taipei"));
        log.info("dt at Taipei={}", zdt); //dt at Taipei=2021-07-11T16:22:30+08:00[Asia/Taipei]
        
    }
}
