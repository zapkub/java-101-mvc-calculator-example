package com.company;


public class Main {
    public static void main(String[] args) {


        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view, model);
        view.addEventListener(controller);

        view.renderCalculatorUI();

    }
}
