package mathfunctions;

import series.CosSeries;
import series.LnSeries;

public class MathFunctions {

    private final CosSeries cosSeries = new CosSeries();
    private final LnSeries lnSeries = new LnSeries();

    public double cos(double x) {
        return cosSeries.apply(x);
    }

    public double sin(double x) {
        return cos(Math.PI / 2 - x);
    }

    public double tan(double x) {
        return sin(x) / cos(x);
    }

    public double cotan(double x) {
        return 1 / tan(x);
    }

    public double sec(double x) {
        return 1 / cos(x);
    }

    public double cosec(double x) {
        return 1 / sin(x);
    }

    public double ln(double x) {
        return lnSeries.apply(x);
    }

    public double log(double x, int base) {
        return ln(x) / ln(base);
    }
}
