package org.elac.form;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import org.springframework.beans.factory.annotation.Autowired;
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
                StringBuilder sb = new StringBuilder();
                sb.append("First Name:").append(firstname).append("\n");
                sb.append("Last Name:").append(lastname).append("\n");
                sb.append("Cell:").append(phone).append("\n");
                sb.append("Address:").append(address).append("\n");
                sb.append("City:").append(city).append("\n");
                sb.append("Zip code:").append(zipcode).append("\n");
                sb.append("End-user name:").append(username).append("\n");
                sb.append("Password:").append(user.getPassword()).append("\n");
                String body = sb.toString();
                sendEmail(email, body);
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


    private void sendEmail(String toEmail, String body) {
        String from = "test@signority.net";
        String subject = "Your Registration Information In ELAC";
        String host = "smtp.qiye.aliyun.com";
        final String username = "test@signority.net";
        final String password = "P@ssw0rd";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            Desktop.getDesktop().mail();
        } catch (MessagingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}