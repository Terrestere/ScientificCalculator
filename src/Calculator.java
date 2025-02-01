import jdk.jshell.execution.StreamingExecutionControl;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }

    JLabel jLabel;
    JFrame jFrame;
    JTextField jTextField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButton = new JButton[25];
    JButton plusButton, minusButton, mulButton, divButton, delButton, clrButton, powOfButton, factButton, squareButton, tenSqButton, lnButton,
            logButton, moduleButton, expButton, sinButton, cosButton, tanButton, dotButton, plMsButton, leftBracketButton, rgBracketButton, piButton,
            equalButton, percentButton, sqrtButton;
    JPanel jPanel;
    Font myFont = new Font("Calibri", Font.BOLD, 15);
    String text = "0";
    boolean dot = false;

    double operand1 = 0, operand2 = 0, result = 0;
    String operator, prevOperator;

    Calculator() {

        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);


        JPanel jPanelText = new JPanel();
        jPanelText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//        jPanelText.setBackground(SystemColor.inactiveCaptionBorder);
        jPanelText.setBounds(34, 25, 316, 80);
//        jPanelText.setFont(myFont);
        jFrame.getContentPane().add(jPanelText);
        jPanelText.setLayout(null);


        jLabel = new JLabel("");
        jLabel.setBackground(SystemColor.control);
        jLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setForeground(UIManager.getColor("Button.disabledForeground"));
        jLabel.setBounds(2, 2, 312, 27);
        jPanelText.add(jLabel);


        jTextField = new JTextField();
        jLabel.setLabelFor(jTextField);
        jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField.setBackground(SystemColor.control);
        jTextField.setEditable(false);
        jTextField.setText("0");
        jTextField.setBorder(null);
        jTextField.setFont(new Font("Yu Gothic UI Light", jTextField.getFont().getStyle(), 32));
        jTextField.setBounds(2, 30, 312, 49);
        jPanelText.add(jTextField);
        jTextField.setColumns(10);


        plusButton = new JButton("+");
        minusButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        powOfButton = new JButton("x^y");
        factButton = new JButton("n!");
        squareButton = new JButton("^2");
        tenSqButton = new JButton("10^");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        moduleButton = new JButton("|x|");
        expButton = new JButton("exp");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        dotButton = new JButton(",");
        plMsButton = new JButton("+/-");
        leftBracketButton = new JButton("(");
        rgBracketButton = new JButton(")");
        piButton = new JButton("Pi");
        equalButton = new JButton("=");
        percentButton = new JButton("%");
        sqrtButton = new JButton("sqrt");


        functionButton[0] = plusButton;
        functionButton[1] = minusButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = powOfButton;
        functionButton[5] = factButton;
        functionButton[6] = squareButton;
        functionButton[7] = tenSqButton;
        functionButton[8] = lnButton;
        functionButton[9] = logButton;
        functionButton[10] = moduleButton;
        functionButton[11] = expButton;
        functionButton[12] = sinButton;
        functionButton[13] = cosButton;
        functionButton[14] = tanButton;
        functionButton[15] = delButton;
        functionButton[16] = clrButton;
        functionButton[17] = dotButton;
        functionButton[18] = plMsButton;
        functionButton[19] = leftBracketButton;
        functionButton[20] = rgBracketButton;
        functionButton[21] = piButton;
        functionButton[22] = equalButton;
        functionButton[23] = percentButton;
        functionButton[24] = sqrtButton;


        for (int i = 0; i < 25; i++) {
            functionButton[i].addActionListener(this);
//            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
//            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }


        jPanel = new JPanel();
        jPanel.setBounds(34, 125, 316, 300);
        jPanel.setLayout(new GridLayout(7, 5, 2, 2));
        jPanel.setBackground(Color.GRAY);

        jPanel.add(piButton);
        jPanel.add(percentButton);
        jPanel.add(moduleButton);
        jPanel.add(delButton);
        jPanel.add(clrButton);
        jPanel.add(squareButton);
        jPanel.add(expButton);
        jPanel.add(sinButton);
        jPanel.add(cosButton);
        jPanel.add(tanButton);
        jPanel.add(sqrtButton);
        jPanel.add(leftBracketButton);
        jPanel.add(rgBracketButton);
        jPanel.add(factButton);
        jPanel.add(divButton);
        jPanel.add(powOfButton);
        jPanel.add(numberButtons[7]);
        jPanel.add(numberButtons[8]);
        jPanel.add(numberButtons[9]);
        jPanel.add(mulButton);
        jPanel.add(tenSqButton);
        jPanel.add(numberButtons[4]);
        jPanel.add(numberButtons[5]);
        jPanel.add(numberButtons[6]);
        jPanel.add(minusButton);
        jPanel.add(logButton);
        jPanel.add(numberButtons[1]);
        jPanel.add(numberButtons[2]);
        jPanel.add(numberButtons[3]);
        jPanel.add(plusButton);
        jPanel.add(lnButton);
        jPanel.add(plMsButton);
        jPanel.add(numberButtons[0]);
        jPanel.add(dotButton);
        jPanel.add(equalButton);


        jFrame.add(jPanel);
        jFrame.setLayout(new BorderLayout());
        //jFrame.setJMenuBar(menuBar);
        jFrame.setVisible(true);


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        menuBar.add(fileMenu);


    }


    private double function(String button, double operandFunction) {
        double res = 0;
        switch (button) {
/*            case "square":
                res = Math.pow(operandFunction, 2);
                break;*/
            case "10^":
                res = Math.pow(10, operandFunction);
                break;
            case "sqrt":
                res = Math.sqrt(operandFunction);
                break;
            case "ln":
                res = Math.log(operandFunction);
                break;
            case "log":
                res = Math.log10(operandFunction);
                break;

            case "exp":
                res = Math.exp(operandFunction);
                break;
            case "sin":
                res = Math.sin(operandFunction);
                break;
            case "cos":
                res = Math.cos(operandFunction);
                break;
            case "tan":
                res = Math.tan(operandFunction);
                break;
        }
        return res;
    }

    private double function(String button, double operandFunction, double operandFunction2) {
        double res = 0;
        switch (button) {
            case "+":
                res = operandFunction + operandFunction2;
                break;
            case "-":
                res = operandFunction - operandFunction2;
                break;
            case "*":
                res = operandFunction * operandFunction2;
                break;
            case "/":
                res = operandFunction / operandFunction2;
                break;
        }

        return res;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i] && jTextField.getText().equals("0")) {
                jTextField.setText("");
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            } else if (e.getSource() == numberButtons[i]) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            }
        }

        if (!dot && e.getSource() == dotButton && e.getSource().equals("0")) {
            jTextField.setText(jTextField.getText().concat("."));
            dot = true;
        } else if (!dot && e.getSource() == dotButton) {
            jTextField.setText(jTextField.getText().concat("."));
            dot = true;
        }

        if (e.getSource() == clrButton) {
            jLabel.setText("");
            jTextField.setText("0");
            result = 0;
            operand1 = 0;
            dot = false;
            prevOperator = null;
            operator = null;
        }

        if (e.getSource() == delButton) {
            String text = jTextField.getText();
            jTextField.setText("");
            if (text.length() == 1) {
                jTextField.setText("0");
                return;
            }
            for (int i = 0; i < text.length() - 1; i++) {
                jTextField.setText(jTextField.getText() + text.charAt(i));
                if (text.charAt(i) == '.') {
                    dot = false;
                }
            }
        }

        if (e.getSource() == piButton) {
            jTextField.setText(String.valueOf(Math.PI));
        }


        if (e.getSource() == plMsButton) {
            jTextField.setText(String.valueOf(Double.parseDouble(jTextField.getText()) * -1));
        }


        if (e.getSource() == squareButton) {
            jLabel.setText("square of " + jTextField.getText());
            jTextField.setText(String.valueOf(Math.pow(Double.parseDouble(jTextField.getText()), 2)));
        }

        if (e.getSource() == factButton) {
            int res = 1;
            for (int i = 1; i <= Integer.parseInt(jTextField.getText()); i++) {
                res = res * i;
            }
            jLabel.setText(jTextField.getText() + "!");
            jTextField.setText(String.valueOf(res));
        }

        if (e.getSource() == sqrtButton || e.getSource() == expButton || e.getSource() == logButton || e.getSource() == lnButton || e.getSource() == tenSqButton) {
            System.out.println(e.getActionCommand());
            jLabel.setText(e.getActionCommand() + "(" + jTextField.getText() + ")");
            jTextField.setText(String.valueOf(function(e.getActionCommand(), Double.parseDouble(jTextField.getText()))));
        }

        if (e.getSource() == cosButton || e.getSource() == sinButton || e.getSource() == tanButton) {
            jLabel.setText(e.getActionCommand() + "(" + jTextField.getText() + ")");
            jTextField.setText(String.valueOf(function(e.getActionCommand(), Math.toRadians(Double.parseDouble(jTextField.getText())))));
        }

        if (e.getSource() == equalButton) {
            if (!jTextField.getText().equals("0")) {
                operand1 = Double.parseDouble(jTextField.getText());
            }
            result = function(operator, result, operand1);
            text += operator + operand1;
            jLabel.setText(text + "=" + result);
            jTextField.setText("0");
        }

        if (e.getSource() == plusButton || e.getSource() == minusButton) {
            prevOperator = operator;
            operator = e.getActionCommand();
            if (jTextField.getText().equals("0")) {
/*                operator = null;
                prevOperator = null;*/
                return;
            } else if (result != 0 && prevOperator != null && !jTextField.getText().equals("0")) {
                operand1 = Double.parseDouble(jTextField.getText());
                result = function(prevOperator, result, operand1);
                text += prevOperator + jTextField.getText();
                jLabel.setText(text + "=" + result);
                jTextField.setText("0");
            } else {
                result = Double.parseDouble(jTextField.getText());
                text = jTextField.getText();
                jLabel.setText(jTextField.getText() + operator);
                jTextField.setText("0");
            }
        }

        if (e.getSource() == mulButton || e.getSource() == divButton) {
            prevOperator = operator;
            operator = e.getActionCommand();
            if (result != 0 && prevOperator != null && !jTextField.getText().equals("0")) {
                operand1 = Double.parseDouble(jTextField.getText());
                result = function(prevOperator, result, operand1);
                text += prevOperator + jTextField.getText();
                jLabel.setText(text + "=" + result);
                jTextField.setText("0");

            } else if (jTextField.getText().equals("0")) {
                return;
            } else {
                result = Double.parseDouble(jTextField.getText());
                text = jTextField.getText();
                jLabel.setText(jTextField.getText() + operator);
                jTextField.setText("0");
            }
        }


    }
/*        if (e.getSource() == moduleButton) {
            jTextField.setText(String.valueOf(Math.abs(Double.parseDouble(jTextField.getText()))));
        }*/


}
