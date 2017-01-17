package freestar.freelibrary.base;

import rx.Subscriber;

/**
 * Author:  ljo_h
 * Date:    2016/10/15
 * Description:
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    public abstract void Completed();
    public abstract void Error(Throwable e);
    public abstract void Next(T t);

    @Override
    public void onCompleted() {
        Completed();
    }

    @Override
    public void onError(Throwable e) {
        Error(e);
    }

    @Override
    public void onNext(T t) {
        Next(t);
    }
}
