package strategy;

public class Division implements IStrategy{
    @Override
    public int executeOperation(int operand1, int operand2) {
        return operand1/operand2;
    }
}
