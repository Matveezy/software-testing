package third;

public class Horizon {

    private double blackSaturation;
    private boolean isIlluminated = false;

    public Horizon(double blackSaturation) {
        this.blackSaturation = blackSaturation;
    }

    public double getBlackSaturation() {
        return blackSaturation;
    }

    public boolean isIlluminated() {
        return this.blackSaturation < 25;
    }

    public void setBlackSaturation(double blackSaturation) {
        this.blackSaturation = blackSaturation;
    }
}
