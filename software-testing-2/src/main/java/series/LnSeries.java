package series;

import java.util.function.BiFunction;

public class LnSeries implements BiFunction<Double, Integer, Double>, Series<Double, Integer> {


    @Override
    public Double computeSeries(Double abscissa, Integer step) {
        if (abscissa <= 0) {
            return Double.NaN;
        }
        Double val = (abscissa - 1) / (abscissa + 1);

        return null;
    }

    @Override
    public Double apply(Double x, Integer k) {
        if (k % 2 == 0) {
            return 0.0;
        } else {
            return 2 * Math.pow(x, k) / k;
        }
    }
}
