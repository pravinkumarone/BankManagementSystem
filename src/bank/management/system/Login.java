package bank.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton login, clear, signup;    
    JTextField cardTextField;
    JPasswordField cardPINField;
    JLabel welcome, cardNo, pin;

    Login() {
        setTitle("Automated Teller Machine Stimulator");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

        ImageIcon ico = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image ico2 = ico.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ico3 = new ImageIcon(ico2);
        JLabel label = new JLabel(ico3);
        label.setBounds(70, 10, 100, 100); // left , top, height, width
        add(label);

        welcome = new JLabel("Welcome to ATM");
        welcome.setFont(new Font("Osward", Font.BOLD, 38));
        welcome.setBounds(200, 40, 400, 40);
        add(welcome);

        cardNo = new JLabel("Card No. :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 400, 30);
        add(pin);

        cardPINField = new JPasswordField();
        cardPINField.setBounds(300, 220, 230, 30);
        cardPINField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardPINField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = cardPINField.getText();
            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or card PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true); 
        }
        else if (ae.getSource() == clear) {
            
            cardTextField.setText("");
            cardPINField.setText("");
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}