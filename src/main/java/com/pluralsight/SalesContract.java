package com.pluralsight;

public class SalesContract extends Contract{
    private static double monthlyPay;
    private static double salesTaxAmount;
    private static int recordingFee;
    private static int processFee;
    private static boolean financeOption;
    private static double monthlyPayment;
    private static double totPrice;
    private static int numOfMonths;

    public SalesContract(double salesTaxAmount, int recodingFee, int processFee, boolean finance, double monthlyPay) {
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
        this.processFee = processFee;
        this.financeOption = financeOption;
        this.monthlyPay = monthlyPay;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecodingFee() {
        return recordingFee;
    }

    public void setRecodingFee(int recodingFee) {
        this.recordingFee = recodingFee;
    }

    public int getProcessFee() {
        if(Contract.getTotPrice() < 10000){
            return 295;}
        return 495;
    }

    public void setProcessFee(int processFee) {
        this.processFee = processFee;
    }

    public static boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean finance) {
        this.financeOption = financeOption;
    }
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
