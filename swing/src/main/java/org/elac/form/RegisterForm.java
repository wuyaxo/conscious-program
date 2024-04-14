package org.elac.form;

import java.awt.Color;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;

public class RegisterForm extends JFrame {

    private JPanel logInPanel;
    private JButton submitButton;
    private JLabel javaTitle;
    private JTextField textFirstName;
    private JLabel javaAddress;
    private JLabel javaPhone;
    private JFormattedTextField textPhone;
    private JTextField textAddress;
    private JLabel javaFirstName;
    private JLabel javaLastName;
    private JTextField textLastName;
    private JLabel javaCity;
    private JTextField textCity;
    private JLabel javaZipcode;
    private JTextField textZipcode;
    private JLabel javaUserName;
    private JTextField textUsername;
    private JLabel email;
    private JFormattedTextField textEmail;

    public RegisterForm() {

        setContentPane(logInPanel);
        setTitle("Java Log-In Project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        NumberFormat.getInstance();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = textFirstName.getText();
                String lastname = textLastName.getText();
                String address = textAddress.getText();
                String city = textCity.getText();
                String phone = textPhone.getText();
                String zipcode = textZipcode.getText();
                String username = textUsername.getText();
                String email = textEmail.getText();
                // check email format
                if (!isValidEmail(email)) {
                    textEmail.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(RegisterForm.this, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(RegisterForm.this, "Thank you for your submission!");
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static MaskFormatter createFormatter(String regex) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(regex);
            formatter.setAllowsInvalid(false);
            formatter.setCommitsOnValidEdit(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

    private static boolean isValidEmail(String email) {
        // Simple email validation
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}