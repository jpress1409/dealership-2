package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class ContractFileMan {
    private static String FILE_NAME = "contracts.csv";
    private Dealership dealership;
    private static UserInterface ui = new UserInterface();

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

    public static String leaseContract(BufferedWriter writer) throws IOException {
        Scanner scan = new Scanner(System.in);
        LeaseContract leaseContract = new LeaseContract();
        String today = String.valueOf(LocalDate.now());


        String contractType = "Lease";

        System.out.println("Enter Customer Name:");
        String customerName = scan.nextLine();
        Contract.setCustName(customerName);

        System.out.println("Enter Customer Email: ");
        String customerEmail = scan.nextLine();
        Contract.setCustEmail(customerEmail);


        ArrayList<Vehicle> inventory = new ArrayList();
        Vehicle soldVehicle = ui.processSellVehicleRequest(inventory);

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
        builder.append(leaseContract.getExpectedEndingValue()).append(" | $");
        builder.append(leaseContract.getLeaseFee()).append(" | $");
        builder.append(leaseContract.getTotalPrice()).append(" | $");
        builder.append(leaseContract.getMonthlyPayment());

        String result = builder.toString();

        return result;

    }

    public static String salesContract(BufferedWriter writer) throws IOException {
        SalesContract salesContract = new SalesContract();
        LocalDate today = LocalDate.now();
        String financeOption;
        String contractType = "Sales";
        if(SalesContract.isFinanceOption()){
            financeOption = "Yes";
        }else{
            financeOption = "No";
        }


        ArrayList<Vehicle> inventory = new ArrayList<>();
        Vehicle soldVehicle = ui.processSellVehicleRequest(inventory);

        writer.newLine();
        StringBuilder custBuilder = new StringBuilder();
        custBuilder.append(contractType).append(" | ");
        custBuilder.append(today).append(" | ");
        custBuilder.append(Contract.getCustName()).append(" | ");
        custBuilder.append(Contract.getCustEmail()).append(" | ");
        String customer = custBuilder.toString();

        StringBuilder vehicleBuilder = new StringBuilder();
        vehicleBuilder.append(soldVehicle.getVin()).append(" | ");
        vehicleBuilder.append(soldVehicle.getYear()).append(" | ");
        vehicleBuilder.append(soldVehicle.getMake()).append(" | ");
        vehicleBuilder.append(soldVehicle.getModel()).append(" | ");
        vehicleBuilder.append(soldVehicle.getVehicleType()).append(" | ");
        vehicleBuilder.append(soldVehicle.getColor()).append(" | ");
        vehicleBuilder.append(soldVehicle.getOdometer()).append(" | $");
        vehicleBuilder.append(soldVehicle.getPrice()).append(" | $");
        vehicleBuilder.append(SalesContract.getSalesTaxAmount()).append(" | $");
        String vehicle = vehicleBuilder.toString();

        StringBuilder contractBuilder = new StringBuilder();
        contractBuilder.append(SalesContract.getRecordingFee()).append(" | $");
        contractBuilder.append(SalesContract.getProcessFee()).append(" | $");
        contractBuilder.append(SalesContract.getTotPrice()).append(" | $");
        contractBuilder.append(financeOption).append(" | ");
        contractBuilder.append(salesContract.getMonthlyPayment());
        String contract = contractBuilder.toString();

        String totalBuilder =
                customer +
                vehicle +
                contract;


        return totalBuilder;
    }
}

