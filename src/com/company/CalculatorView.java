package com.company;

import javax.swing.*;

interface CalculatorInputEventSourceHandler {
    void onNumberInputEvent(int input);
    void onOperatorInputEvent(CalculatorOperatorEnum input);
}

public class CalculatorView implements CalculationResultDisplay {

    private static String[] numberButtonLabels = { "0","1","2","3","4","5","6","7","8","9" };
    private static String[] operatorButtonLabels = { "+", "-" };

    private JFrame frameWindow;
    private JPanel mainPanel;
    private JTextField resultTextField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;

    CalculatorView() {
        frameWindow = new JFrame();
        mainPanel = new JPanel();
        frameWindow.setSize(640, 800);
    }

    private void numberButtonActionListener(String numberLabel) {
        System.out.println("[View] user click on button " + numberLabel);
        if (this.currentHandler != null) {
           this.currentHandler.onNumberInputEvent(Integer.parseInt(numberLabel));
        }
    }
    private void renderNumberButtons() {
        this.numberButtons = new JButton[CalculatorView.numberButtonLabels.length];
        int index = 0;
        for(String numberButtonLabel : CalculatorView.numberButtonLabels ){

            JButton numberButton = new JButton(numberButtonLabel);
            this.mainPanel.add(numberButton);
            numberButton.addActionListener(e -> {
                this.numberButtonActionListener(numberButtonLabel);
            });
            this.numberButtons[index] = numberButton;
            index ++;
        }
    }

    private void renderResultTextField() {
        resultTextField = new JTextField(50);
        resultTextField.setEditable(false);
        this.mainPanel.add(resultTextField);
    }

    private void renderOperatorButtons() {
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(e -> {
            System.out.println("[view] user click plus button");
            this.currentHandler.onOperatorInputEvent(CalculatorOperatorEnum.PLUS);
        });
        this.mainPanel.add(plusButton);
    }

    public void renderCalculatorUI() {
        this.renderResultTextField();
        this.renderNumberButtons();
        this.renderOperatorButtons();

        this.frameWindow.add(this.mainPanel);
        this.frameWindow.setVisible(true);
    }

    @Override
    public void setResult(int result) {
        this.resultTextField.setText(result + "");
    }

    private CalculatorInputEventSourceHandler currentHandler;
    public void addEventListener(CalculatorInputEventSourceHandler handler) {
        this.currentHandler = handler;
    }
}
