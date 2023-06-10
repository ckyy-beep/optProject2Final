package com.example.optproject2final;

public interface IObservable {
    void registerItemAddedListener(IObserverItemAddedListener listener);
    void removeItemAddedListener(IObserverItemAddedListener listener);
    void notifyItemAddedListeners(String message);
}
