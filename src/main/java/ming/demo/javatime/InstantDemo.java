package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
public class InstantDemo {

    public static void main(String[] args) {

        /***
         * Now as             seconds = 1646153658, as nano = 451780000
         * Now as epoch milli seconds = 1646153658451
         * now.toString() = 2022-03-01T16:54:18.451780Z
         * Instant.MAX = +1000000000-12-31T23:59:59.999999999Z, Instant.MIN = -1000000000-01-01T00:00:00Z
         */
        Instant now = Instant.now();
        log.info("Now as             seconds = {}, as nano = {}", now.getEpochSecond(), now.getNano());
        log.info("Now as epoch milli seconds = {}", now.toEpochMilli());
        log.info("now.toString() = {}", now);
        log.info("Instant.MAX = {}, Instant.MIN = {}", Instant.MAX, Instant.MIN);
        
        //calculation
        log.info("One day later = {}", now.plus(1, ChronoUnit.DAYS));
        log.info("is before : {}", now.isBefore(Instant.now()));
        
        
    }
}
