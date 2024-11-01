package com.pluralsight;

public abstract class Contract {
    private String dateOfContract;
    private String custName;
    private String custEmail;
    private double totPrice;
    private double monthlyPay;
    private int numOfMonths;

    public Contract(String dateOfContract, String custName, String custEmail, double totPrice, double monthlyPay) {
        this.dateOfContract = dateOfContract;
        this.custName = custName;
        this.custEmail = custEmail;
        this.totPrice = totPrice;
        this.monthlyPay = monthlyPay;
    }
    @Override
    public double getTotalPrice(){
        if(SalesContract.isFinance()){
            return SalesContract.getTotalPrice();
        }
        return LeaseContract.getTotalPrice();
    }
    @Override
    public double getMonthlyPayment(){
        if(numOfMonths == 48){
            return (1.0425 * totPrice) / numOfMonths;
        }
        return (totPrice * 1.0525) /  numOfMonths;
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
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }
}
