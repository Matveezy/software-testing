package third;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class GlowTest {

    Glow glow;

    @Test
    void glowAppearThenSparkle() {
        glow = new Glow(1);
        int startBrightness = glow.getBrightness();
        glow.sparkle();
        assertThat(glow.getBrightness()).isNotEqualTo(startBrightness)
                .isGreaterThan(startBrightness);
    }

    @Test
    void glowAppearedButNotBrightEnoughToTransform() {
        glow = new Glow(1);
        glow.sparkle();
        Optional<HalfMoon> maybeHalfMoon = glow.transform(glow);
        assertThat(maybeHalfMoon).isEmpty();
    }

    @Test
    void glowAppearedThenTransform() {
        glow = new Glow(10);
        glow.sparkle();
        Optional<HalfMoon> maybeHalfMoon = glow.transform(glow);
        assertThat(maybeHalfMoon).isPresent();
    }

    @Test
    void glowAppearedThenTransformToNarrowHalfMoon() {
        glow = new Glow(10);
        glow.sparkle();
        Optional<HalfMoon> maybeHalfMoon = glow.transform(glow);
        maybeHalfMoon.ifPresent((halfMoon) -> assertThat(halfMoon.getWidth()).isEqualTo(Width.NARROW));
    }
}
