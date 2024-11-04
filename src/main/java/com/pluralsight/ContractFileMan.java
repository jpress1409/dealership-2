package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContractFileMan {
    private static String FILE_NAME = "contracts.csv";
    private Dealership dealership;

    public ContractFileMan() throws IOException {
    }

    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));) {
            if (contract instanceof LeaseContract) {
                leaseContract(writer);
            } else if (contract instanceof SalesContract) {
                salesContract(writer);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String leaseContract(BufferedWriter writer) throws IOException {
        LeaseContract leaseContract = new LeaseContract();
        LocalDate today = LocalDate.now();

        String contractType = "Lease";


        ArrayList<Vehicle> inventory = new ArrayList();
        Vehicle soldVehicle = UserInterface.processSellVehicleRequest(inventory);

        writer.newLine();
        StringBuilder builder = new StringBuilder();

        builder.append(contractType).append(" | ");
        builder.append(today).append(" | ");
        builder.append(Contract.getCustName()).append(" | ");
        builder.append(Contract.getCustEmail()).append(" | ");
        builder.append(soldVehicle.getVin()).append(" | ");
        builder.append(soldVehicle.getYear()).append(" | ");
        builder.append(soldVehicle.getMake()).append(" | ");
        builder.append(soldVehicle.getModel()).append(" | ");
        builder.append(soldVehicle.getVehicleType()).append(" | ");
        builder.append(soldVehicle.getColor()).append(" | ");
        builder.append(soldVehicle.getOdometer()).append(" | $");
        builder.append(soldVehicle.getPrice()).append(" | $");
        builder.append(LeaseContract.getExpectedEndingValue()).append(" | $");
        builder.append(LeaseContract.getLeaseFee()).append(" | $");
        builder.append(leaseContract.getTotalPrice()).append(" | $");
        builder.append(leaseContract.getMonthlyPayment());

        String result = builder.toString();

        return result;

    }

    private static String salesContract(BufferedWriter writer) throws IOException {
        SalesContract salesContract = new SalesContract();
        LocalDate today = LocalDate.now();
        String financeOption;
        String contractType = "Sales";
        if(SalesContract.isFinanceOption()){
            financeOption = "Yes";
        }else{
            financeOption = "No";
        }


        ArrayList<Vehicle> inventory = new ArrayList();
        Vehicle soldVehicle = UserInterface.processSellVehicleRequest(inventory);

        writer.newLine();
        StringBuilder builder = new StringBuilder();

        builder.append(contractType).append(" | ");
        builder.append(today).append(" | ");
        builder.append(Contract.getCustName()).append(" | ");
        builder.append(Contract.getCustEmail()).append(" | ");
        builder.append(soldVehicle.getVin()).append(" | ");
        builder.append(soldVehicle.getYear()).append(" | ");
        builder.append(soldVehicle.getMake()).append(" | ");
        builder.append(soldVehicle.getModel()).append(" | ");
        builder.append(soldVehicle.getVehicleType()).append(" | ");
        builder.append(soldVehicle.getColor()).append(" | ");
        builder.append(soldVehicle.getOdometer()).append(" | $");
        builder.append(soldVehicle.getPrice()).append(" | $");
        builder.append(SalesContract.getSalesTaxAmount()).append(" | $");
        builder.append(SalesContract.getRecordingFee()).append(" | $");
        builder.append(SalesContract.getProcessFee()).append(" | $");
        builder.append(SalesContract.getTotPrice()).append(" | $");
        builder.append(financeOption).append(" | ");
        builder.append(salesContract.getMonthlyPayment());

        String result = builder.toString();

        return result;
    }
}

