package series;

import mathfunctions.MathFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class CosSeriesIntegrationTest {

    MathFunctions mathFunctions;

    @BeforeEach
    void setUp() {
        mathFunctions = new MathFunctions();
    }

    @ParameterizedTest
    @MethodSource("sinArgs")
    void sinTest(double x, double expected) {
        assertEquals(expected, mathFunctions.sin(x), 0.001);
    }

    @ParameterizedTest
    @MethodSource("tanArgs")
    void tanTest(double x, double expected) {
        assertEquals(expected, mathFunctions.tan(x), 0.001);
    }

    @ParameterizedTest
    @MethodSource("cotanArgs")
    void cotanTest(double x, double expected) {
        assertEquals(expected, mathFunctions.cotan(x), 0.001);
    }

    @ParameterizedTest
    @MethodSource("secArgs")
    void secTest(double x, double expected) {
        assertEquals(expected, mathFunctions.sec(x), 0.001);
    }

    @ParameterizedTest
    @MethodSource("cscArgs")
    void cscTest(double x, double expected) {
        assertEquals(expected, mathFunctions.cosec(x), 0.001);
    }

    static Stream<Arguments> sinArgs() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(Math.PI / 6, 0.5),
                Arguments.of(Math.PI / 4, Math.sqrt(2) / 2),
                Arguments.of(Math.PI / 3, Math.sqrt(3) / 2),
                Arguments.of(Math.PI / 2, 1.0),
                Arguments.of(-1 * Math.PI / 6, -0.5),
                Arguments.of(-1 * Math.PI / 4, -1 * Math.sqrt(2) / 2),
                Arguments.of(-1 * Math.PI / 3, -1 * Math.sqrt(3) / 2),
                Arguments.of(-1 * Math.PI / 2, -1.0),
                Arguments.of(Math.PI, 0.0)
        );
    }

    static Stream<Arguments> tanArgs() {
        return Stream.of(
                Arguments.of(0, 0.0),
                Arguments.of(PI, 0.0),
                Arguments.of(PI / 3, sqrt(3)),
                Arguments.of(PI / 4, 1.0),
                Arguments.of(PI / 6, sqrt(3) / 3)
        );
    }

    static Stream<Arguments> cotanArgs() {
        return Stream.of(
                Arguments.of(PI / 6, sqrt(3)),
                Arguments.of(PI / 4, 1.0),
                Arguments.of(PI / 3, sqrt(3) / 3)
        );
    }

    static Stream<Arguments> secArgs() {
        return Stream.of(
                Arguments.of(0.0, 1.0),
                Arguments.of(Math.PI/6, 2*Math.sqrt(3)/3),
                Arguments.of(Math.PI/4, Math.sqrt(2)),
                Arguments.of(Math.PI/3, 2),
                Arguments.of(-1*Math.PI/6, 1*2*Math.sqrt(3)/3),
                Arguments.of(-1*Math.PI/4, 1*Math.sqrt(2)),
                Arguments.of(-1*Math.PI/3, 2.0),
                Arguments.of(Math.PI, -1.0)
        );

    }

    static Stream<Arguments> cscArgs() {
        return Stream.of(
                Arguments.of(PI / 6, 2),
                Arguments.of(PI / 4, sqrt(2)),
                Arguments.of(PI / 3, 2 / sqrt(3)),
                Arguments.of(PI / 2, 1.0),
                Arguments.of(3 * PI / 2, -1.0)
        );
    }
}