package javer.optional.repository;

import javer.optional.model.Person;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface Repository {

    List<Person> persons = List.of(new Person("Ula", 25), new Person("Anna", 32), new Person("Stefan", 55), new Person("Jacek", 36));

    Optional<List<String>> getListOfNames();

    Optional<List<Integer>> getListOfAges();

    Optional<Person> getByName(String name);

    Optional<Person> getByAge(int age) throws NoSuchElementException;
}
