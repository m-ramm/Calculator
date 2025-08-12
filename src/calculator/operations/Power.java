package calculator.operations;

public class Power implements Operation {
    private final String symbol = "POW";

    public double execute(double n1, double n2){
        return Math.pow(n1,n2);
    }
    public String getSymbol(){
        return this.symbol;
    }
}
