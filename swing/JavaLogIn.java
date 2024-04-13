import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaLogIn extends JFrame{

    private JLabel javaFirstName;
    private JTextField textFirstName;
    private JButton submitButton;
    private JPanel JavaLogInPanel;
    private JLabel javaAddress;
    private JLabel javaCity;
    private JLabel javaPhone;
    private JLabel javaTitle;
    private JFormattedTextField textPhone;
    private JTextField textAddress;
    private JTextField textCity;
    private JTextField textLastName;
    private JLabel javaLastName;
    private JLabel javaZipcode;
    private JTextField textZipcode;
    private JLabel javaUserName;
    private JTextField textUsername;

    public JavaLogIn() {

        setContentPane(JavaLogInPanel);

        setTitle("Java Log-In Project");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800, 800);

        setLocationRelativeTo(null);

        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = textFirstName.getText();
                String lastname = textLastName.getText();
                String address = textAddress.getText();
                String email = textCity.getText();
                String phone = textPhone.getText();
                String zipcode = textZipcode.getText();
                String username = textUsername.getText();
                JOptionPane.showMessageDialog(JavaLogIn.this, "Thank you for your submission!");
            }
        });
    }

    public static void main(String[] args){

        new JavaLogIn();

    }

}