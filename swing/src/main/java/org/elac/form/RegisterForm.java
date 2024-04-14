package org.elac.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import lombok.extern.slf4j.Slf4j;
import org.elac.entity.UsersEntity;
import org.elac.service.impl.UsersBusServiceImpl;
import org.springframework.stereotype.Component;

@Slf4j
@Component
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
    @Resource
    private UsersBusServiceImpl usersBusService;

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
                UsersEntity user = new UsersEntity();
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setCity(city);
                user.setAddress1(address);
                user.setCellNumber(phone);
                user.setZipCode(Integer.parseInt(zipcode));
                user.setEmail(email);
                user.setUserName(username);
                // save user
                user = usersBusService.saveUser(user);
                JOptionPane.showMessageDialog(RegisterForm.this,
                        "You have successfully registered, password is " + user.getPassword(), "Success",
                        JOptionPane.INFORMATION_MESSAGE);
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
            log.error(e.getMessage());
        }
        return formatter;
    }

    private static boolean isValidEmail(String email) {
        // Simple email validation
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}