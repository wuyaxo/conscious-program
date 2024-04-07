import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginAndSignUp extends JFrame implements ActionListener
{
    
    Font bigFont = new Font("Arial", Font.BOLD, 12);
   
    JLabel namePrompt = new JLabel("Full Name: ");
    JLabel addrPrompt = new JLabel("Address: ");
    JLabel phoneNumPrompt = new JLabel("Phone: ");
    JLabel emailPrompt = new JLabel("Email: ");
    JLabel msgLab = new JLabel();
   
    JTextField name = new JTextField();
    JTextField addy = new JTextField();
    JTextField phone = new JTextField();
    JTextField email = new JTextField();
    
    JButton button = new JButton("Register");

    
    final int FRAME_WIDTH = 420;
    final int FRAME_HEIGHT = 420;
   
    public LoginAndSignUp()
    {
        super( "Registration Form");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        add(namePrompt);
        namePrompt.setBounds(50,100,75,25);
        add(addrPrompt);
        addrPrompt.setBounds(50,125,75,25);
        add(phoneNumPrompt);
        phoneNumPrompt.setBounds(50,150,75,25);
        add(emailPrompt);
        emailPrompt.setBounds(50,175,75,25);
        add(msgLab);
        msgLab.setBounds(168,300,100,25);

        add(name);
        name.setBounds(125,100,200,25);
        add(addy);
        addy.setBounds(125,125,200,25);
        add(phone);
        phone.setBounds(125,150,200,25);
        add(email);
        email.setBounds(125,175,200,25);

        add(button);
        button.setBounds(152,250,100,25);
        button.addActionListener(this);
    }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==button) 
            {
			
                String StrName = name.getText();
                String StrAddy = addy.getText();
                String StrPhone = phone.getText();
                String StrEmail = email.getText();

                if(name.getText().isEmpty() && addy.getText().isEmpty() && phone.getText().isEmpty() && email.getText().isEmpty())
                {
                    msgLab.setForeground(Color.red);
                    msgLab.setText("Please Register");
                }
                else
                {
                    msgLab.setForeground(Color.green);
                    msgLab.setText("Registered");    
                }
               
                
           
        }
        
    
}
}
