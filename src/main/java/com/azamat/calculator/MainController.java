package com.azamat.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clear_btn;

    @FXML
    private Button comma_btn;

    @FXML
    private Button delenie_btn;

    @FXML
    private Button equal_btn;

    @FXML
    private Label labelres;

    @FXML
    private Button minus_btn;

    @FXML
    private Button mult_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button pls_btn;

    @FXML
    private Button plusminus_btn;

    String labeltext = "";
    float first_num = 0f;

    char operation = '0';

    @FXML
    void addNumber(ActionEvent event) {
        labeltext += ((Button) event.getSource()).getText();
        labelres.setText(labeltext);
    }

    @FXML
    void initialize() {
        pls_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        delenie_btn.setOnAction(event -> {
            mathAction('/');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });

        equal_btn.setOnAction(event -> {
            if(operation == '+' || operation == '-' || operation == '*' || operation == '/')
            equalButton();
        });
        comma_btn.setOnAction(actionEvent -> {
            if(!labeltext.contains(".")) {
                labeltext += ".";
                labelres.setText(labeltext);
            }
        });

        percent_btn.setOnAction(actionEvent -> {
            if(!labeltext.equals("")){
                float num = Float.parseFloat(labeltext) * 0.1f;
                labeltext = Float.toString(num);
                labelres.setText(labeltext);
            }
        });
        plusminus_btn.setOnAction(event -> {
            if(!labeltext.equals("")){
                float num = Float.parseFloat(labeltext) * -1f;
                labeltext = Float.toString(num);
                labelres.setText(labeltext);
            }
        });

        clear_btn.setOnAction(event -> {
            labelres.setText("0");
            labeltext = " ";
            operation = '0';
            first_num = 0f;
        });
    }

    private void equalButton() {
        float res = 0f;
        switch (operation){
            case '+' :
                res = first_num + Float.parseFloat(labeltext);
                break;
            case '-' :
                res = first_num - Float.parseFloat(labeltext);
                break;
            case '*' :
                res = first_num * Float.parseFloat(labeltext);
                break;
            case '/' :
                float second_num = Float.parseFloat(labeltext);
                if(second_num == 0)
                    res = 0;
                else
                res = first_num / Float.parseFloat(labeltext);
                break;
        }

        labelres.setText(Float.toString(res));
        labeltext = "";
        operation = '0';
        first_num = 0f;

    }

    private void mathAction(char action) {
        if(operation != '+' && operation != '-' &&
                operation != '/' && operation != '*') {
            first_num = Float.parseFloat(labeltext);
            labelres.setText(String.valueOf(action));
            labeltext = "";
            operation = action;
        }
    }

}

