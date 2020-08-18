package strategy;

public class Addition extends Operations  {
    public Addition(){
        super("+", 19);
    }

    @Override
    public double executeOperation(double operand1, double operand2) {
        return operand1 + operand2;
    }
}
