package series;

import mathfunctions.MathFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LnSeriesIntegrationTest {

    MathFunctions mathFunctions;

    @BeforeEach
    void setUp() {
        mathFunctions = new MathFunctions();
    }

    @ParameterizedTest
    @MethodSource("logarithmArgs")
    void testLogarithm(int base, double value, double expected) {
        assertEquals(expected, mathFunctions.log(value, base), 0.001);
    }

    static Stream<Arguments> logarithmArgs() {
        return Stream.of(
                Arguments.of(3, 27, 3),
                Arguments.of(2, 128, 7),
                Arguments.of(3, -4, Double.NaN),
                Arguments.of(0, 4, Double.NaN),
                Arguments.of(-1, -12, Double.NaN),
                Arguments.of(2, 0.125, -3),
                Arguments.of(64, 8, 0.5),
                Arguments.of(16, 4, 0.5),
                Arguments.of(256, 16, 0.5),
                Arguments.of(1024, 2, 0.1)
        );
    }
}