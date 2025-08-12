package calculator.operations;

public interface Operation {
    double execute(double n1, double n2);
    String getSymbol();
}
