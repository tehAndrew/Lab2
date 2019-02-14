package com.group14.storage;

import com.group14.vehicles.Vehicle;

import java.util.ArrayList;

public class Workshop <T extends Vehicle> implements IStorage<T> {
    private int storageSpace;
    private ArrayList<T> storedVehicles;
    private int selectedIndex;

    public Workshop(int storageSpace) {
        this.storageSpace = storageSpace;
        storedVehicles = new ArrayList(storageSpace);
        resetSelection();
    }

    private void resetSelection() { selectedIndex = -1; }

    public void selectVehicle(int index) {
        if (index >= 0 && index < storedVehicles.size()) { selectedIndex = index; }
    }

    public void selectVehicle(T car) {
        if (storedVehicles.contains(car)) { selectedIndex = storedVehicles.indexOf(car); }
    }

    // From IStorable

    public void loadStorable(T vehicle) {
        if (storedVehicles.size() + 1 < storageSpace && !vehicle.isStored()) {
            vehicle.setStorage(this);
            storedVehicles.add(vehicle);
        }
    }

    public T unloadStorable() {
        T unloadedCar = null;
        if (selectedIndex >= 0 && selectedIndex < storedVehicles.size()) {
            unloadedCar = storedVehicles.remove(selectedIndex);
            resetSelection();
        }
        return unloadedCar;
    }
}
