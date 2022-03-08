package ming.demo.javatime.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/***
 * User want to execute upgrade in 1970-01-01 00:00:00
 * Input    : “1970-01-01T00:00:00” 
 * Output : cron expression in Quartz framework
 */
@Slf4j
public class CronExpressionDemo {
    
    public static void main(String[] args) {
        String input = "1970-01-01T00:00:00";
        scheduleUpgrade(input);
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public static void scheduleUpgrade(String sdate){
        LocalDateTime localDateTime = LocalDateTime.parse(sdate, formatter);
        String cron = getCron(localDateTime);
        String timezone = getTimeZone();
        sendToQuartz( new QuartzParam(cron, timezone));
    }

    private static void sendToQuartz(QuartzParam quartzParam) {
        log.info("Send to quartz : {}", quartzParam);
        //Result = CronExpressionDemo.QuartzParam(cron=0 0 0 1 JAN ? 1970, timezone=Asia/Taipei)
    }

    private static String getTimeZone() {
        return "Asia/Taipei";
    }

    private static String getCron(LocalDateTime localDateTime) {
        if("1970-01-01T00:00:00".equals(localDateTime.format(formatter))){
            return "0 0 0 1 JAN ? 1970";
        }else{
            throw new UnsupportedOperationException();
        }
        
    }

    @Data
    @AllArgsConstructor static class QuartzParam {
        private String cron;
        private String timezone;
    }
    
}
