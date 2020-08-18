package strategy;

public class Multiplication extends Operations implements IStrategy  {

    public Multiplication(){
        super("x", 10);
    }

    @Override
    public double executeOperation(double operand1, double operand2) {
        return operand1 * operand2;
    }

}
