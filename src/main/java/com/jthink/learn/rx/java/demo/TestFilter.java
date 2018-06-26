package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(TestFilter.class);

    public static void main(String[] args) {
        Observable.fromArray(1, 1, 2, "A", "B", "C", "A", 4, 3, 1, 3)
                .distinct()
                .filter((Predicate<Serializable>) serializable -> serializable instanceof Integer)
                .subscribe((Consumer<Serializable>) s -> LOGGER.info("accept: {}", s));
    }
}
