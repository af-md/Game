package strategy;

public class Division extends Operations implements IStrategy{
    public Division(){
        super("/", 10);
    }
    @Override
    public double executeOperation(double operand1, double operand2) {
        return operand1/operand2;
    }
}
