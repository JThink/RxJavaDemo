package com.jthink.learn.rx.java.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author levi
 * @version 0.0.1
 * @desc
 * @date 2018-06-20 14:56:59
 */
public class TestObserver {

    private static Logger LOGGER = LoggerFactory.getLogger(TestObserver.class);

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
        }).subscribe(new Observer<Integer>() {

            private int i;
            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                LOGGER.info("onSubscribe: " + d.isDisposed());
                this.disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                LOGGER.info("onNext value: {}", integer);
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    disposable.dispose();
                    LOGGER.info("onNext isDisposable: {}", disposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.info("onError value: ", e);
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete");
            }
        });
    }
}
