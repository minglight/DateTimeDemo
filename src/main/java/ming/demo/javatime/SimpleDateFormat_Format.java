package ming.demo.javatime;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleDateFormat_Format {
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<CompletableFuture<String>> futures = 
        
        List.of(
                new GregorianCalendar(2021, Calendar.JANUARY, 1).getTime()
                ,new GregorianCalendar(2022, Calendar.FEBRUARY, 2).getTime()
                ,new GregorianCalendar(2023, Calendar.MARCH, 3).getTime()
                ,new GregorianCalendar(2024, Calendar.APRIL, 4).getTime()
                ,new GregorianCalendar(2025, Calendar.MAY, 5).getTime()
                        )
                .stream()
                .map( date -> CompletableFuture.supplyAsync( () -> format(date), threadPool))
                .collect(Collectors.toList());
        
        for(CompletableFuture f : futures){
            f.whenComplete( (resp, ex) -> {
                System.out.println(resp);
            });
        }
        threadPool.shutdown();
        //Run Result 1 - not expected
//        20220202
//        20220202
//        20230303
//        20240404
//        20250505
        
        //Result 2
//        20210304
//        20210304
//        20230304
//        20240404
//        20250505
                
        //Run Result3 - expected
//        20210101
//        20220202
//        20230303
//        20240404
//        20250505
        
                
        
        
    }
    
    public static String format(Date date){
        return dateFormat.format(date);
    }
    
}
