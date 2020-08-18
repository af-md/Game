package strategy;

import java.util.ArrayList;
import java.util.Random;

public abstract class  Operations implements IStrategy {
    protected int randomBound;
    protected Random randomNumberGenerator;
    protected int randomNumber;

    protected ArrayList<Integer> numberList;
    protected String operator;

    public Operations(String operator, int randomBound){
        randomNumberGenerator = new Random();
        numberList = new ArrayList<>();
        this.operator = operator;
        this.randomBound = randomBound;
        createRandomNumber();
    }
    @Override
    public int getRandomNumber() {
        return randomNumber;
    }
    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public double executeOperation(double operand1, double operand2) {
        return 0;
    }

    /**
     * assigns a random number to randomNumber field except 0 with in the bound of 9
     */
    @Override
    public void createRandomNumber() {
        do {
            randomNumber = randomNumberGenerator.nextInt(9);
        }
        while (randomNumber == 0);
    }

    /**
     * adds the number caught by the ship to the arraylist
     * @param number
     */
    @Override
    public void addToNumberList(int number) {
        numberList.add(number);
    }

    @Override
    public ArrayList<Integer> getNumberList() {
        return numberList;
    }

    /**
     * checks whether the randomNumber equals to the number returned by execute operation
     * @return boolean
     */
    @Override
    public boolean checkAnswer()
    {
        boolean result = randomNumber == executeOperation(numberList.get(0), numberList.get(1));
        numberList.clear();
        createRandomNumber();
        return result;
    }

    /**
     * checks if there are enough operands carry out an operation
     * @return boolean
     */
    @Override
    public boolean canCalculateAnswer(){
        if (numberList.size() == 2) return true;
        else return false;
    }
}
