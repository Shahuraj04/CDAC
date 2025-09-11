package com.bms.core;

public enum AccountType {
    SAVINGS(5000), CURRENT(10000);

    private int minBalance;

    private AccountType(int minBalance) {
        this.minBalance = minBalance;
    }

    public int getMinBalance() {
        return minBalance;
    }

    @Override
    public String toString() {
        return name() + " requires minimum balance " + minBalance;
    }
}
