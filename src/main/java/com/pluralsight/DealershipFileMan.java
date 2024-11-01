package com.pluralsight;

import java.io.*;

public class DealershipFileMan {

    private final String FILE_NAME;
    private final Dealership dealership;

    public DealershipFileMan() {
        this.FILE_NAME = "dealership.csv";
        this.dealership = new Dealership("", "", "");
    }

    public static void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dealership.csv"))) {
            // Write dealership information
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();

            // Write vehicle inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                        + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                        + "|" + vehicle.getPrice());
                bw.newLine();
            }

            System.out.println("Dealership saved successfully to dealership.csv.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Dealership getDealership() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];
                }

                if (parts.length == 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return dealership;
    }
}
