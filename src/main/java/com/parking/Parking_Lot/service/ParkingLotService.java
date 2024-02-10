package com.parking.Parking_Lot.service;

public interface ParkingLotService {
    String createParkingLot(int capacity);

    String parkCar(String registration, String color);

    String leaveParkingSlot(int slotNumber);

    String getParkingLotStatus();

    String getRegistrationNumbersByColor(String color);

    String getSlotNumberByRegistration(String registration);
}
