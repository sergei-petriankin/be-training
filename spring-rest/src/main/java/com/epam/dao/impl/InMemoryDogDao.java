package com.epam.dao.impl;

import com.epam.dao.DogDao;
import com.epam.model.Dog;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class InMemoryDogDao implements DogDao {

    private static ConcurrentHashMap<UUID, Dog> dogs = new ConcurrentHashMap<>();

    public Dog createDog(Dog dog) {
        dogs.put(dog.getId(), dog);
        return dog;
    }

    public Dog getDog(UUID id) {
        return dogs.get(id);
    }

    public Dog updateDog(UUID id, Dog dog) {
        return dogs.put(id, dog);
    }

    public void deleteDog(UUID id) {
        dogs.remove(id);
    }
}
