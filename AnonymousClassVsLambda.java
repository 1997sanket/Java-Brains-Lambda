package javabrains.lambda;

/*
    Lambda and Anonymous class are not quite same.
    We can know the difference with context of "this" reference
 */

import java.util.function.Consumer;

public class AnonymousClassVsLambda {
    public static void main(String[] args) {

        // Anonymous class
        perform("Sanket", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("This in Anonymous class: " + this);
                System.out.println(s);
            }

            @Override
            public String toString() {
                return "Anonymous inner class";
            }
        });

        System.out.println();

        // Lambda
        perform("Sanket", s -> {
            // System.out.println("This in Anonymous class: " + this); // here "this" is not allowed
            System.out.println(s);
        });
    }


    static void perform(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }
}
