package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author levi
 * @version 0.0.1
 * @desc 事件发射
 * @date 2018-06-20 11:10:34
 */
public class TestFlatMap {

    private static Logger LOGGER = LoggerFactory.getLogger(TestFlatMap.class);

    public static void main(String[] args) {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
           emitter.onNext(1);
           emitter.onNext(2);
           emitter.onNext(3);
        }).flatMap(integer -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list);
        }).subscribe(s -> LOGGER.info("flatMap accept: {}", s));
    }
}
