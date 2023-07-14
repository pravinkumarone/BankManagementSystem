package bank.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {
    JLabel accountDetails, accountType, card, number, pin, pNumber, cardCaption, pinCaption, serviceRequired;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    JRadioButton b1, b2, b3, b4;
    ButtonGroup accountGroup;
    String formNo;

    Signup3(String formNo) {
        this.formNo = formNo;

        setSize(850, 700);
        setLocation(280,60);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);

        accountType = new JLabel("Accont Type: ");
        accountType.setFont(new Font("Raleway", Font.BOLD, 20));
        accountType.setBounds(100, 100, 200, 30);
        add(accountType);

        b1 = new JRadioButton("Saving");
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setBounds(100, 140, 150, 30);
        b1.setBackground(Color.white);
        add(b1);

        b2 = new JRadioButton("Current");
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBounds(250, 140, 150, 30);
        b2.setBackground(Color.white);
        add(b2);

        b3 = new JRadioButton("Salary");
        b3.setFont(new Font("Raleway", Font.BOLD, 16));
        b3.setBounds(400, 140, 150, 30);
        b3.setBackground(Color.white);
        add(b3);

        b4 = new JRadioButton("Recurring");
        b4.setFont(new Font("Raleway", Font.BOLD, 16));
        b4.setBounds(550, 140, 150, 30);
        b4.setBackground(Color.white);
        add(b4);

        accountGroup = new ButtonGroup();
        accountGroup.add(b1);
        accountGroup.add(b2);
        accountGroup.add(b3);
        accountGroup.add(b4);

        card = new JLabel("Card Number: ");
        card.setBounds(100, 180, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card);

        number = new JLabel("6943-XXXX-XXXX-XXXX");
        number.setBounds(320, 180, 300, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        add(number);

        cardCaption = new JLabel("(Your 16 digit card number)");
        cardCaption.setBounds(100, 205, 300, 20);
        cardCaption.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardCaption);

        pin = new JLabel("PIN: ");
        pin.setBounds(100, 240, 300, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        pinCaption = new JLabel("(Your 4 digit card PIN)");
        pinCaption.setBounds(100, 275, 200, 20);
        pinCaption.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinCaption);

        pNumber = new JLabel("XXXX");
        pNumber.setBounds(320, 240, 200, 30);
        pNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pNumber);

        serviceRequired = new JLabel("Service(s) required");
        serviceRequired.setBounds(100, 300, 400, 20);
        serviceRequired.setFont(new Font("Raleway", Font.BOLD, 20));
        add(serviceRequired);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100, 340, 200, 30);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(320, 340, 200, 30);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(540, 340, 200, 30);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("Cheque Book");
        c4.setBounds(100, 390, 200, 30);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("Email Alerts");
        c5.setBounds(320, 390, 200, 30);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-Statements(Email)");
        c6.setBounds(540, 390, 200, 30);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct and best of my knowledge.");
        c7.setBounds(100, 520, 600, 30);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.white);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBounds(530, 580, 120, 40);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(100, 580, 120, 40);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        add(cancel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (b1.isSelected()) {
                accountType = "Saving Account";
            } else if (b2.isSelected()) {
                accountType = "Current Account";
            } else if (b3.isSelected()) {
                accountType = "Salary Account";
            } else if (b4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account type is required");
                return;
            } else if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept our terms and conditions");
                return;
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 6943936000000000L);

            String pinNumber = "" + Math.abs((random.nextInt() % 9000L) + 1000L);

            String services = "";
            if (c1.isSelected()) {
                services += "ATM Card, ";
            } else if (c2.isSelected()) {
                services += "Internet Banking, ";
            } else if (c3.isSelected()) {
                services += "Mobile Banking, ";
            } else if (c4.isSelected()) {
                services += "Cheque Book, ";
            } else if (c5.isSelected()) {
                services += "Email Alerts, ";
            } else if (c6.isSelected()) {
                services += "E-Statements(Email)";
            }

            try {
                    
                Conn conn = new Conn();
                String query1 = "insert into signup3 values('" + formNo + "', '" + accountType + "', '" + cardNumber
                        + "', '" + pinNumber + "', '" + services + "')";
                String query2 = "insert into login values('" + formNo + "', '" + cardNumber + "', '" + pinNumber
                        + "')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);

                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            
                } catch (Exception e) {
                    System.out.println(e);
                }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Signup3("");
    }
}