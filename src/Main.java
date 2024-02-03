//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        var matrix3 = new Matrix(2,3, new String[][]{
                new String[]{"-i","i5","i"},
                new String[]{"4-i","2+i4","12"}});
        var matrix4 = new Matrix(3,4, new String[][]{
                new String[]{"-i","i5","i","-i"},
                new String[]{"4-i","2+i4","12","i2"},
                new String[]{"i","i2","-3-i5","4+i3"}});
        var res = matrix1.addMatrix(matrix2);
        res.printMatrix();
    }
}