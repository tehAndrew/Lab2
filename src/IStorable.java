public interface IStorable {

    void setStorage(IStorage storage);

    void unloadFromStorage();

    boolean isStored();

}
