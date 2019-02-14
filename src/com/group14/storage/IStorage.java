package com.group14.storage;

public interface IStorage<T extends IStorable> {

    void loadStorable(T storable);

    T unloadStorable();

}
