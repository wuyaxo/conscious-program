package org.elac.form;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.elac.entity.UsersEntity;
import org.elac.service.IUsersService;
import org.elac.service.impl.UsersServiceImpl;
import org.elac.utils.SpringUtil;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-05 22:28
 */
public class LoginForm extends JFrame {

    private JPanel jPanel;
    private JButton loginButton;
    private JTextField userIdTextField;
    private JLabel messageLabel;


    public LoginForm() {
        setTitle("Login"); //LoginForm title is Login
        setContentPane(jPanel); // LoginForm has a panel named jPanel
        //application will exit and terminate JVM when the user closes the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        messageLabel.setText("");
        setSize(320, 180);
        //LoginForm in the center of the screen.
        setLocationRelativeTo(null);
        //it becomes visible on the screen and is rendered for the user to interact with
        setVisible(true);

        // listener to a button is clicked.
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get user input
                String userIdStr = userIdTextField.getText();
                //query in database
                IUsersService userService = new UsersServiceImpl();
                UsersEntity usersEntity = userService.getUsersByUserId(Integer.parseInt(userIdStr));
                if (Objects.isNull(usersEntity)) {
                    messageLabel.setText("User does not exist");
                } else {
                    //hide LoginForm
                    setVisible(false);
                    // show MainForm
                    MainForm mainForm = new MainForm();
                    mainForm.setVisible(true);
                    mainForm.setLocationRelativeTo(null);
                    mainForm.setTitle("Welcome");
                    mainForm.setSize(800, 600);
                    mainForm.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            }
        });
    }
}