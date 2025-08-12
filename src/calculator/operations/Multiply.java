package calculator.operations;

public class Multiply implements Operation {
    private final String symbol = "x";

    public double execute(double n1, double n2){
        return n1*n2;
    }
    public String getSymbol(){
        return this.symbol;
    }
}
