package com.example.loan_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoanCalculatorController {
    @FXML
    private TextField interestRate_textField;

    @FXML
    private TextField years_textField;

    @FXML
    private TextField amount_textField;

    @FXML
    private TextField monthlyPayment_textField;

    @FXML
    private TextField totalPayment_textField;

    @FXML
    private Button calculator_button;

    /*
    when user clicks on button calculator_button:
    user input from TetField instances will be converted to doubles and assigned to double variables interest, years, amount
    the variables will then be used to calculate monthlyPayment and totalPayment
    TextFields totalPayment_textField and monthlyPayment_textField will set text as the values of monthlyPayment and totalPayment
     */
    @FXML
    protected void onCalculatorButtonClicked() {
        double interest = (Double.parseDouble(interestRate_textField.getText()))/100;
        double years = Double.parseDouble(years_textField.getText());
        double amount = Double.parseDouble(amount_textField.getText());
        double monthlyPayment = (amount * (interest/12))/(1-Math.pow(1+(interest/12),-12*years));
        double totalPayment = monthlyPayment * 12 * years;
        totalPayment_textField.setText(String.format("%.2f", totalPayment));
        monthlyPayment_textField.setText(String.format("%.2f", monthlyPayment));
    };

}