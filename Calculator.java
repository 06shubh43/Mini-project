import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApplet extends Applet implements ActionListener {
    TextField num1, num2, result;
    Button add, sub, mul, div;

    public void init() {
        Label l1 = new Label("Number 1:");
        Label l2 = new Label("Number 2:");
        Label l3 = new Label("Result:");

        num1 = new TextField(10);
        num2 = new TextField(10);
        result = new TextField(15);
        result.setEditable(false);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(l1); add(num1);
        add(l2); add(num2);

        add(add); add(sub); add(mul); add(div);

        add(l3); add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        double res = 0;

        if (e.getSource() == add) {
            res = a + b;
        } else if (e.getSource() == sub) {
            res = a - b;
        } else if (e.getSource() == mul) {
            res = a * b;
        } else if (e.getSource() == div) {
            if (b != 0)
                res = a / b;
            else {
                result.setText("Cannot divide by zero");
                return;
            }
        }
        result.setText(String.valueOf(res));
    }
}