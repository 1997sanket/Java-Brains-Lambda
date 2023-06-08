package javabrains.lambda;

import java.util.function.BiConsumer;

/*
    If 'k' is zero, it will give ArithmeticException, so how do we handle that ?

    1. We can put try catch on accept method
        - But then how many catch blocks should we write ?
            because the perform method does not know what the implementation is, thus we don't know what Exception to catch

    2. Better approach is to handle the exception in the lambda itself, but the code won't be as elegant.

    3. Best approach here is to create a wrapper
 */

public class ExceptionHandling {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3};
        int key = 0;


        // Approach 2
        perform(numbers, key, (x, y) -> {

            try {
                System.out.println(x/y);
            } catch (ArithmeticException ae) {
                System.out.println(ae);
            }

        });


        // Approach 3 (wrapper)
        perform(numbers, key, wrapperLambda((x, y) -> System.out.println(x/y)));

    }

    private static void perform(int[] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
        for(int i : numbers) {
            biConsumer.accept(i, key);
        }
    }



    // We can also make this method a generic BiConsumer wrapper
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
        return (x, y) -> {
            try {
                biConsumer.accept(x, y);
            } catch (ArithmeticException ae) {
                System.out.println("Wrapper handling exception");
            }
        };
    }
}
