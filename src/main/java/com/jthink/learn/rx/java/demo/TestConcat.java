package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestConcat {

    private static Logger LOGGER = LoggerFactory.getLogger(TestConcat.class);

    public static void main(String[] args) {
        Observable.concat(Observable.just(1, 2, 3), Observable.just("A", "B", 6))
                .subscribe((Consumer<Serializable>) serializable -> LOGGER.info("concat: {}", serializable));
    }
}
