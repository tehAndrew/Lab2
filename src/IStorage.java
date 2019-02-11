public interface IStorage<T extends IStorable> {

    void loadStorable(T storable);

    T unloadStorable();

}
