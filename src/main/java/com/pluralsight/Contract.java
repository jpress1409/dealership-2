package com.pluralsight;

public abstract class Contract {
    private String dateOfContract;
    private static String custName;
    private static String custEmail;
    private static double totalPrice;
    private static double monthlyPay;
    private static int numOfMonths;
    private static Vehicle vehicleSold;




    public double getTotalPrice(){
        if(SalesContract.isFinanceOption()){
            return getTotalPrice();
        }
        return getTotalPrice();
    }

    public double getMonthlyPayment(){
        if(numOfMonths == 48){
            return (1.0425 * totalPrice) / numOfMonths;
        }
        return (totalPrice * 1.0525) /  numOfMonths;
    }

    public static void setTotalPrice(double totalPrice) {
        Contract.totalPrice = totalPrice;
    }

    public int getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(int numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public static Vehicle getVehicleSold() {
        return vehicleSold;
    }


    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public static String getCustName() {
        return custName;
    }

    public static void setCustName(String custName) {
        Contract.custName = custName;
    }

    public static String getCustEmail() {
        return custEmail;
    }

    public static void setCustEmail(String custEmail) {
        Contract.custEmail = custEmail;
    }

    public static double getTotPrice() {
        return totalPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totalPrice = totPrice;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }
}
