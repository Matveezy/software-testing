package first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SinSeriesTest {

    SinSeries sinSeries;

    @BeforeEach
    void setUp() {
        sinSeries = new SinSeries();
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/series-data-test.csv", numLinesToSkip = 1)
    void seriesParametrizedTest(double x, int n, double expected, double delta) {
        Double result = sinSeries.computeSeries(x, n);
        assertEquals(expected, result, delta);
    }
}