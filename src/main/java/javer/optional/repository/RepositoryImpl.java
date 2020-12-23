package javer.optional.repository;

import javer.optional.model.Person;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {

    @Override
    public Optional<List<String>> getListOfNames() {
        return Optional
                .of(persons
                        .stream()
                        .map(Person::getName)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Integer>> getListOfAges() {
        return Optional
                .of(persons
                        .stream()
                        .map(Person::getAge)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<Person> getByName(String name) {
        return Optional
                .of(persons
                        .stream()
                        .filter(person -> person.getName().equals(name))
                        .findAny()
                        .orElseThrow());
    }

    @Override
    public Optional<Person> getByAge(int age) throws NoSuchElementException {
        return Optional
                .of(persons
                        .stream()
                        .filter(person -> person.getAge() == age)
                        .findAny()
                        .orElseThrow());
    }
}
