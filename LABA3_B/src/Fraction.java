
public class Fraction { //дроби
    int num;
    int den=0;

    @Override //переопределение
    public String toString() {
        return num + "/" + den;
    }

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public int getnum() {
        return num;
    }

    public int getden() {
        return den;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public void setden(int den) {
        this.den = den;
    }
    public boolean exsist (){
        if(den==0) {
            return false;
        }
        return true;
    }
    public Fraction divide(Fraction f1, Fraction f2) {
        Fraction end = new Fraction(0, 1);
        end.setnum(f1.num * f2.den);
        end.setden(f1.den * f2.num);
        return end;
    }
    public Fraction invert () {
        this.num=this.num*(-1);
        return this;
    }
}
