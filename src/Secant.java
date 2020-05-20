import static java.lang.Math.abs;

public class Secant {
    static int n = 0;

    public static String run(double a, double b, double e, double x0, Equation func){
        double x;
        if (check(a,b,x0,func)) {
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
        }else{
            return "Неправильный выбор начального приближения.";
        }
    }
    private static boolean check(double a, double b, double x0, Equation func){
        if (a>b){
            double c = b;
            b = a;
            a = c;
        }
        if (x0<a||x0>b){
            return false;
        }
        return (func.getEq(x0)*func.getDerivate2(x0)>0);
    }
}
