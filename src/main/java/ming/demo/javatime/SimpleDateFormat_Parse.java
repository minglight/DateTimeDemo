package ming.demo.javatime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/***
 * Refer to https://stackoverflow.com/questions/4021151/java-dateformat-is-not-threadsafe-what-does-this-leads-to
 * 
 * 
 * 1. Expected Result 
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * 
 * 2. Unexpected Result
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Fri Oct 22 00:00:00 CST 2010
 * Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: "E.412001"
 * 	at java.base/java.util.concurrent.FutureTask.report(FutureTask.java:122)
 * 	at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:191)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse.main(SimpleDateFormat_Parse.java:48)
 * Caused by: java.lang.NumberFormatException: For input string: "E.412001"
 * 	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
 * 	at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
 * 	at java.base/java.lang.Double.parseDouble(Double.java:543)
 * 	at java.base/java.text.DigitList.getDouble(DigitList.java:169)
 * 	at java.base/java.text.DecimalFormat.parse(DecimalFormat.java:2128)
 * 	at java.base/java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1931)
 * 	at java.base/java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1541)
 * 	at java.base/java.text.DateFormat.parse(DateFormat.java:393)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse$1.call(SimpleDateFormat_Parse.java:32)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse$1.call(SimpleDateFormat_Parse.java:30)
 * 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
 * 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
 * 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
 * 	at java.base/java.lang.Thread.run(Thread.java:834)
 * 	
 * 	3. Unexpected Result
 * 	Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: ".E22E22"
 * 	at java.base/java.util.concurrent.FutureTask.report(FutureTask.java:122)
 * 	at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:191)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse.main(SimpleDateFormat_Parse.java:76)
 * Caused by: java.lang.NumberFormatException: For input string: ".E22E22"
 * 	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
 * 	at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
 * 	at java.base/java.lang.Double.parseDouble(Double.java:543)
 * 	at java.base/java.text.DigitList.getDouble(DigitList.java:169)
 * 	at java.base/java.text.DecimalFormat.parse(DecimalFormat.java:2128)
 * 	at java.base/java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:2240)
 * 	at java.base/java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1541)
 * 	at java.base/java.text.DateFormat.parse(DateFormat.java:393)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse$1.call(SimpleDateFormat_Parse.java:60)
 * 	at ming.demo.javatime.SimpleDateFormat_Parse$1.call(SimpleDateFormat_Parse.java:58)
 * 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
 * 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
 * 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
 * 	at java.base/java.lang.Thread.run(Thread.java:834)
 */
public class SimpleDateFormat_Parse {
    
    public static void main(String[] args) throws Exception {
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>(){
            public Date call() throws Exception {
                return format.parse("20101022");
            }
        };

        //pool with 5 threads
        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Future<Date>> results = new ArrayList<Future<Date>>();

        //perform 10 date conversions
        for(int i = 0 ; i < 10 ; i++){
            results.add(exec.submit(task));
        }
        exec.shutdown();

        //look at the results
        for(Future<Date> result : results){
            System.out.println(result.get());
        }
    
    }
    
}
