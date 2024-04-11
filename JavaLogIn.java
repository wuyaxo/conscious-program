import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaLogIn extends JFrame{

    private JLabel javaFullName;
    private JTextField textFullName;
    private JButton submitButton;
    private JPanel JavaLogInPanel;
    private JLabel javaAddress;
    private JLabel javaEmail;
    private JLabel javaPhone;
    private JLabel javaTitle;
    private JFormattedTextField textPhone;
    private JTextField textAddress;
    private JTextField textEmail;

    public JavaLogIn() {

        setContentPane(JavaLogInPanel);

        setTitle("Java Log-In Project");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(500, 500);

        setLocationRelativeTo(null);

        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = textFullName.getText();
                String address = textAddress.getText();
                String email = textEmail.getText();
                String phone = textPhone.getText();
                JOptionPane.showMessageDialog(JavaLogIn.this, "Thank you for your submission!");
            }
        });
    }

    public static void main(String[] args){

        new JavaLogIn();

    }

}