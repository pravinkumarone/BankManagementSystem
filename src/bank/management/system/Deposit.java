package bank.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Deposit extends JFrame implements ActionListener {
    String pinNumber;
    JLabel image, text;
    JTextField amount;
    JButton deposit, back;

    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0, 0, 960, 720);
        add(image);

        text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(220, 200, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(240, 320, 240, 25);
        amount.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(amount);

        back = new JButton("back");
        back.setBounds(240, 370, 100, 30);
        back.setFont(new Font("System", Font.BOLD, 18));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        image.add(back);

        deposit = new JButton("Deposit");
        deposit.setBounds(360, 370, 120, 30);
        deposit.setFont(new Font("System", Font.BOLD, 18));
        deposit.setForeground(Color.black);
        deposit.setBackground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String depositAmount = amount.getText();
            Date date = new Date();
            if (depositAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "','Deposit','"
                            + depositAmount + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs." + depositAmount + " Deposited Successfully ");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

        else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposit("");
    }
}