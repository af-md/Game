package strategy;

import java.util.ArrayList;

/**
 * the interface will enable to us to pass any strategy to the consumer
 */
public interface IStrategy {
    int getRandomNumber();
    String getOperator();
    double executeOperation(double operand1, double operand2);
    void createRandomNumber();
    void addToNumberList(int number);

    ArrayList<Integer> getNumberList();

    boolean checkAnswer();

    boolean canCalculateAnswer();
}
