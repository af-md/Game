package strategy;

public class Division extends Operations {
    public Division(){
        super("/", 10);
    }
    @Override
    public double executeOperation(double operand1, double operand2) {
        return operand1/operand2;
    }
}
