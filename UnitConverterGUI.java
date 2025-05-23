import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverterGUI extends JFrame implements ActionListener {
    JComboBox<String> conversionType;
    JTextField inputField;
    JLabel resultLabel;
    JButton convertButton;

    public UnitConverterGUI() {
        setTitle("Unit Converter");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout(10, 10));

        // Set a panel with padding and GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Conversion Options
        String[] options = {
            "Kilometers to Miles",
            "Celsius to Fahrenheit",
            "Kilograms to Pounds"
        };

        JLabel conversionLabel = new JLabel("Select Conversion:");
        conversionLabel.setFont(labelFont);
        conversionType = new JComboBox<>(options);
        conversionType.setFont(labelFont);
        conversionType.setToolTipText("Choose the type of conversion");

        // Input Field
        JLabel inputLabel = new JLabel("Enter Value:");
        inputLabel.setFont(labelFont);
        inputField = new JTextField(30);
        inputField.setFont(labelFont);
        inputField.setBackground(Color.WHITE);
        inputField.setForeground(Color.BLACK);
        inputField.setToolTipText("Enter the number to convert");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(inputField, gbc);

        // Convert Button
        convertButton = new JButton("Convert");
        convertButton.setFont(buttonFont);
        convertButton.setBackground(new Color(0, 123, 255));
        convertButton.setForeground(new Color(118,55,55));
        convertButton.setFocusPainted(false);
        convertButton.setToolTipText("Click to convert");

        // Result Label
        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setFont(labelFont);
        resultLabel = new JLabel("Result will appear here.");
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resultLabel.setForeground(new Color(0, 102, 51));

        // Adding components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(conversionLabel, gbc);
        gbc.gridx = 1;
        panel.add(conversionType, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(inputLabel, gbc);
        gbc.gridx = 1;
        panel.add(inputField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(convertButton, gbc);

        gbc.gridy = 3;
        panel.add(outputLabel, gbc);
        gbc.gridy = 4;
        panel.add(resultLabel, gbc);

        add(panel, BorderLayout.CENTER);

        convertButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double input = Double.parseDouble(inputField.getText());
            String selected = (String) conversionType.getSelectedItem();
            double result = 0;
            String unit = "";

            if (selected.equals("Kilometers to Miles")) {
                result = input * 0.621371;
                unit = " miles";
            } else if (selected.equals("Celsius to Fahrenheit")) {
                result = (input * 9 / 5) + 32;
                unit = " °F";
            } else if (selected.equals("Kilograms to Pounds")) {
                result = input * 2.20462;
                unit = " lbs";
            }

            resultLabel.setText(String.format("%.2f%s", result, unit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new UnitConverterGUI();
    }
}
