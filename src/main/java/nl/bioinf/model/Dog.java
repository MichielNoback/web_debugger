package nl.bioinf.model;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private String breed;
    private Gender gender;
    private String name;

    public Dog(String breed, Gender gender, String name) {
        this.breed = breed;
        this.gender = gender;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (breed != null ? !breed.equals(dog.breed) : dog.breed != null) return false;
        if (gender != dog.gender) return false;
        return name != null ? name.equals(dog.name) : dog.name == null;
    }

    @Override
    public int hashCode() {
        int result = breed != null ? breed.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }

    public static List<Dog> serveSomeDogs() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Stabij", Gender.MALE, "Kees"));
        dogs.add(new Dog("Springer", Gender.FEMALE, "Fleur"));
        dogs.add(new Dog("Chihuahua", Gender.FEMALE, "Lietsje"));
        dogs.add(new Dog("Labradoodle", Gender.MALE, "Ollie"));
        dogs.add(new Dog("Jack Russel", Gender.FEMALE, "Bietertje"));
        return dogs;
    }
}
