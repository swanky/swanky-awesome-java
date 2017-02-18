package io.github.swanky.reactor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.publisher.TopicProcessor;
import reactor.core.scheduler.Schedulers;

/**
 * ref: http://reactivex.io/documentation/observable.html
 * 
 * @author swanky
 */
@Slf4j
public class ReactorTest {
  
  /**
   * Creating Observables: Create, Defer, Empty/Never/Throw, From, Interval,
   * Just, Range, Repeat, Start, and Timer
   */
  
  @Ignore
  @Test
  public void test_create() throws Exception {
    log.info("test create");
    
    Mono.create(sink -> {
      // sink.error(new RuntimeException("sink exception"));
      sink.success("sink");
    })
        .subscribe(output -> log.info(output.toString()));
    
  }
  
  @Ignore
  @Test
  public void test() throws Exception {
    Mono.just("TEST")
        .repeat(3L)
        .delayMillis(1000L)
        .log()
        .subscribe(System.out::println);
    
    TimeUnit.SECONDS.sleep(5L);
  }
  
  void print(String input) {
    System.out.println(input + Thread.currentThread()
                                     .getName());
  }
  
  /**
   * ref: http://qiita.com/y_q1m/items/b380774c476b0fe61b9c
   */
  @Ignore
  @Test
  public void test_publishOn_subscribeOn_1() throws Exception {
    Mono.create(emitter -> {
      print("emitter ");
      emitter.success("");
    })
        .publishOn(Schedulers.newSingle("pub"))
        .subscribeOn(Schedulers.newSingle("sub"))
        .subscribe(str -> print("subscribe "));
    
    TimeUnit.SECONDS.sleep(1L);
  }
  
  @Ignore
  @Test
  public void test_publishOn_subscribeOn_2() throws Exception {
    Mono.create(emitter -> {
      print("emitter ");
      emitter.success("");
    })
        .filter(str -> {
          print("filter ");
          return true;
        })
        .map(str -> {
          print("map ");
          return str;
        })
        .subscribeOn(Schedulers.newSingle("sub"))
        .publishOn(Schedulers.newSingle("pub"))
        .subscribe(str -> print("subscrive "));
    
    TimeUnit.SECONDS.sleep(1L);
  }
  
  @Ignore
  @Test
  public void test_publishOn_subscribeOn_3() throws Exception {
    Mono.create(emitter -> {
      print("emitter ");
      emitter.success("");
    })
        .subscribeOn(Schedulers.newSingle("sub"))
        .publishOn(Schedulers.newSingle("pub"))
        .filter(str -> {
          print("filter ");
          return true;
        })
        .map(str -> {
          print("map ");
          return str;
        })
        .subscribe(str -> print("subscrive "));
    
    TimeUnit.SECONDS.sleep(1L);
  }
  
  // @Ignore
  @Test
  public void test_MonoProcessor() throws Exception {
    TopicProcessor<String> processor = TopicProcessor.<String>create(Executors.newWorkStealingPool());
    
    processor.subscribe(str -> {
      log.info("S1: " + str);
      
      try {
        TimeUnit.SECONDS.sleep(1L);
      } catch (InterruptedException e) {
      }
    });
    
    processor.subscribe(str -> {
      log.info("S2: " + str);
      
      try {
        TimeUnit.SECONDS.sleep(2L);
      } catch (InterruptedException e) {
      }
    });
    
    processor.subscribe(str -> {
      log.info("S3: " + str);
      
      try {
        TimeUnit.SECONDS.sleep(3L);
      } catch (InterruptedException e) {
      }
    });
    
    IntStream.range(0, 100)
             .forEach(i -> {
               processor.onNext("" + i);
             });
    
    TimeUnit.SECONDS.sleep(500L);
    
  }
  
}
