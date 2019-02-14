package com.group14.storage;

public interface IStorable {

    void setStorage(IStorage storage);

    void unloadFromStorage();

    boolean isStored();

}
