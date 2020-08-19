package strategy;

public class Subtraction extends Operations {
    public Subtraction(){
        super("-", 9);
    }
    @Override
    public double executeOperation(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
