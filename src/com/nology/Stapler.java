package com.nology;

public class Stapler extends OfficeStationary{

    private final int amountOfStaples;

    public Stapler(int supplyAmount, int amountOfStaples) {
        super(supplyAmount);
        this.amountOfStaples = amountOfStaples;
    }

    public int staplesPerStapler() {
        return (amountOfStaples/getSupplyAmount());
    }
}
