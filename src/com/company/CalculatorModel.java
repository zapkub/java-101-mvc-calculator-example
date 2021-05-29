package com.company;

enum CalculatorOperatorEnum {
    PLUS, MINUS,
}
public class CalculatorModel implements CalculationResultStore {
    private int total = 0;
    private int result = 0;
    private CalculatorOperatorEnum operator;


    @Override
    public void setResult(int result) {
        System.out.println("[model] result set " + result);
        this.result = result;
    }

    @Override
    public int getResult() {
        System.out.println("[model] result get " + this.result);
        return this.result;
    }

    @Override
    public void setTotal(int total) {
        System.out.println("[model] total set " + total);
        this.total = total;
    }

    @Override
    public int getTotal() {
        System.out.println("[model] total get " + total);
        return this.total;
    }

    @Override
    public void setOperator(CalculatorOperatorEnum input) {
        this.operator = input;
    }

    @Override
    public CalculatorOperatorEnum getOperator() {
        return this.operator;
    }

}
