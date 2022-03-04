package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DurationDemo {

    public static void main(String[] args) throws InterruptedException {

        Instant begin = Instant.now();
        TimeUnit.SECONDS.sleep(2L);
        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);
        log.info("duration.toMillis()={}", duration.toMillis());

        end = end.plus(Duration.ofDays(2L));
        end = end.plus(Duration.ofHours(3L));
        end = end.plus(Duration.ofMinutes(10L));

        duration = Duration.between(begin, end);
        log.info("duration.toDays()={}", duration.toDays());
        log.info("duration.toHours()={}", duration.toHours());
        log.info("duration.toMinutes()={}", duration.toMinutes());
        log.info("duration.toSeconds()={}", duration.toSeconds());
        log.info("duration.toMillis()={}", duration.toMillis());
        
    }
}
