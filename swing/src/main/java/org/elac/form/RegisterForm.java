package org.elac.form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-05 22:28
 */
public class RegisterForm extends JFrame {

    private JTextField firstName;
    private JPanel jPanel;

    public RegisterForm() {
        setTitle("conscious-program GUI");
        setContentPane(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 1024);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}