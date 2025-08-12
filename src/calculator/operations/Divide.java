package calculator.operations;

public class Divide implements Operation {
    private final String symbol = "/";

    public double execute(double n1, double n2){
        return n1/n2;
    }
    public String getSymbol(){
        return this.symbol;
    }
}
