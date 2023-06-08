package javabrains.lambda;

import java.util.function.Consumer;

public class Closure {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Scope of 'b' should not be available outside the main method. But still it works when the method is executed in perform
        // Here the compiler saves value of 'b' so that the perform method when executes 'accept' it will have the value of 'b'
        perform(a, i -> System.out.println(i + b));
    }

    private static void perform(int x, Consumer<Integer> consumer) {
        consumer.accept(x);
    }
}
