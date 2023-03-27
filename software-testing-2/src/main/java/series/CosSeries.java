package series;

import java.util.function.BiFunction;
import java.util.stream.LongStream;

public class CosSeries implements BiFunction<Double, Integer, Double>, Series<Double, Integer> {

    @Override
    public Double apply(Double x, Integer k) {
        return (Math.pow(-1, k) * Math.pow(x, (2 * k))) / (factorial(2 * k));
    }

    @Override
    public Double computeSeries(Double abscissa, Integer step) {
        double sum = 0;
        for (int i = 1; i <= step; i++) {
            Double apply = apply(abscissa, i);
            sum += apply;
        }
        return sum;
    }

    private long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }
}
