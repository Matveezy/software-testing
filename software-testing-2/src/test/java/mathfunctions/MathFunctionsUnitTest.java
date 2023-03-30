package mathfunctions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class MathFunctionsUnitTest {

    private MathFunctions mathFunctions = Mockito.spy(new MathFunctions());

    @Test
    void cosTest() {
        Mockito.doReturn(0.0).when(mathFunctions).sin(0);
        Mockito.doReturn(0.0).when(mathFunctions).sin(Math.PI);
        Mockito.doReturn(1.0).when(mathFunctions).sin(Math.PI / 2);
        Mockito.doReturn(-1.0).when(mathFunctions).sin(3 * Math.PI / 2);

        assertEquals(0, mathFunctions.cos(Math.PI / 2), 0.001);
        assertEquals(0, mathFunctions.cos(3 * Math.PI / 2), 0.001);
        assertEquals(1, mathFunctions.cos(0), 0.001);
        assertEquals(-1, mathFunctions.cos(Math.PI), 0.001);
    }

    @Test
    void tanTest() {
        double x = -4.91;
        Mockito.doReturn(0.980538).when(mathFunctions).sin(x);
        Mockito.doReturn(0.196327).when(mathFunctions).cos(x);
        assertEquals(
                4.9944, mathFunctions.tan(x), 0.001);
    }

    @Test
    void cotanTest() {
        double x = 10.0;
        Mockito.doReturn(-0.544021).when(mathFunctions).sin(x);
        Mockito.doReturn(-0.839072).when(mathFunctions).cos(x);
        assertEquals(1.54235, mathFunctions.cotan(x), 0.001);
    }

    @Test
    void secTest() {
        double x = -5.0;
        Mockito.doReturn(0.283662).when(mathFunctions).cos(x);
        assertEquals(3.52535, mathFunctions.sec(x), 0.001);
    }

    @Test
    void cscTest() {
        double x = 45.0;
        Mockito.doReturn(0.850904).when(mathFunctions).sin(x);
        assertEquals(1.17522, mathFunctions.cosec(x), 0.001);
    }

    @Test
    void logTest() {
        int base = 8;
        double x = 56.0;
        Mockito.doReturn(4.02535).when(mathFunctions).ln(x);
        Mockito.doReturn(2.07944).when(mathFunctions).ln(base);
        assertEquals(1.93578, mathFunctions.log(x, base), 0.001);
    }

}