public class Matrix {
    private int n,m;
    public void setN(int n) {this.n = n;}
    public int getN() {return n;}
    public void setM(int m) {this.m = m;}
    public int getM() {return m;}
    public Complex[][] getMatrix() {return matrix;}
    public void setMatrix(Complex[][] matrix) {this.matrix = matrix;}
    private Complex[][] matrix;
    public Matrix(Complex[][] arr) {
        this.n = arr.length;
        this.m = arr[0].length;
        matrix = arr;
    }
    public Matrix() {
        this.n = 0;
        this.m = 0;
        matrix = new Complex[0][0];
    }
    public Matrix(int n, int m) {
        if (n<=0 || m<=0)
            throw new IllegalArgumentException("Number of rows or columns cannot be negative or zero numbers");
        this.n = n;
        this.m = m;
        matrix = new Complex[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                matrix[i][j] = new Complex();
    }
    public Matrix(int n) {
        this(n, n);
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j].print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public Matrix plus(Matrix q) {
        if (this.n != q.n || this.m != q.m)
            throw new IllegalArgumentException("Matrices have different numbers of rows or columns");
        Matrix new_m = new Matrix(n, m);
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                new_m.matrix[i][j] = this.matrix[i][j].plus(q.matrix[i][j]);
        return new_m;
    }
    public Matrix minus(Matrix q) {
        if (this.n != q.n || this.m != q.m)
            throw new IllegalArgumentException("Matrices have different numbers of rows or columns");
        Matrix new_m = new Matrix(n, m);
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                new_m.matrix[i][j] = this.matrix[i][j].minus(q.matrix[i][j]);
        return new_m;
    }
    public Matrix multiply(Matrix q) {
        if (this.m!=q.n)
            throw new IllegalArgumentException("Matrices are not compatible for this operation");
        Matrix new_m = new Matrix(this.n, q.m);
        for(int i = 0; i < this.n; i++)
            for(int j = 0; j < q.m; j++)
                for (int k = 0; k < q.n; k++)
                    new_m.matrix[i][j] = new_m.matrix[i][j].plus(this.matrix[i][k].multiply(q.matrix[k][j]));
        return new_m;
    }
    public Matrix transposing() {
        Matrix new_m = new Matrix(m, n);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                new_m.matrix[j][i] = this.matrix[i][j];
        }
        return new_m;
    }

    public Matrix minor(int x, int y) {
        Matrix minor = new Matrix(this.m-1, this.n-1);
        int u = 0, v = 0;
        for (int i = 0; i < this.n; i++) {
            if (i!=x){
                for (int j = 0; j < this.m; j++) {
                    if (j != y) {
                        minor.matrix[u][v] = this.matrix[i][j];
                        v++;
                    }
                }
                u++;
                v = 0;
            }
        }
        return minor;
    }
    public Complex determinant() {
        if (this.n != this.m) {
            throw new IllegalArgumentException("Matrix must be square for this operation");
        }
        if (this.m == 1) {
            return this.matrix[0][0];
        }
        Complex deter = new Complex(0,0);
        for (int i = 0; i < this.m; i++) {
            Complex cur_det = this.matrix[0][i].multiply(this.minor(0, i).determinant());
            if (i%2==0) {
                deter = deter.plus(cur_det);
            }
            else {
                deter = deter.minus(cur_det);
            }
        }
        return deter;
    }
}
