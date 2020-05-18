import static java.lang.Math.pow;

public class Equation {
    private double[] roots = {-2.29508,-0.521733,1.11231};
    //2,335𝑥3+3,98𝑥2−4,52𝑥−3,11
    public double getEq(double x){
        return 2.335*pow(x,3)+3.98*pow(x,2)-4.52*x-3.11;
    }
    public double getDerivate(double x){
        return 2.335*3*pow(x,2)+3.98*2*x-4.52;
    }
    public double getDerivate2(double x){
        return 2.335*3*pow(x,2)+3.98*2*x-4.52;
    }
    public double getForIter(double x,double l){
        return l*2.335*pow(x,3)+l*4.98*pow(x,2)-l*4.52*x-l*3.11;
    }
    public double getMaxDel(double a, double b){
        return Math.max(getDerivate(b),getDerivate(a));
    }
    public double getRoot(int i){return roots[i];}
}
