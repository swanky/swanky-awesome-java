package io.github.swanky.reactor;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * ref: http://reactivex.io/documentation/observable.html
 * 
 * @author swanky
 */
@Slf4j
public class MonoTest {
  
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
  
  @Test
  public void test_defer() throws Exception {
    log.info("test defer");
  }
  
}
