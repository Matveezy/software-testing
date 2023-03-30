package series;

import java.util.function.Function;

public class LnSeries implements Function<Double,Double> {

    static private final double eps = 0.0000001;

    @Override
    public Double apply(Double value) {
        if (value <= 0 || Double.isNaN(value) || Double.isInfinite(value)) {
            return Double.NaN;
        }
        double x = (value - 1) / (value + 1);
        return findSum(x, LnSeries::lnTaylorMember);
    }


    private static double lnTaylorMember(double x, int n) {
        if (n % 2 == 0) {
            return 0;
        } else {
            return 2 * Math.pow(x, n) / n;
        }
    }

    private double findSum(double value, FunctionMemberFinder finder) {
        double result = 0;
        double prev = 0;
        double current = Double.MAX_VALUE;
        int n = 0;
        while (Math.abs(current - prev) >= eps) {
            prev = current;
            current = finder.calculate(value, n);
            result += current;
            n += 1;
        }
        return result;
    }

    interface FunctionMemberFinder {
        double calculate(double x, int n);
    }
}
