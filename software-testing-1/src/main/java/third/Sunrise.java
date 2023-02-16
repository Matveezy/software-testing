package third;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sunrise {

    private Glow glow;
    private List<Sun> suns;
    private Horizon horizon;
    private boolean isFinished = false;

    public Sunrise(Glow glow, Horizon horizon) {
        this.glow = glow;
        this.horizon = horizon;
        suns = new ArrayList<>();
    }

    public boolean process() {
        glow.sparkle();
        Optional<HalfMoon> halfMoon = glow.transform(glow);
        halfMoon.ifPresent((hm) -> {
            try {
                Thread.sleep(2000L);
                suns.addAll(List.of(
                        new Sun(),
                        new Sun()
                ));
                suns.stream()
                        .forEach((sun) -> sun.illuminate(horizon));
                isFinished = horizon.isIlluminated();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return isFinished;
    }
}
