package com.uecpe20231122784.macprob8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p1_RomyAutomotiveGUI extends JFrame implements ActionListener {
    private JCheckBox oilChangeCheckBox, radiatorFlushCheckBox, atfFlushCheckBox, inspectionCheckBox, brakeReplacementCheckBox, tireRotationCheckBox;
    private JTextField laborHoursTextField;
    private JButton calculateButton;
    private JTextArea resultTextArea;

    private static final double OIL_CHANGE_COST = 3120.00;
    private static final double RADIATOR_FLUSH_COST = 500.00;
    private static final double ATF_FLUSH_COST = 2850.00;
    private static final double INSPECTION_COST = 150.00;
    private static final double BRAKE_REPLACEMENT_COST = 3340.00;
    private static final double TIRE_ROTATION_COST = 200.00;
    private static final double LABOR_RATE = 300.00;

    public p1_RomyAutomotiveGUI() {
        super("Romy's Automotive");

        oilChangeCheckBox = new JCheckBox("Oil Change");
        radiatorFlushCheckBox = new JCheckBox("Radiator Flush");
        atfFlushCheckBox = new JCheckBox("ATF Flush");
        inspectionCheckBox = new JCheckBox("Inspection");
        brakeReplacementCheckBox = new JCheckBox("Brake Replacement");
        tireRotationCheckBox = new JCheckBox("Tire Rotation");
        laborHoursTextField = new JTextField("0", 10);
        calculateButton = new JButton("Calculate Total");
        resultTextArea = new JTextArea(5, 25);
        resultTextArea.setEditable(false);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(inputPanel, BoxLayout.Y_AXIS);
        inputPanel.setLayout(boxLayout);

        inputPanel.add(new JLabel("Select Services:"));
        inputPanel.add(oilChangeCheckBox);
        inputPanel.add(radiatorFlushCheckBox);
        inputPanel.add(atfFlushCheckBox);
        inputPanel.add(inspectionCheckBox);
        inputPanel.add(brakeReplacementCheckBox);
        inputPanel.add(tireRotationCheckBox);
        inputPanel.add(new JLabel("Non-routine Labor Hours:"));
        inputPanel.add(laborHoursTextField);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double totalCost = 0;
        int laborHours = 0;

        try {
            laborHours = Integer.parseInt(laborHoursTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for labor hours.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (oilChangeCheckBox.isSelected()) totalCost += OIL_CHANGE_COST;
        if (radiatorFlushCheckBox.isSelected()) totalCost += RADIATOR_FLUSH_COST;
        if (atfFlushCheckBox.isSelected()) totalCost += ATF_FLUSH_COST;
        if (inspectionCheckBox.isSelected()) totalCost += INSPECTION_COST;
        if (brakeReplacementCheckBox.isSelected()) totalCost += BRAKE_REPLACEMENT_COST;
        if (tireRotationCheckBox.isSelected()) totalCost += TIRE_ROTATION_COST;

        totalCost += laborHours * LABOR_RATE;

        resultTextArea.setText("\nTotal Cost: P" + totalCost);
    }

    public static void main(String[] args) {
        p1_RomyAutomotiveGUI gui = new p1_RomyAutomotiveGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}


