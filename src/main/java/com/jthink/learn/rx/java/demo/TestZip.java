package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestZip {

    private static Logger LOGGER = LoggerFactory.getLogger(TestZip.class);

    public static void main(String[] args) {
        Observable.zip(getStringObservable(), getIntegerObservable(), (s, integer) -> s + integer)
                .subscribe(s -> LOGGER.info("zip accept: {}", s));
    }

    private static Observable<Integer> getIntegerObservable() {
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onNext(1);
                LOGGER.info("Integer emit : 1");
                emitter.onNext(2);
                LOGGER.info("Integer emit : 2");
                emitter.onNext(3);
                LOGGER.info("Integer emit : 3");
                emitter.onNext(4);
                LOGGER.info("Integer emit : 4");
                emitter.onNext(5);
                LOGGER.info("Integer emit : 5");
            }
        });
    }

    private static Observable<String> getStringObservable() {
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onNext("A");
                LOGGER.info("String emit : A");
                emitter.onNext("B");
                LOGGER.info("String emit : B");
                emitter.onNext("C");
                LOGGER.info("String emit : C");
            }
        });
    }

    static class People {

    }
}
