import java.util.ArrayList;

public class ComplexNumber {
    public int _realNumber;
    public int _imaginaryNumber;
    ComplexNumber(int realNumber, int imaginaryNumber)
    {
        _realNumber = realNumber;
        _imaginaryNumber = imaginaryNumber;
    }
    ComplexNumber(String number)
    {
        if (number.indexOf('i') == -1)
            _realNumber = Integer.parseInt(number);
        else if (number.indexOf('i') == 0 && number.length() == 1)
            _imaginaryNumber = 1;
        else if (number.indexOf('i') == 0 && number.length() != 1)
            _imaginaryNumber = Integer.parseInt(number.substring(1));
        else if (number.indexOf('i') == 1 && number.length() == 2)
            _imaginaryNumber = -1;
        else if (number.indexOf('i') == 1 && number.length() != 2)
            _imaginaryNumber = -Integer.parseInt(number.substring(2));
        else {
            _realNumber = Integer.parseInt(number.substring(0, number.indexOf('i') - 1));
            if (number.indexOf('i') == number.length() - 1)
                _imaginaryNumber = Integer.parseInt(number.substring(number.indexOf('i') - 1, number.indexOf('i')) + 1);
            else _imaginaryNumber = Integer.parseInt(
                    number.substring(number.indexOf('i') - 1, number.indexOf('i')) + number.substring(number.indexOf('i') + 1));
        }
    }
    public void add(ComplexNumber number)
    {
        _realNumber += number._realNumber;
        _imaginaryNumber += number._imaginaryNumber;
    }
    public ComplexNumber addWithReturn(ComplexNumber number)
    {
         return new ComplexNumber(_realNumber + number._realNumber,
                 _imaginaryNumber + number._imaginaryNumber);
    }
    public void sub(ComplexNumber number)
    {
        _realNumber -= number._realNumber;
        _imaginaryNumber -= number._imaginaryNumber;
    }
    public ComplexNumber subWithReturn(ComplexNumber number)
    {
        return new ComplexNumber(_realNumber - number._realNumber,
                _imaginaryNumber - number._imaginaryNumber);
    }
    public void multiply(ComplexNumber number)
    {
        var _tempRealNum = _realNumber;
        _tempRealNum = (_realNumber * number._realNumber) - (_imaginaryNumber * number._imaginaryNumber);
        _imaginaryNumber = (_imaginaryNumber * number._realNumber) + (_realNumber * number._imaginaryNumber);
        _realNumber = _tempRealNum;
    }
    public ComplexNumber multiplyWithReturn(ComplexNumber number){
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
            return Integer.toString(_realNumber);

        if (_realNumber == 0 && _imaginaryNumber > 0)
            return "i" + _imaginaryNumber;
        if (_realNumber == 0)
            return "-i" + Math.abs(_imaginaryNumber);
        if (_imaginaryNumber > 0)
            return Integer.toString(_realNumber) + "+i" + Integer.toString(_imaginaryNumber);
        return Integer.toString(_realNumber) + "-i" + Integer.toString(Math.abs(_imaginaryNumber));
    }
}
