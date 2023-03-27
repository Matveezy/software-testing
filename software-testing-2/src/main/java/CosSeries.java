import java.util.function.BiFunction;
import java.util.stream.LongStream;

public class CosSeries implements BiFunction<Double, Integer, Double> {

    @Override
    public Double apply(Double x, Integer k) {
        return (Math.pow(-1, k) * Math.pow(x, (2 * k))) / (factorial(2 * k));
    }

    public double computeSeries(double x, int n) {
        return 0;
    }

    private long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

}
