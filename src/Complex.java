public class Complex {

    private int real;
    private int i;
    public void setReal(int real) {this.real = real;}
    public int getReal() {return real;}
    public void setI(int i) {this.i = i;}
    public int getI() {return i;}
    public Complex(){
        real = 0;
        i = 0;
    }
    public Complex(int real, int i){
        this.real = real;
        this.i = i;
    }
    public Complex plus(Complex z){
        Complex new_complex = new Complex();
        new_complex.real = this.real+z.real;
        new_complex.i = this.i+z.i;
        return new_complex;
    }
    public Complex minus(Complex z){
        Complex new_complex = new Complex();
        new_complex.real = this.real-z.real;
        new_complex.i = this.i-z.i;
        return new_complex;
    }
    public Complex multiply(Complex z){
        int res_real = this.real*z.real - this.i*z.i;
        int res_i= this.real*z.i + this.i*z.real;
        return new Complex(res_real, res_i);
    }
    public void print(){
        if (this.i>=0)
            System.out.print(real+"+"+i+"i");
        else
            System.out.print(real+"-"+i+"i");
    }
}
