package com.parking.Parking_Lot.controller;

import com.parking.Parking_Lot.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

    ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/create/{capacity}")
    public String createParkingLot(@PathVariable int capacity) {
        return parkingLotService.createParkingLot(capacity);
    }

    @PostMapping("/park/{registration}/{color}")
    public String parkCar(@PathVariable String registration, @PathVariable String color) {
        return parkingLotService.parkCar(registration, color);
    }

    @PostMapping("/leave/{slotNumber}")
    public String leaveParkingSlot(@PathVariable int slotNumber) {
        return parkingLotService.leaveParkingSlot(slotNumber);
    }

    @GetMapping("/status")
    public String getParkingLotStatus() {
        return parkingLotService.getParkingLotStatus();
    }

    @GetMapping("/registration_numbers_for_cars_with_colour/{color}")
    public String getRegistrationNumbersByColor(@PathVariable String color) {
        return parkingLotService.getRegistrationNumbersByColor(color);
    }

    @GetMapping("/slot_number_for_registration/{registration}")
    public String getSlotNumberByRegistration(@PathVariable String registration) {
        return parkingLotService.getSlotNumberByRegistration(registration);
    }
}
