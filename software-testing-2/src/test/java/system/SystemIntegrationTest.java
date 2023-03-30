package system;

import mathfunctions.MathFunctions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SystemIntegrationTest {

    System system = new System(new MathFunctions());

    @ParameterizedTest
    @ValueSource(doubles = {-7.177, -6.28, -2.443, -3.14, -0.8942})
    void extremumPoints(double x) {
        double step = 0.01;
        double left = system.system(x - step);
        double right = system.system(x + step);
        double extr = system.system(x);
        assertTrue(extr > left && extr > right || extr < left && extr < right);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testSystem(double x, double expected) {
        assertEquals(expected, system.system(x), 0.001);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(-3.56, 1.22078),
                Arguments.of(-11.48, 6.92979),
                Arguments.of(-0.1, 1.055233),
                Arguments.of(-5.22, 6.52373),
                Arguments.of(-20.91, 3.35934),
                Arguments.of(2.3, 1.01135),
                Arguments.of(0.02, -4.75012),
                Arguments.of(7.34, 2.42038),
                Arguments.of(15.99, 3.36582),
                Arguments.of(23.13, 3.81407)
        );
    }
}