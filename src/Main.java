import ComplexNumberPackage.ComplexNumber;
import MatrixPackage.Matrix;
public class Main {
    public static void main(String[] args) {
        var matrix1 = new Matrix(3,3, new String[][]{
                        new String[]{"1-i","2+i2","2"},
                        new String[]{"-i6","-6","-5+i"},
                        new String[]{"i2","1","0"}});
        var matrix2 = new Matrix(3,3, new String[][]{
                        new String[]{"-i","i5","i"},
                        new String[]{"4-i","2+i4","12"},
                        new String[]{"i","i2","-3-i5"}
        });
        var matrix3 = new Matrix(4,2, new String[][]{
                new String[]{"-i","i5"},
                new String[]{"4-i","2+i4"},
                new String[]{"-i2","7+i5"},
                new String[]{"i","2-i5"}});
        var matrix4 = new Matrix(2,4, new String[][]{
                new String[]{"-i","i5","i","-i"},
                new String[]{"4-i","2+i4","12","i2"}});

        var res = matrix3.multiplyMatrixByMatrix(matrix4);
        var res2 = res.transposition();
        res2.printMatrix();
    }
}