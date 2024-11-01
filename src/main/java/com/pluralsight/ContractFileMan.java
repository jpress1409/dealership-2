package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileMan {
    private static String FILE_NAME = "contracts.csv";
    private Dealership dealership;

    public ContractFileMan() throws IOException {
    }

    public static void saveContract(Contract contract){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));){
            if(contract instanceof LeaseContract){
               leaseContract(dealership);
            }else if(contract instanceof SalesContract){
                salesContract();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String leaseContract(BufferedWriter writer) throws IOException {


        writer.newLine();
            StringBuilder builder = new StringBuilder();

            builder.append(.getVin()).append(" | ");
            builder.append(vehicle.getYear()).append(" | ");
            builder.append(vehicle.getMake()).append(" | ");
            builder.append(vehicle.getModel()).append(" | ");
            builder.append(vehicle.getVehicleType()).append(" | ");
            builder.append(vehicle.getColor()).append(" | ");
            builder.append(vehicle.getOdometer()).append(" | $");
            builder.append(vehicle.getPrice());

            String result = builder.toString();

            return result;
    }
    private static String salesContract() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.newLine();

                StringBuilder builder = new StringBuilder();

                builder.append(vehicle.getVin()).append(" | ");
                builder.append(vehicle.getYear()).append(" | ");
                builder.append(vehicle.getMake()).append(" | ");
                builder.append(vehicle.getModel()).append(" | ");
                builder.append(vehicle.getVehicleType()).append(" | ");
                builder.append(vehicle.getColor()).append(" | ");
                builder.append(vehicle.getOdometer()).append(" | $");
                builder.append(vehicle.getPrice());

                String result = builder.toString();
            return result;
    }

