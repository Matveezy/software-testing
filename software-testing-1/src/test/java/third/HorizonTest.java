package third;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HorizonTest {

    Horizon horizon;
    Sun sun;

    @BeforeEach
    void setUp() {
        sun = new Sun();
    }

    @Test
    void sunDoesNotIlluminateEnough() {
        horizon = new Horizon(40);
        sun.illuminate(horizon);
        assertThat(horizon.isIlluminated()).isFalse();
    }

    @Test
    void sunIlluminatesHorizon() {
        horizon = new Horizon(30);
        sun.illuminate(horizon);
        assertThat(horizon.isIlluminated()).isTrue();
    }
}
