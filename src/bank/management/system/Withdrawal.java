package bank.management.system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Withdrawal extends JFrame implements ActionListener{
    String pinNumber;
    JLabel image, text;
    JTextField amountField;
    JButton back, withdraw;
    
    Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0,0,960,720);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(220, 200, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(text);

        amountField = new JTextField();
        amountField.setBounds(240, 320, 200, 25);
        amountField.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(amountField);

        back = new JButton("Back");
        back.setBounds(240, 370, 100, 30);
        back.setFont(new Font("System", Font.BOLD, 18));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        image.add(back);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360, 370, 100, 30);
        withdraw.setFont(new Font("System", Font.BOLD, 18));
        withdraw.setForeground(Color.black);
        withdraw.setBackground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);       

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String withdrawAmount = amountField.getText();
            Date date = new Date();
        
            if(withdrawAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"','Withdrawal','"+withdrawAmount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+ withdrawAmount+ " Withdraw Successfull");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]){
        new Withdrawal("");
    }
}