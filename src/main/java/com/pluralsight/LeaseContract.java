package com.pluralsight;

public class LeaseContract {
    private static double expEndVal;
    private static double leaseFee;
    private static double monthlyPay;
    private static double totPrice;

    public LeaseContract() {
    }
    @Override
    public static double getTotalPrice();{
        return totPrice;
    }


    public static double getExpEndVal() {
        return expEndVal;
    }

    public static void setExpEndVal(double expEndVal) {
        LeaseContract.expEndVal = expEndVal;
    }

    public static double getLeaseFee() {
        return leaseFee;
    }

    public static void setLeaseFee(double leaseFee) {
        LeaseContract.leaseFee = leaseFee;
    }

    public static double getMonthlyPay() {
        return monthlyPay;
    }

    public static void setMonthlyPay(double monthlyPay) {
        LeaseContract.monthlyPay = monthlyPay;
    }
}
