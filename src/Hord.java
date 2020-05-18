import static java.lang.Math.abs;

public class Hord {
    static int n = 0;

    public static String run(double a, double b, double e, Equation func){
        double x,y,x0 = 0;
        if (check(a,b,func)) {
            while (true) {
                x = (a * func.getEq(b) - b * func.getEq(a)) / (func.getEq(b) - func.getEq(a));
                y = func.getEq(x);
                if (y * func.getEq(a) > 0) {
                    a = x;
                } else {
                    b = x;
                }
                n++;
                if (abs(x - x0) < e || abs(y) < e) {
                    break;
                }
                x0 = x;
            }
            return String.format("%.6f %.6f %d", x, func.getEq(x), n);
        }else{
            return "На заданном промежутке нет корней";
        }
    }
    private static boolean check(double a, double b, Equation func){
        if (a>b){
            double c = b;
            b = a;
            a = c;
        }
        return ((a<func.getRoot(0)&&b>func.getRoot(0))||(a<func.getRoot(1)&&b>func.getRoot(1))||(a<func.getRoot(2)&&b>func.getRoot(2)));
    }
}
