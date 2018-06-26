package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestTimer {

    private static Logger LOGGER = LoggerFactory.getLogger(TestTimer.class);

    public static void main(String[] args) {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(aLong -> LOGGER.info("timer :" + aLong + " at " + System.currentTimeMillis()));
    }
}
