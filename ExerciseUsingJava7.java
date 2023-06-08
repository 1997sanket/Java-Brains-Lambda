package javabrains.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Condition {
    boolean test(Person person);
}

public class ExerciseUsingJava7 {
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Michael", "Scott", 45),
                new Person("Jim", "Halpert", 35),
                new Person("Dwight", "Schrute", 36),
                new Person("Pam", "Beesley", 32)
        );

        // Step 1: Sort list by last name
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        // Step 2: Create a method that prints all elements in the list
        printAll(personList);

        System.out.println();

        // Step 3: Create a method that prints all people last name beginning with "S"
        printWithCondition(personList, new Condition() {

            @Override
            public boolean test(Person person) {
                return person.getLastName().startsWith("S");
            }
        });

        System.out.println();

        // Step 4: Modified Step 2
        printWithCondition(personList, new Condition() {
            @Override
            public boolean test(Person person) {
                return true;
            }
        });
    }

    private static void printWithCondition(List<Person> personList, Condition condition) {
        for(Person person: personList) {
            if(condition.test(person)) {
                System.out.println(person);
            }
        }
    }

    private static void printAll(List<Person> personList) {
        for(Person person : personList) {
            System.out.println(person);
        }
    }
}
