package com.parking.Parking_Lot.model;

import java.util.*;

public class ParkingLot {

    private int capacity;
    private Map<Integer, String> slots;
    private Map<String, Integer> registrationToSlot;
    private Map<String, String> colorToRegistration;

    public void createParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.registrationToSlot = new HashMap<>();
        this.colorToRegistration = new HashMap<>();
    }

    public int parkCar(String registration, String color) {
        if (slots.size() < capacity) {
            int slotNumber = findNextAvailableSlot();
            slots.put(slotNumber, registration);
            registrationToSlot.put(registration, slotNumber);
            colorToRegistration.put(color, registration);
            return slotNumber;
        } else {
            return -1;
        }
    }

    public boolean leaveParkingSlot(int slotNumber) {
        if (slots.containsKey(slotNumber)) {
            String registration = slots.remove(slotNumber);
            registrationToSlot.remove(registration);
            for (Map.Entry<String, String> entry : colorToRegistration.entrySet()) {
                if (entry.getValue().equals(registration)) {
                    colorToRegistration.remove(entry.getKey());
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String getParkingLotStatus() {
        StringBuilder status = new StringBuilder("Slot No. Registration No Colour\n");
        for (Map.Entry<Integer, String> entry : slots.entrySet()) {
            int slotNumber = entry.getKey();
            String registration = entry.getValue();
            String color = getColorByRegistration(registration);
            status.append(slotNumber).append(" ").append(registration).append(" ").append(color).append("\n");
        }
        return status.toString();
    }

    public List<String> getRegistrationNumbersByColor(String color) {
        List<String> registrations = new ArrayList<>();
        for (Map.Entry<String, String> entry : colorToRegistration.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(color)) {
                registrations.add(entry.getValue());
            }
        }
        return registrations;
    }

    public int getSlotNumberByRegistration(String registration) {
        return registrationToSlot.getOrDefault(registration, -1);
    }

    private int findNextAvailableSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (!slots.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    private String getColorByRegistration(String registration) {
        for (Map.Entry<String, String> entry : colorToRegistration.entrySet()) {
            if (entry.getValue().equals(registration)) {
                return entry.getKey();
            }
        }
        return "";
    }
}

