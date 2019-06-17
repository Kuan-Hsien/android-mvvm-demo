package com.kuanhsien.app.sample.android_mvvm_demo.data.observable;

import java.util.ArrayList;
import java.util.List;

abstract public class ObservableData implements IObservable {

    // Record all observers in a list
    private List<IObserver> mObserverList = new ArrayList<>();

    // Register observer to observe observable
    @Override
    public void registerObserver(IObserver observer) {
        mObserverList.add(observer);
    }

    // Remove registered observer
    @Override
    public void removeObserver(IObserver observer) {
        mObserverList.remove(observer);
    }

    // Notify observers to update
    @Override
    public void notifyObservers() {
        for (IObserver observer: mObserverList) {
            observer.update();
        }
    }
}
