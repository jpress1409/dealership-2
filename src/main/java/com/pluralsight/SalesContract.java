package com.pluralsight;

public class SalesContract {
    private double salesTaxAmount;
    private int recodingFee;
    private int processFee;
    private static boolean finance;
    private double monthlyPay;
    private static double totPrice;
    private int numOfMonths;

    public SalesContract(double salesTaxAmount, int recodingFee, int processFee, boolean finance, double monthlyPay) {
        this.salesTaxAmount = 0.05;
        this.recodingFee = 100;
        this.processFee = processFee;
        this.finance = finance;
        this.monthlyPay = monthlyPay;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecodingFee() {
        return recodingFee;
    }

    public void setRecodingFee(int recodingFee) {
        this.recodingFee = recodingFee;
    }

    public int getProcessFee() {
        if(Contract.getTotPrice() < 10000){
            return 295;}
        return 495;
    }

    public void setProcessFee(int processFee) {
        this.processFee = processFee;
    }

    public static boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
    @Override
    public static double getTotalPrice(){

        return totPrice;
    }
    @Override
    public double getMonthlyPayment(){
        if(numOfMonths == 48){
            return (1.0425 * totPrice) / numOfMonths;
        }
        return (totPrice * 1.0525) /  numOfMonths;
    }
}
