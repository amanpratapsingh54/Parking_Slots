package com.parking.Parking_Lot.service;
import com.parking.Parking_Lot.model.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{

    private final ParkingLot parkingLot;

    public ParkingLotServiceImpl() {
        this.parkingLot = new ParkingLot();
    }

    public String createParkingLot(int capacity) {
        parkingLot.createParkingLot(capacity);
        return "Created a parking lot with " + capacity + " slots";
    }

    public String parkCar(String registration, String color) {
        int slotNumber = parkingLot.parkCar(registration, color);
        if (slotNumber == -1) {
            return "Sorry, parking lot is full";
        }
        return "Allocated slot number: " + slotNumber;
    }

    public String leaveParkingSlot(int slotNumber) {
        boolean success = parkingLot.leaveParkingSlot(slotNumber);
        if (success) {
            return "Slot number " + slotNumber + " is free";
        } else {
            return "Slot number " + slotNumber + " is already empty";
        }
    }

    public String getParkingLotStatus() {
        return parkingLot.getParkingLotStatus();
    }

    public String getRegistrationNumbersByColor(String color) {
        List<String> registrations = parkingLot.getRegistrationNumbersByColor(color);
        if (registrations.isEmpty()) {
            return "Not found";
        } else {
            return String.join(", ", registrations);
        }
    }

    public String getSlotNumberByRegistration(String registration) {
        int slotNumber = parkingLot.getSlotNumberByRegistration(registration);
        if (slotNumber == -1) {
            return "Not found";
        } else {
            return "Slot number for registration " + registration + ": " + slotNumber;
        }
    }
}
