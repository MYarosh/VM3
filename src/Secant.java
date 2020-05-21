import static java.lang.Math.abs;

public class Secant {
    static int n = 0;

    public static String run(double a, double b, double e,  Equation func){
        double x,  x0 = func.getX0(a,b);
            double x1 = x0+1;
            while (true) {
                x = x1 - (x1 - x0) / (func.getEq(x1) - func.getEq(x0)) * func.getEq(x1);
                n++;
                if (abs(x - x1) < e || abs(func.getEq(x)) < e) {
                    break;
                }
                x0 = x1;
                x1 = x;
            }
            return String.format("%.6f %.6f %d", x, func.getEq(x), n);
    }

}
