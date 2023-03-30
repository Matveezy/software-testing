package series;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class CosSeriesUnitTest {

    private CosSeries cosSeries;

    @BeforeEach
    void setUp() {
        cosSeries = new CosSeries();
    }

    @ParameterizedTest
    @MethodSource("cosArgs")
    void testSinPositiveArgs(double x, double expected) {
        assertEquals(expected, cosSeries.apply(x), 0.001);
    }

    @ParameterizedTest
    @MethodSource("cosArgs")
    void testSinNegativeArgs(double x, double expected) {
        assertEquals(expected, cosSeries.apply(-x), 0.001);
    }

    static Stream<Arguments> cosArgs() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(PI, -1),
                Arguments.of(PI / 2, 0),
                Arguments.of(PI / 3, 0.5),
                Arguments.of(PI / 4, sqrt(2) / 2),
                Arguments.of(PI / 6, sqrt(3) / 2),
                Arguments.of(2 * PI / 3, -0.5),
                Arguments.of(3 * PI / 4, -sqrt(2) / 2),
                Arguments.of(5 * PI / 6, -sqrt(3) / 2),
                Arguments.of(2 * PI, 1),
                Arguments.of(3 * PI, -1),
                Arguments.of(3 * PI / 2, 0),
                Arguments.of(16 * PI / 3, -0.5));
    }
}