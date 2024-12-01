package com.example.lab12.task1;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Banknote {
    private Banknote nextItem;
    private int BanknoteNominale;

    public Banknote(int BanknoteNominale){
        this.BanknoteNominale = BanknoteNominale;
    }

    public void process(int amount) {
        int quantity = amount / BanknoteNominale;
        if (nextItem != null){
            nextItem.process(amount % BanknoteNominale);
        } else {
            if (amount % BanknoteNominale != 0){
                throw new IllegalArgumentException();
            }
        }
        System.out.format("Please receibe %d x %d\n", quantity, BanknoteNominale);
    }
}