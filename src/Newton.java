import static java.lang.Math.abs;

public class Newton {
    static int n = 0;

    public static String run(double a, double b, double e,  Equation func){
        double x, x0 = func.getX0(a,b);
            while (true) {
                x = x0 - func.getEq(x0) / func.getDerivate(x0);
                n++;
                if (abs(x - x0) < e || abs(func.getEq(x)) < e || abs(func.getEq(x) / func.getDerivate(x)) < e) {
                    break;
                }
                x0 = x;
            }
            return String.format("%.6f %.6f %d", x, func.getEq(x), n);

    }
}
