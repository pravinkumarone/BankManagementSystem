package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JLabel image, text;
    JButton deposit, withdraw, miniStatement, setChangePIN, checkBalance, fastCash, exit;
    String pinNumber;

    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0, 0, 960, 720);
        add(image);

        text = new JLabel("Please select your transaction");
        text.setBounds(240, 200, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Cash Deposit");
        deposit.setBounds(170, 300, 150, 30);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(400, 300, 150, 30);
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.addActionListener(this);
        image.add(withdraw);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(170, 340, 150, 30);
        miniStatement.setFont(new Font("System", Font.BOLD, 16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        fastCash = new JButton("Fastcash");
        fastCash.setBounds(400, 340, 150, 30);
        fastCash.setFont(new Font("System", Font.BOLD, 16));
        fastCash.addActionListener(this);
        image.add(fastCash);

        setChangePIN = new JButton("Set PIN");
        setChangePIN.setBounds(170, 380, 150, 30);
        setChangePIN.setFont(new Font("System", Font.BOLD, 16));
        setChangePIN.addActionListener(this);
        image.add(setChangePIN);

        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(400, 380, 150, 30);
        checkBalance.setFont(new Font("System", Font.BOLD, 16));
        checkBalance.addActionListener(this);
        image.add(checkBalance);

        exit = new JButton("Exit");
        exit.setBounds(400, 420, 150, 30);
        exit.setFont(new Font("System", Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (ae.getSource() == checkBalance) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        } else if (ae.getSource() == setChangePIN) {
            setVisible(false);
            new SetChangePIN(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("");
    }
}