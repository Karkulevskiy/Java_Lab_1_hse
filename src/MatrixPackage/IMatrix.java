package MatrixPackage;

import ComplexNumberPackage.ComplexNumber;

public interface IMatrix {
    Matrix transposition();
    Matrix addMatrix(Matrix matrix);
    Matrix subtractMatrix(Matrix matrix);
    void printMatrix();
    Matrix multiplyMatrixByNumber(ComplexNumber number);
    Matrix multiplyMatrixByMatrix(Matrix matrix);
}
