package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestMap {

    private static Logger LOGGER = LoggerFactory.getLogger(TestMap.class);

    public static void main(String[] args) {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            LOGGER.info("Observable emit 1");
            emitter.onNext(1);
            LOGGER.info("Observable emit 2");
            emitter.onNext(2);
            LOGGER.info("Observable emit 3");
            emitter.onNext(3);
            emitter.onComplete();
            LOGGER.info("Observable emit 4");
            emitter.onNext(4);
            LOGGER.info("Observable emit 5");
            emitter.onNext(5);
        }).map(integer -> "This is result: " + String.valueOf(integer * 10)).subscribe(s -> LOGGER.info("accept: " + s));
    }
}
