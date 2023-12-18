package com.uecpe20231122784.macprob8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p3_PropertyTaxCalculator extends JFrame implements ActionListener {
    private JTextField actualValueTextField;
    private JButton calculateButton;
    private JTextField assessmentValueTextField, propertyTaxTextField;

    private static final double ASSESSMENT_PERCENTAGE = 0.15;
    private static final double TAX_RATE = 0.35 / 100;

    public p3_PropertyTaxCalculator() {
        super("Property Tax Calculator");

        setPreferredSize(new Dimension(300, 200));

        actualValueTextField = new JTextField(10);
        calculateButton = new JButton("Calculate Taxes");
        assessmentValueTextField = new JTextField(10);
        propertyTaxTextField = new JTextField(10);

        assessmentValueTextField.setEditable(false);
        propertyTaxTextField.setEditable(false);

        JPanel outputPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(outputPanel, BoxLayout.Y_AXIS);
        outputPanel.setLayout(boxLayout);
        outputPanel.add(new JLabel("Assessment Value:"));
        outputPanel.add(assessmentValueTextField);
        outputPanel.add(new JLabel("Property Tax:"));
        outputPanel.add(propertyTaxTextField);

        setLayout(new FlowLayout());
        
        add(new JLabel("Actual Value:"));
        add(actualValueTextField);
        add(calculateButton);
        add(outputPanel, BorderLayout.CENTER);

        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double actualValue = Double.parseDouble(actualValueTextField.getText());
        double assessmentValue = actualValue * ASSESSMENT_PERCENTAGE;
        double propertyTax = assessmentValue * TAX_RATE;

        assessmentValueTextField.setText(String.format("P%.2f", assessmentValue));
        propertyTaxTextField.setText(String.format("P%.2f", propertyTax));
    }

    public static void main(String[] args) {
        p3_PropertyTaxCalculator gui = new p3_PropertyTaxCalculator();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}
