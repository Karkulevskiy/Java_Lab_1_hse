package MatrixPackage;

import ComplexNumberPackage.ComplexNumber;

public final class Matrix implements IMatrix {
    private int _columns;
    private int _rows;
    private ComplexNumber[][] _matrix;
    public Matrix(int rows, int cols, String[][] matrix)
    {
        if (rows < 0 || cols < 0 || matrix.length * matrix[0].length != rows * cols)
            throw new IllegalArgumentException();
        _rows = rows;
        _columns = cols;
        _matrix = new ComplexNumber[_rows][_columns];
        for (var i = 0; i < _rows; i++)
            for (var j = 0; j < _columns; j++)
                _matrix[i][j] = new ComplexNumber(matrix[i][j]);
    }
    public Matrix(int rows, int cols)
    {
        if (rows < 0 || cols < 0)
            throw new IllegalArgumentException();
        _columns = cols;
        _rows = rows;
        _matrix = new ComplexNumber[rows][cols];
    }
    public int getNumberOfRows(){
        return _rows;
    }
    public int getNumberOfColumns(){
        return _columns;
    }
    public void printMatrix(){
        for (var i = 0; i < _rows; i++)
        {
            for (var j = 0; j < _columns; j++)
                System.out.printf("%-10s", _matrix[i][j].print());
            System.out.println();
        }
        System.out.println();
    }
    public Matrix multiplyMatrixByNumber(ComplexNumber number) {
        var newMatrix = new Matrix(_rows, _columns);
        for (var i = 0; i < _rows; i++)
            for (var j = 0; j < _columns; j++)
                newMatrix._matrix[i][j] = _matrix[i][j].multiplyWithReturn(number);
        return newMatrix;
    }
    public Matrix multiplyMatrixByMatrix(Matrix matrix) {
        if (_columns != matrix._rows)
            throw new IllegalArgumentException();
        var multipliedMatrix = new Matrix(_rows, matrix._columns);
        for (var i = 0; i < _rows; i++)
        {
            var indexForSecondMatrix = 0;
            while(indexForSecondMatrix < matrix._columns) {
                var currNumber = new ComplexNumber(0,0);
                for (var j = 0; j < _columns; j++) {
                    var res = _matrix[i][j].multiplyWithReturn(matrix._matrix[j][indexForSecondMatrix]);
                    currNumber.add(res);
                }
                multipliedMatrix._matrix[i][indexForSecondMatrix++] = currNumber;
            }
        }
        return multipliedMatrix;
    }
    public Matrix transposition() {
        var transpositedMatrix = new Matrix(_columns, _rows);
        for (var i = 0; i < _rows; i++)
            for (var j = 0; j < _columns; j++)
                transpositedMatrix._matrix[j][i] = _matrix[i][j];
        return transpositedMatrix;
    }
    public Matrix addMatrix(Matrix matrix) {
        if (matrix._rows != _rows || matrix._columns != _columns)
            throw new IllegalArgumentException();
        var newMatrix = new Matrix(_rows, _columns);
        for (var i = 0; i < _rows; i++)
            for (var j  =0; j < _columns; j++)
                newMatrix._matrix[i][j] = _matrix[i][j].addWithReturn(matrix._matrix[i][j]);
                //_matrix[i][j].add(matrix._matrix[i][j]);
        return newMatrix;
    }
    public Matrix subtractMatrix(Matrix matrix) {
        if (matrix._rows != _rows || matrix._columns != _columns)
            throw new IllegalArgumentException();
        var newMatrix = new Matrix(_rows, _columns);
        for (var i = 0; i < _rows; i++)
            for (var j  =0; j < _columns; j++)
                newMatrix._matrix[i][j] = _matrix[i][j].subWithReturn(matrix._matrix[i][j]);
                //_matrix[i][j].sub(matrix._matrix[i][j]);
        return newMatrix;
    }

}
