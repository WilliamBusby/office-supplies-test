package com.nology;

public class OfficeStationary implements Stationary{

    private int supplyAmount;

    public OfficeStationary(int supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    @Override
    public String addToSupply(int num) {
        supplyAmount+=num;
        return "Added " + num + " to total.";
    }

    @Override
    public String removeFromSupply(int num) {
        if(supplyAmount-num > 0) {
            supplyAmount-=num;
            return "Removed " + num + " from supply. Remaining: " + supplyAmount;
        } else {
            return "You don't have enough for that, need another " + (num-supplyAmount);
        }
    }

    public int getSupplyAmount() {
        return supplyAmount;
    }

    public int totalStaffFromSupply(int amountPerStaff) {
        return supplyAmount/amountPerStaff;
    }
}
