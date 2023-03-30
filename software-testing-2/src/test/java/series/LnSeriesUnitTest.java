package series;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.exp;
import static org.junit.jupiter.api.Assertions.*;

class LnSeriesUnitTest {

    LnSeries lnSeries;

    @BeforeEach
    void setUp() {
        lnSeries = new LnSeries();
    }

    @ParameterizedTest
    @MethodSource("logArgs")
    void testLogarithm(double x, double expected) {
        assertEquals(expected, lnSeries.apply(x), 0.001);
    }

    static Stream<Arguments> logArgs() {
        return Stream.of(
                Arguments.of(exp(3), 3),
                Arguments.of(exp(5), 5),
                Arguments.of(exp(8), 8),
                Arguments.of(1, 0),
                Arguments.of(exp(10), 10),
                Arguments.of(exp(0.1), 0.1),
                Arguments.of(0, Double.NaN),
                Arguments.of(-5, Double.NaN),
                Arguments.of(-1, Double.NaN),
                Arguments.of(-0.5, Double.NaN)
        );
    }
}