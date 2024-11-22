package com.pluralsight;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private ContractFileMan fileMan = new ContractFileMan();
    private String FILE_NAME = "contracts.csv";
    private Dealership dealership;
    private static Scanner scan = new Scanner(System.in);

    public UserInterface() throws IOException {
    }

    public Dealership init() {
        DealershipFileMan fileMan = new DealershipFileMan();

        return fileMan.getDealership();
    }

    public void display(boolean loop) throws IOException {
        this.dealership = init();


        System.out.println("What would you like to do?");
        System.out.println("(1) Search by Price");
        System.out.println("(2) Search by Make/Model");
        System.out.println("(3) Search by Year");
        System.out.println("(4) Search by Color");
        System.out.println("(5) Search by Mileage");
        System.out.println("(6) Search by Type");
        System.out.println("(7) List All Vehicles");
        System.out.println("(8) Add Vehicle");
        System.out.println("(9) Remove Vehicle");
        System.out.println("(10) Sell or Lease Car");
        System.out.println("(99) Exit");
        int choice = scan.nextInt();
        scan.nextLine();

        ArrayList<Vehicle> inventory = new ArrayList<>();
        switch (choice) {
            case 1 -> processGetByPriceRequest();
            case 2 -> processGetByMakeModelRequest();
            case 3 -> processGetByYearRequest();
            case 4 -> processGetByColorRequest();
            case 5 -> processGetByMileageRequest();
            case 6 -> processGetVehicleTypeRequest();
            case 7 -> processGetAllVehicle();
            case 8 -> processAddVehicleRequest();
            case 9 -> processRemoveVehicleRequest(inventory);
            case 10 -> processSellLeaseVehicleRequest();
            case 99 -> loop = false;
            default -> System.out.println("Invalid Entry");

        }

    }

    public void displayVehicles(ArrayList<Vehicle> inventory) {
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest() {
        System.out.println("Please Enter the Minimum Amount");
        double priceMin = scan.nextDouble();

        System.out.println("Please Enter the Maximum Amount");
        double priceMax = scan.nextDouble();

        displayVehicles(dealership.getVehicleByPrice(priceMin, priceMax));

    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter make and/or model fo car");
        String makeModel = scan.nextLine().toUpperCase();

        displayVehicles(dealership.getVehicleByMakeModel(makeModel));
    }

    public void processGetByYearRequest() {
        System.out.println("Enter Newest");
        int yearMax = scan.nextInt();
        System.out.println("Enter Oldest");
        int yearMin = scan.nextInt();
        scan.nextLine();

        displayVehicles(dealership.getVehicleByYear(yearMin, yearMax));
    }

    public void processGetByColorRequest() {
        System.out.println("Enter Color");
        String color = scan.nextLine().toUpperCase();

        displayVehicles(dealership.getVehicleByColor(color));
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter Minimum Mileage");
        int mileMin = scan.nextInt();

        System.out.println("Enter Maximum Mileage");
        int mileMax = scan.nextInt();
        scan.nextLine();

        displayVehicles(dealership.getVehicleByMileage(mileMin, mileMax));
    }

    public void processGetVehicleTypeRequest() {
        System.out.println("Sedan, SUV, Truck or Coup?");
        String type = scan.nextLine();

        displayVehicles(dealership.getVehicleByType(type));
    }

    public void processGetAllVehicle() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        System.out.println("Enter VIN");
        int vin = scan.nextInt();

        System.out.println("Enter Year");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Make");
        String make = scan.nextLine();

        System.out.println("Enter Model");
        String model = scan.nextLine();

        System.out.println("Enter Vehicle Type");
        String vehicleType = scan.nextLine();

        System.out.println("Enter Color");
        String color = scan.nextLine();

        System.out.println("Enter Odometer Reading");
        int odometer = scan.nextInt();

        System.out.println("Enter Price");
        double price = scan.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        vehicle.setVin(vin);
        vehicle.setYear(year);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setColor(color);
        vehicle.setVehicleType(vehicleType);
        vehicle.setOdometer(odometer);
        vehicle.setPrice(price);

        DealershipFileMan.saveDealership(dealership);

        dealership.addVehicle(vehicle);


    }

    public void processRemoveVehicleRequest(ArrayList<Vehicle> inventory) {

        System.out.println("Enter the VIN of the vehicle you would like to remove");
        int vin = scan.nextInt();

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle.getVin() == vin) {
            dealership.removeVehicle();
            System.out.println(vehicle.getVin() + " has been removed.");
        }
    }


    public void processSellLeaseVehicleRequest() {
        LocalDate date = LocalDate.now();

        System.out.print("Enter the VIN of the vehicle to sell or lease: ");
        int vin = scan.nextInt();
        scan.nextLine();

        Vehicle vehicle = null;

        for (Vehicle vehicleInDealership : dealership.getAllVehicles()) {
            if (vehicleInDealership.getVin() == vin) {
                vehicle = vehicleInDealership;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        System.out.print("Enter the customer name: ");
        String customerName = scan.nextLine();

        System.out.print("Enter the customer email: ");
        String customerEmail = scan.nextLine();

        System.out.print("Is it a sale or lease? (sale/lease): ");
        String contractType = scan.nextLine();

        Contract contract;
        if (contractType.equalsIgnoreCase("sale")) {
            System.out.print("Is financing available? (yes/no): ");
            String financeOption = scan.nextLine();

            double salesTaxAmount = vehicle.getPrice() * 0.05;
            double recordingFee = 100;
            double processingFee = vehicle.getPrice() < 10000 ? 295 : 495;
            boolean finance = financeOption.equalsIgnoreCase("yes");

            contract = new SalesContract(date, customerName, customerEmail, vehicle, salesTaxAmount, recordingFee, processingFee, finance);
        } else if (contractType.equalsIgnoreCase("lease")) {
            double expectedEndingValue = vehicle.getPrice() / 2;
            double leaseFee = vehicle.getPrice() * 0.07;

            contract = new LeaseContract(date, customerName, customerEmail, vehicle, expectedEndingValue, leaseFee);
        } else {
            System.out.println("Invalid contract type. Please try again.");
            return;
        }

        ContractFileMan.saveContract(contract);
        dealership.removeVehicle();

        DealershipFileMan manager = new DealershipFileMan();
        manager.saveDealership(dealership);

        System.out.println("Contract saved successfully!");
    }

}