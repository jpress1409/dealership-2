package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileMan {
    private static String FILE_NAME = "contracts.csv";

    public ContractFileMan() {
    }

    public static void saveContract(Contract contract){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            if(contract instanceof LeaseContract){
               for(Vehicle vehicle : Dealership.getAllVehicles()){
                   
               }
            }else if(contract instanceof SalesContract){

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
