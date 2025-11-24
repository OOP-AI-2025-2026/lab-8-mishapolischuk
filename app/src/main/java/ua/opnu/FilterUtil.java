package ua.opnu;
import java.util.Arrays;
import java.util.function.Predicate;

public class FilterUtil {

    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {

        T[] result = Arrays.copyOf(input, input.length);

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }
}