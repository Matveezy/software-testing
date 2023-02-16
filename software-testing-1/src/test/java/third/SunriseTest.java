package third;

import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class SunriseTest {

    Sunrise sunrise;
    Glow glow;
    Horizon horizon;

    @Test
    void successSunrise() {
        initGlowAndHorizonForSuccessSunrise();
        assertThat(sunrise.process())
                .isTrue();
    }

    @Test
    void processSunriseWithEnoughTime() {
        initGlowAndHorizonForSuccessSunrise();
        org.junit.jupiter.api.Assertions.assertTimeout(Duration.ofMillis(2500L), () -> {
            sunrise.process();
        });
    }

    @Test
    void processSunriseButHorizonNotBrightEnough() {
        initHorizonNotBrightEnoughForSunrise();
        assertThat(sunrise.process())
                .isFalse();
    }

    @Test
    void processSunriseButGlowNotBrightEnough() {
        initGlowNotBrightEnoughForSunrise();
        assertThat(sunrise.process())
                .isFalse();
    }

    void initGlowAndHorizonForSuccessSunrise() {
        glow = new Glow(10);
        horizon = new Horizon(30);
        sunrise = new Sunrise(glow, horizon);
    }

    void initHorizonNotBrightEnoughForSunrise() {
        glow = new Glow(10);
        horizon = new Horizon(60);
        sunrise = new Sunrise(glow, horizon);
    }

    void initGlowNotBrightEnoughForSunrise() {
        glow = new Glow(1);
        horizon = new Horizon(30);
        sunrise = new Sunrise(glow, horizon);
    }
}
