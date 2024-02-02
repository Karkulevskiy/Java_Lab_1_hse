public class ComplexNumber {
    public int _realNumber;
    public int _imaginaryNumber;
    ComplexNumber(int realNumber, int imaginaryNumber)
    {
        _realNumber = realNumber;
        _imaginaryNumber = imaginaryNumber;
    }
    public void add(ComplexNumber number)
    {
        _realNumber += number._realNumber;
        _imaginaryNumber += number._imaginaryNumber;
    }
    public void sub(ComplexNumber number)
    {
        _realNumber -= number._realNumber;
        _imaginaryNumber -= number._imaginaryNumber;
    }
    public void multiply(ComplexNumber number)
    {
        _realNumber = (_realNumber * number._realNumber) - (_imaginaryNumber * number._imaginaryNumber);
        _imaginaryNumber = (_imaginaryNumber * number._realNumber) + (_realNumber * number._imaginaryNumber);
    }
    public ComplexNumber multiplyForMatrix(ComplexNumber number){
        var num = new ComplexNumber(0,0);
        num._realNumber = (_realNumber * number._realNumber) - (_imaginaryNumber * number._imaginaryNumber);
        num._imaginaryNumber = (_imaginaryNumber * number._realNumber) + (_realNumber * number._imaginaryNumber);
        return num;
    }
    public String print()
    {
        if (_imaginaryNumber == 0 && _realNumber == 0)
            return "0";
        if (_imaginaryNumber == 0)
            return "i" + _realNumber;
        if (_realNumber == 0)
            return Integer.toString(_realNumber);
        return Integer.toString(_realNumber) + Integer.toString(_imaginaryNumber);
    }
}
