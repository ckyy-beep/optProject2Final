package com.example.optproject2final;

public interface IObservable {
    void addObserver(Gebruiker observer);
    void removeObserver(Gebruiker observer);
    void notifyObservers();
}
