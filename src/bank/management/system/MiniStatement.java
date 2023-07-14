package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    String pinNumber;
    JLabel title, bank, card, mini, balance;
    JButton back;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        title = new JLabel("Java Bank");
        title.setBounds(160, 10, 150, 20);
        add(title);

        card = new JLabel();
        card.setBounds(20, 40, 300, 10);
        add(card);

        mini = new JLabel();
        mini.setBounds(20, 60, 300, 500);
        add(mini);

        balance = new JLabel();
        balance.setBounds(20, 450, 300, 30);
        
        int bal = 0;
        add(balance);

        back = new JButton("Close");
        back.setBounds(270, 500, 80, 20);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '" + pinNumber + "'");
            while (rs.next()) {
                card.setText("Card Number : " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '" + pinNumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is INR "+ bal);
        } catch (Exception e) {
            System.out.print(e);
        }

        setLayout(null);
        setSize(400, 600);
        setLocation(20, 40);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
