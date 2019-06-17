package com.kuanhsien.app.sample.android_mvvm_demo.data.observable;

public interface IObservable {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}
