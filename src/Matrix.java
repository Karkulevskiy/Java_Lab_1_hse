public class Matrix implements IMatrix{
    private int _columns;
    private int _rows;
    private ComplexNumber[][] _matrix;
    Matrix(int row, int col, ComplexNumber[][] matrix)
    {
        if (row < 0 || col < 0 || matrix.length * matrix[0].length != row * col)
            throw new IllegalArgumentException();
        _rows = row;
        _columns = col;
        _matrix = matrix;
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
                System.out.print(_matrix[i][j].print() + " ");
            System.out.println();
        }
    }
    public void multiplyMatrixByNumber(ComplexNumber number) {
        for (var i = 0; i < _rows; i++)
            for (var j = 0; j < _columns; j++)
                _matrix[i][j].multiply(number);
    }

    //Переделать класс multiplyMatrix
    //Сделать D
    public void multiplyMatrixByMatrix(Matrix matrix) {
        if (_columns != matrix._rows)
            throw new IllegalArgumentException();
        var multipliedMatrix = new ComplexNumber[_rows][matrix._rows];
        for (var i = 0; i < _rows; i++)
        {
            var indexForSecondMatrix = 0;
            while(indexForSecondMatrix < matrix._columns) {
                var currNumber = new ComplexNumber(0,0);
                for (var j = 0; j < _columns; j++) {
                    var res = _matrix[i][j].multiplyForMatrix(matrix._matrix[j][indexForSecondMatrix]);
                    currNumber.add(res);
                }
                multipliedMatrix[i][indexForSecondMatrix++] = currNumber;
            }
        }
        _matrix = multipliedMatrix;
        var tempCol = _columns;
        _columns = _rows;
        _rows = tempCol;
    }
    public void transposition() {
        var transpositedMatrix = new ComplexNumber[_columns][_rows];
        for (var i = 0; i < _columns; i++)
            for (var j = 0; j < _rows; j++)
                transpositedMatrix[j][i] = _matrix[i][j];
        _matrix = transpositedMatrix;
        var temCol = _columns;
        _columns = _rows;
        _rows = temCol;
    }
    public void addWith(Matrix matrix) {
        if (matrix._rows != _rows || matrix._columns != _columns)
            throw new IllegalArgumentException();
        for (var i = 0; i < _rows; i++)
            for (var j  =0; j < _columns; j++)
                _matrix[i][j].add(matrix._matrix[i][j]);
    }
    public void subtractFrom(Matrix matrix) {
        if (matrix._rows != _rows || matrix._columns != _columns)
            throw new IllegalArgumentException();
        for (var i = 0; i < _rows; i++)
            for (var j  =0; j < _columns; j++)
                _matrix[i][j].sub(matrix._matrix[i][j]);
    }

    public void determinant(){

    }
}
