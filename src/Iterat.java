import static java.lang.Math.abs;

public class Iterat {
    static int n = 0;

    public static String run(double a, double b, double e, double x0, Equation func){
        double x,l = -1/func.getMaxDel(a,b);
        if (check(a,b,l,func)) {
            while (true) {
                x = func.getForIter(x0, l);
                n++;
                if (abs(x - x0) < e) {
                    break;
                }
                x0 = x;
            }
            return String.format("%.6f %.6f %d", x, func.getEq(x), n);
        }else{
            return "Не выполняется достаточное условие сходимости метода.";
        }
    }
    private static boolean check(double a, double b, double l, Equation func){
        return (func.getForIter(a,l)<1 && func.getForIter(b,l)<1);
    }
}
