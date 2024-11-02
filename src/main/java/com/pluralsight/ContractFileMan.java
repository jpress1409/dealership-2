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
        LocalDate today = LocalDate.now();
        String buyerEmail;
        String buyerName;

        ArrayList<Vehicle> inventory = new ArrayList();
        Vehicle soldVehicle = UserInterface.processSellVehicleRequest(inventory);


        writer.newLine();
        StringBuilder builder = new StringBuilder();

        builder.append(soldVehicle.getVin()).append(" | ");
        builder.append(soldVehicle.getYear()).append(" | ");
        builder.append(soldVehicle.getMake()).append(" | ");
        builder.append(soldVehicle.getModel()).append(" | ");
        builder.append(soldVehicle.getVehicleType()).append(" | ");
        builder.append(soldVehicle.getColor()).append(" | ");
        builder.append(soldVehicle.getOdometer()).append(" | $");
        builder.append(soldVehicle.getPrice());

        String result = builder.toString();

        return result;
    }

    private static String salesContract(BufferedWriter writer) throws IOException {
        LocalDate today = LocalDate.now();
        String buyerEmail;
        String buyerName;

        ArrayList<Vehicle> inventory = new ArrayList();
        Vehicle soldVehicle = UserInterface.processSellVehicleRequest(inventory);

        writer.newLine();
        StringBuilder builder = new StringBuilder();

        builder.append(soldVehicle.getVin()).append(" | ");
        builder.append(soldVehicle.getYear()).append(" | ");
        builder.append(soldVehicle.getMake()).append(" | ");
        builder.append(soldVehicle.getModel()).append(" | ");
        builder.append(soldVehicle.getVehicleType()).append(" | ");
        builder.append(soldVehicle.getColor()).append(" | ");
        builder.append(soldVehicle.getOdometer()).append(" | $");
        builder.append(soldVehicle.getPrice());

        String result = builder.toString();

        return result;
    }
}

