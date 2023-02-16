package third;

import java.util.Optional;

public class Glow implements Transformation<Glow, HalfMoon>, Sparkable {

    private int brightness;

    public Glow(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public Optional<HalfMoon> transform(Glow from) {
        if (brightness > 30) {
            return Optional.of(new HalfMoon(Width.NARROW));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void sparkle() {
        this.brightness += 25;
    }

    public int getBrightness() {
        return brightness;
    }
}
