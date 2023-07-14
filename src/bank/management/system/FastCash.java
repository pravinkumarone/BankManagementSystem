package bank.management.system;

import javax.swing.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {
    String pinNumber;
    JButton $500, $1000, $2000, $5000, $10_000, $20_000, back;
    JLabel image, text;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0, 0, 960, 720);
        add(image);

        text = new JLabel("Please select withdrawal amount");
        text.setBounds(220, 200, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(text);

        $500 = new JButton("INR 500");
        $500.setBounds(170, 300, 150, 30);
        $500.setFont(new Font("System", Font.BOLD, 16));
        $500.addActionListener(this);
        image.add($500);

        $1000 = new JButton("INR 1000");
        $1000.setBounds(400, 300, 150, 30);
        $1000.setFont(new Font("System", Font.BOLD, 16));
        $1000.addActionListener(this);
        image.add($1000);

        $2000 = new JButton("INR 2000");
        $2000.setBounds(170, 340, 150, 30);
        $2000.setFont(new Font("System", Font.BOLD, 16));
        $2000.addActionListener(this);
        image.add($2000);

        $5000 = new JButton("INR 5000");
        $5000.setBounds(400, 340, 150, 30);
        $5000.setFont(new Font("System", Font.BOLD, 16));
        $5000.addActionListener(this);
        image.add($5000);

        $10_000 = new JButton("INR 10,000");
        $10_000.setBounds(170, 380, 150, 30);
        $10_000.setFont(new Font("System", Font.BOLD, 16));
        $10_000.addActionListener(this);
        image.add($10_000);

        $20_000 = new JButton("INR 20,000");
        $20_000.setBounds(400, 380, 150, 30);
        $20_000.setFont(new Font("System", Font.BOLD, 16));
        $20_000.addActionListener(this);
        image.add($20_000);

        back = new JButton("Back");
        back.setBounds(400, 420, 150, 30);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4);

            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '" + pinNumber + "'");
                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank value('" + pinNumber + "', '" + date + "','Withdraw', '" + amount
                        + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "INR " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args) {
        new FastCash("");
    }
}