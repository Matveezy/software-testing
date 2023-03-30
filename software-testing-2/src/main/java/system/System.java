package system;

import mathfunctions.MathFunctions;

import java.text.DecimalFormat;
import java.util.stream.Stream;

public class System {

    private final MathFunctions mathFunctions;

    public System(MathFunctions mathFunctions) {
        this.mathFunctions = mathFunctions;
    }

    public double system(double x) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##############");
        if (x <= 0) return Double.parseDouble(decimalFormat.format(trigonometricEq(x)).replace(",", "."));
        else return Double.parseDouble(decimalFormat.format(logarithmicEq(x)).replace(",", "."));
    }

    public double trigonometricEq(double x) {
        return Math.pow((((((((mathFunctions.cotan(x) + mathFunctions.cosec(x)) * mathFunctions.sec(x)) - mathFunctions.tan(x)) / mathFunctions.cosec(x)) / (mathFunctions.cotan(x) + mathFunctions.sec(x))) / mathFunctions.cosec(x)) + mathFunctions.sec(x)),
                2);
    }

    public double logarithmicEq(double x) {
        return (Math.pow((((mathFunctions.log(x, 10) + mathFunctions.log(x, 10)) + mathFunctions.ln(x)) - mathFunctions.ln(x)), 2) / mathFunctions.log(x, 5));
    }

}
