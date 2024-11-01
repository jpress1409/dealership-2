package com.pluralsight;

public abstract class Contract {
    private String dateOfContract;
    private String custName;
    private String custEmail;
    private static double totalPrice;
    private double monthlyPay;
    private int numOfMonths;
    private Vehicle vehicleSold;

    public Contract() {
        this.dateOfContract = dateOfContract;
        this.custName = custName;
        this.custEmail = custEmail;
        this.totalPrice = totalPrice;
        this.monthlyPay = monthlyPay;
    }

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

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
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
