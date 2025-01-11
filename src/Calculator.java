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
            logButton, moduleButton, expButton, sinButton, cosButton, tanButton, commaButton, plMsButton, leftBracketButton, rgBracketButton, piButton,
            equalButton, percentButton, sqrtButton;
    JPanel jPanel;

    Font myFont = new Font("Calibri", Font.BOLD, 15);

    double operand1 = 0, operand2 = 0, result = 0;
    char operator;

    Calculator() {

        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);


        JPanel jPanelText = new JPanel();
        jPanelText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jPanelText.setBounds(34, 25, 316, 80);
        jPanelText.setFont(myFont);
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
        commaButton = new JButton(",");
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
        functionButton[17] = commaButton;
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
        jPanel.add(commaButton);
        jPanel.add(equalButton);


        jFrame.add(jPanel);
        jFrame.setLayout(new BorderLayout());
        //jFrame.setJMenuBar(menuBar);
        jFrame.setVisible(true);


/*

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        menuBar.add(fileMenu);
*/


    }


    private double function(String button, double operand1) {
        double res = 0;
        switch (button) {
            case "n!":
                int result = 1;
                for (int i = 0; i < operand1; i++) {
                    result = result + i;
                }
                res = result;
                break;

            case "square":
                res = Math.pow(operand1, 2);
                break;
            case "pow10":
                res = Math.pow(10, operand1);
                break;
            case "sqrt":
                res = Math.sqrt(operand1);
                break;
            case "lg":
                res = Math.log(operand1);
                break;
            case "log":
                res = Math.log10(operand1);
                break;
            case "module":
                res = Math.abs(operand1);
                break;
            case "exp":
                res = Math.exp(operand1);
                break;
            case "sin":
                res = Math.sin(operand1);
                break;
            case "cos":
                res = Math.cos(operand1);
                break;
            case "tan":
                res = Math.tan(operand1);
                break;
            case "Pi":
                res = Math.PI;
        }
        return res;
    }

    private double function(String button, double operand1, double operand2) {
        double res = 0;
        switch (button) {
            case "+":
                res = operand1 + operand2;
                break;
            case "-":
                res = operand1 - operand2;
                break;
            case "x":
                res = operand1 * operand2;
                break;
            case "/":
                res = operand1 / operand2;
                break;
            case "powOf":
                res = Math.pow(operand1, operand2);
                break;
        }

        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
//                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));


            }
        }
    }
}