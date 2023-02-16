package first;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SinSeries implements BiFunction<Double, Integer, Double> {

//    затестить на промежутке

    public double computeSeries(double x, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            Double apply = apply(x, i);
            sum += apply;
        }
        return sum;
    }

    @Override
    public Double apply(Double x, Integer n) {
        return (Math.pow(-1, (n - 1)) * Math.pow(x, (2 * n - 1))) / (factorial(2 * n - 1));
    }

    private long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

}
