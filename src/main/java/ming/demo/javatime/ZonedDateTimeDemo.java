package ming.demo.javatime;

import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

@Slf4j
public class ZonedDateTimeDemo {

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        log.info("ZonedDateTime now = {}", zdt); //ZonedDateTime now = 2022-03-02T15:02:25.579144+08:00[Asia/Taipei]
        
        
    }
}
