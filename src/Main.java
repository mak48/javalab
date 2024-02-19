public class Main {
    public static void main(String[] args) {
        //создание матриц
        Matrix example1,example2;
        Complex[][] arr1 = {{new Complex(1,0),new Complex(2,0)},{new Complex(3,0),new Complex(4,0)}};
        Complex[][] arr2 = {{new Complex(5,0),new Complex(6,0)},{new Complex(7,0),new Complex(8,0)}};
        example1 = new Matrix(arr1);
        example2 = new Matrix(arr2);
        System.out.println("first matrix");
        example1.print();
        System.out.println("\nsecond matrix");
        example2.print();

        //пример сложения
        Matrix sum = example1.plus(example2);
        System.out.println("\nsum of matrices");
        sum.print();

        //пример вычитания
        Matrix sub = example2.minus(example1);
        System.out.println("\nsubtraction of matrices");
        sub.print();

        //пример умножения
        Matrix mul = example1.multiply(example2);
        System.out.println("\nmultiplication of matrices");
        mul.print();

        //пример транспонирования
        Matrix tr = example1.transposing();
        System.out.println("\ntransposition of first matrix");
        tr.print();

        //детерминант
        Complex d1 = example1.determinant();
        System.out.print("\ndeterminant of first matrix\n");
        d1.print();
    }
}