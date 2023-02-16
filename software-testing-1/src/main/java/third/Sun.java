package third;

public class Sun {

    public void illuminate(Horizon horizon) {
        for (int i = 0; i < 100; i++) {
            horizon.setBlackSaturation(horizon.getBlackSaturation() - 0.1);
        }
    }
}
