import java.util.ArrayList;

public class Workshop <T extends Vehicle> implements IStorage<T> {
    private int storageSpace;
    private ArrayList<T> storedCars;
    private int highlightedIndex;

    public Workshop(int storageSpace) {
        this.storageSpace = storageSpace;
        storedCars = new ArrayList(storageSpace);
        highlightNothing();
    }

    private void highlightNothing() { highlightedIndex = -1; }

    public void highlightCar(int index) {
        if (index >= 0 && index < storedCars.size()) { highlightedIndex = index; }
    }

    public void highlightCar(T car) {
        if (storedCars.contains(car)) { highlightedIndex = storedCars.indexOf(car); }
    }

    // From IStorable

    public void loadStorable(T car) {
        if (storedCars.size() + 1 < storageSpace && !car.isStored()) {
            car.setStorage(this);
            storedCars.add(car);
        }
    }

    public T unloadStorable() {
        T unloadedCar = null;
        if (highlightedIndex >= 0 && highlightedIndex < storedCars.size()) {
            unloadedCar = storedCars.remove(highlightedIndex);
            highlightNothing();
        }
        return unloadedCar;
    }
}
