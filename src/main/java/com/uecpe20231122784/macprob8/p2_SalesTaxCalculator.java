package com.uecpe20231122784.macprob8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p2_SalesTaxCalculator extends JFrame implements ActionListener {
    private JTextField totalSalesTextField;
    private JButton calculateButton;
    private JTextField salesTaxTextField, valueAddTaxTextField, totalTaxTextField;

    private static final double SALES_TAX_RATE = 0.07;
    private static final double VALUE_ADD_TAX_RATE = 0.05;

    public p2_SalesTaxCalculator() {
        super("Sales Tax Calculator");

        totalSalesTextField = new JTextField(10);
        calculateButton = new JButton("Calculate Taxes");
        salesTaxTextField = new JTextField(10);
        valueAddTaxTextField = new JTextField(10);
        totalTaxTextField = new JTextField(10);

        JPanel salesTaxPanel = new JPanel();
        salesTaxPanel.add(new JLabel("Sales Tax:"));
        salesTaxPanel.add(salesTaxTextField);

        JPanel valueAddTaxPanel = new JPanel();
        valueAddTaxPanel.add(new JLabel("Value-Add Tax:"));
        valueAddTaxPanel.add(valueAddTaxTextField);

        JPanel totalTaxPanel = new JPanel();
        totalTaxPanel.add(new JLabel("Total Tax:"));
        totalTaxPanel.add(totalTaxTextField);

        salesTaxTextField.setEditable(false);
        valueAddTaxTextField.setEditable(false);
        totalTaxTextField.setEditable(false);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Total Sales:"));
        inputPanel.add(totalSalesTextField);
        inputPanel.add(calculateButton);

        JPanel outputPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(outputPanel, BoxLayout.Y_AXIS);
        outputPanel.setLayout(boxLayout);

        outputPanel.add(new JLabel("Sales Tax:"));
        outputPanel.add(salesTaxPanel);
        outputPanel.add(new JLabel("Value-Add Tax:"));
        outputPanel.add(valueAddTaxPanel);
        outputPanel.add(new JLabel("Total Tax:"));
        outputPanel.add(totalTaxPanel);

        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);

        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double totalSales = Double.parseDouble(totalSalesTextField.getText());
        double salesTax = totalSales * SALES_TAX_RATE;
        double valueAddTax = totalSales * VALUE_ADD_TAX_RATE;
        double totalTax = salesTax + valueAddTax;

        salesTaxTextField.setText(String.format("%.2f", salesTax));
        valueAddTaxTextField.setText(String.format("%.2f", valueAddTax));
        totalTaxTextField.setText(String.format("%.2f", totalTax));
    }

    public static void main(String[] args) {
        p2_SalesTaxCalculator gui = new p2_SalesTaxCalculator();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}
