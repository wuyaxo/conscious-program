package org.elac.form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-05 22:28
 */
public class RegisterForm extends JFrame {

    private JPanel jPanel;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;

    public RegisterForm() {
        setTitle("conscious-program GUI");
        setContentPane(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}