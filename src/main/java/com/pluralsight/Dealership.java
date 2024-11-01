package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private Vehicle vehicle;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String makeModel){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){

            if (vehicle.getMake().toUpperCase().contains(makeModel) || vehicle.getModel().toUpperCase().contains(makeModel)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehicleByYear(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){

            if (vehicle.getColor().toUpperCase().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){

            if (vehicle.getVehicleType().toUpperCase().equalsIgnoreCase(vehicleType)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(){
        inventory.remove(vehicle);
    }
    public Vehicle getVehicleByVin(int vin){
        for(Vehicle vehicle : inventory){
            if(vehicle.getVin() == vin){
                return vehicle;
            }
        }
        return null;
    }
}