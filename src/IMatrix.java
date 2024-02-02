public interface IMatrix {
    void transposition();
    void addWith(Matrix matrix);
    void subtractFrom(Matrix matrix);
    void printMatrix();
    void multiplyMatrixByNumber(ComplexNumber number);
    void multiplyMatrixByMatrix(Matrix matrix);
}
