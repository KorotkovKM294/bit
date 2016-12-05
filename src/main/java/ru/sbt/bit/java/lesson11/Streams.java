package ru.sbt.bit.java.lesson11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

/**
 * Streams
 *
 * Created on 05.12.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Streams {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("alex", "lala", 1, new Child("child", 19)),
                new Person("dsa", "fdfd", 1, new Child("papa", 18)));

        for (Child child : collectChildren(persons)) {
            System.out.println(child.getName());
        }
    }

    public static List<Child> collectChildren(List<Person> persons) {
        return persons.stream()
                .map(person -> person.getChild())
                .filter(child -> child.getAge() > 18)
                .sorted(comparing(Child::getName))
                .collect(Collectors.toList());
    }

    public static Person getPersonWithMaxAge(List<Person> persons) {
        Optional<Person> person = persons.stream()
                .max(comparing(Person::getAge));
        return person.orElse(null);
    }

    public static Map<Integer, List<Person>> personsWithAgeKey(List<Person> persons) {
        return persons.stream()
                .collect(groupingBy(Person::getAge));
    }

//    public static Map<Integer, List<Child>> perrsonsWithAgeKey(Map<Integer, List<Person>> persons) {
//        return persons.entrySet().stream()
//                .filter(e -> e.getKey() == e.getValue().get(0).child.getAge())
//                .collect(groupingBy(Person::getChild));
//    }
}
