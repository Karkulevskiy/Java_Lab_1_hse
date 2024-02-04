package ComplexNumberPackage;

public interface IComplexNumber {
    void add(ComplexNumber number);
    ComplexNumber addWithReturn(ComplexNumber number);
    void sub(ComplexNumber number);
    ComplexNumber subWithReturn(ComplexNumber number);
    void multiply(ComplexNumber number);
    ComplexNumber multiplyWithReturn(ComplexNumber number);
    String print();
}
