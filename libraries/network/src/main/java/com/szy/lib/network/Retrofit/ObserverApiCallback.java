package com.szy.lib.network.Retrofit;



import com.szy.lib.network.Retrofit.Util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.adapter.rxjava2.HttpException;


/**
 * Created by bingju on 2017/1/4.
 * Rxjava 的一个Oberver的实现,用来接收并处理ApiService回调结果
 */

public abstract class ObserverApiCallback<M> implements Observer<M> {
    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public void onFinish() {

    }
    protected void onlogin() {

    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void onError(Throwable e) {
//        if (e instanceof NullPointerException && "Null is not a valid element".equals(e.getMessage())) {
//            onNext(null);
//            onComplete();
//            return;
//        }
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogUtil.d("code=" + code);
            switch (code) {
                case 504:
                    break;
            }
            onFailure(e.getMessage(),code);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }
    public void onFailure(String msg, int code) {

    }
    public interface Request_code {
        public void show_code();
    }

    @Override
    public void onNext(M m) {
        if (m == null)
            onFailure("解析错误!");
        else
            onSuccess(m);
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }
}
