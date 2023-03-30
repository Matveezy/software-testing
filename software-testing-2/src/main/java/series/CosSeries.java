package series;

import java.util.function.Function;

import static java.lang.Math.abs;

public class CosSeries implements Function<Double, Double> {

    static private final double eps = 0.0000001;

    @Override
    public Double apply(Double value) {
        if (value.isNaN() || value.isInfinite()) {
            return Double.NaN;
        }
        double s, an;
        int n;
        n = 0;
        an = 1;
        s = 0;
        while (abs(an) > eps) {
            s += an;
            n++;
            an *= -value * value / (2. * n - 1.0) / (2.0 * n);
        }
        return s;
    }
}
