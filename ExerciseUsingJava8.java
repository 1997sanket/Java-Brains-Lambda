package javabrains.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class ExerciseUsingJava8 {
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Michael", "Scott", 45),
                new Person("Jim", "Halpert", 35),
                new Person("Dwight", "Schrute", 36),
                new Person("Pam", "Beesley", 32)
        );

        // Step 1: Sort list by last name
        Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2: Create a method that prints all elements in the list
        performWithCondition(personList, p -> true, p -> System.out.println(p));

        System.out.println();

        // Step 3: Create a method that prints all people last name beginning with "S"
        performWithCondition(personList, p -> p.getLastName().startsWith("S"), p -> System.out.println(p.getLastName()));

        System.out.println();


    }

    private static void performWithCondition(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
        for(Person person: personList) {
            if(predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }

}
