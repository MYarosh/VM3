import static java.lang.Math.abs;

public class Iterat {
    static int n = 0;

    public static String run(double a, double b, double e, Equation func){

        double x,l = -1/func.getMaxDel(a,b), x0 = func.getX0(a,b);
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
            return "";
        }
    }
    private static boolean check(double a, double b, double l,Equation func){
        System.out.println(a+ " "+b);
        System.out.printf("Производная от ф в а %.6f, в b %.6f, l=%.6f\n",func.getDelForIter(a,l), func.getDelForIter(b,l), l);
        for (double i=a;i<=b;i+=0.01){
            if (!(abs(func.getDelForIter(i,l))<1)){
                System.out.println("Не выполняется достаточное условие сходимости метода.");
                return false;
            }
        }
        return true;
    }
}
