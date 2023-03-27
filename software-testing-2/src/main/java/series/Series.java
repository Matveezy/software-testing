package series;

public interface Series<A, B> {

    A computeSeries(A abscissa, B step);
}
