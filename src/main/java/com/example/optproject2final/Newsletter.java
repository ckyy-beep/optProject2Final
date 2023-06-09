package com.example.optproject2final;

import java.util.ArrayList;
import java.util.List;

import static com.example.optproject2final.Main.getProgram;

public class Newsletter implements IObservable {

    private final List<IObserver> gebruikers;

    public List<IObserver> getGebruikers() {
        return gebruikers;
    }

    public Newsletter() {
        this.gebruikers = new ArrayList<>();
    }


    @Override
    public void addObserver(Gebruiker observer) {
        gebruikers.add(observer);
    }

    @Override
    public void removeObserver(Gebruiker observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
