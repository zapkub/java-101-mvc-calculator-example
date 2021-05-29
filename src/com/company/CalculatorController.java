package com.company;


interface CalculationResultDisplay {
    void setResult(int result);
}
interface CalculationResultStore {
    void setResult(int result);
    int getResult();

    void setTotal(int total);
    int getTotal();

    void setOperator(CalculatorOperatorEnum input);
    CalculatorOperatorEnum getOperator();
}

public class CalculatorController implements CalculatorInputEventSourceHandler {

    private CalculationResultDisplay view;
    private CalculationResultStore model;

    CalculatorController(
            CalculationResultDisplay view,
            CalculationResultStore model
    ) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onNumberInputEvent(int input) {
        System.out.println("[Controller] receive double input " + input);
        if (this.model.getOperator() != null) {
            this.model.setOperator(null);
            this.model.setResult(0);
        }
        this.model.setResult(Integer.parseInt(this.model.getResult() + "" + input));
        this.view.setResult(this.model.getResult());
    }

    @Override
    public void onOperatorInputEvent(CalculatorOperatorEnum input) {
        System.out.println("[Controller] receive operator " + input);
        this.model.setOperator(input);
        switch (input) {
            case PLUS: {
                this.model.setTotal(this.model.getTotal() + this.model.getResult());
                break;
            }
            case MINUS: {
                break;
            }

        }
    }
}
