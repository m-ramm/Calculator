package calculator.operations;

public class Root implements Operation {
    private final String symbol = "ROOT";

    public double execute(double n1, double n2){
        return Math.pow(n1,1/n2);
    }
    public String getSymbol(){
        return this.symbol;
    }
}
