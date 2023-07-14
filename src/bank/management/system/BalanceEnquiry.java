package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber;
    JLabel image, text;
    JButton back;

    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        
        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0, 0, 960, 720);
        add(image);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            } catch (Exception e) {
                System.out.print(e);
        }

        text = new JLabel("Your current balance account is "+ balance);
        text.setBounds(180, 250, 350, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);
        
        back = new JButton("Back");
        back.setBounds(400, 400, 150, 30);
        back.setFont(new Font("System", Font.BOLD, 18));
        back.addActionListener(this);
        image.add(back);

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
