package analysis;

import java.util.concurrent.Callable;

/**
 * Timing analysis on a Callable class.
 *
 * @author Rajit Banerjee, 18202817
 */

public class Timing {
    /**
     * @param callable a class that is Callable
     * @param <E>      generic type of return value of the call() method in callable
     * @return the time in nanoseconds taken to execute the call() method in callable
     * @throws Exception in case of any unusual event
     */
    public static <E> long nanoTimePerformance(Callable<E[]> callable)
            throws Exception {
        long startTime = System.nanoTime();
        callable.call();
        return System.nanoTime() - startTime;
    }

}