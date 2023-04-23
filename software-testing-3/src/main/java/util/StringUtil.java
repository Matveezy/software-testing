package util;

public class StringUtil {
    public static int parsePrice(String price) {
        return Integer.parseInt(price.replace("₽", "").replace(" ", ""));
    }
    public static int parseMileage(String mileage) {
        return Integer.parseInt(mileage.replace("км", "").replace(" ", ""));
    }
}
