package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SetChangePIN extends JFrame implements ActionListener {
    String pinNumber;
    JLabel image, text, pinText, rePINText;
    JButton changePIN, back;
    JPasswordField newPIN, confirmNewPIN;

    SetChangePIN(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image bg2 = bg.getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        image = new JLabel(bg3);
        image.setBounds(0, 0, 960, 720);
        add(image);

        text = new JLabel("CHNAGE YOUR PIN");
        text.setBounds(260, 200, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Systen", Font.BOLD, 16));
        image.add(text);

        pinText = new JLabel("New PIN: ");
        pinText.setBounds(180, 300, 250, 30);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 18));
        image.add(pinText);

        rePINText = new JLabel("Re-Enter PIN: ");
        rePINText.setBounds(180, 350, 250, 30);
        rePINText.setForeground(Color.white);
        rePINText.setFont(new Font("System", Font.BOLD, 18));
        image.add(rePINText);
        
        newPIN = new JPasswordField();
        newPIN.setBounds(380, 300, 150, 28);
        newPIN.setFont(new Font("System", Font.BOLD, 18));
        image.add(newPIN);

        confirmNewPIN = new JPasswordField();
        confirmNewPIN.setBounds(380, 350, 150, 28);
        confirmNewPIN.setFont(new Font("Sytem", Font.BOLD, 18));
        image.add(confirmNewPIN);

        changePIN = new JButton("CHANGE PIN");
        changePIN.setBounds(380, 400, 150, 30);
        changePIN.setFont(new Font("System", Font.BOLD, 16));
        changePIN.setForeground(Color.black);
        changePIN.addActionListener(this);
        image.add(changePIN);

        back = new JButton("BACK");
        back.setBounds(180, 400, 150, 30);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(960, 720);
        setLocation(250, 40);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        try {
            String pin1 = newPIN.getText();
            String pin2 = confirmNewPIN.getText();
            
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
                
                if(ae.getSource() == changePIN){
                
                    if(pin1.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter new PIN");
                        return;

                    } else if(pin2.equals("")){
                        JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                        return;
                    }

                Conn conn = new Conn();
                String query1 = "update bank set pin_number = '"+pin1+"' where pin_number = '"+pinNumber+"'";               
                String query2 = "update login set pin_number = '"+pin1+"' where pin_number = '"+pinNumber+"'";               
                String query3 = "update signup3 set pin_number = '"+pin1+"' where pin_number = '"+pinNumber+"'";               

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN chnaged successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } else if(ae.getSource() == back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch (Exception e) {
            System.out.println(e);
        }   
    }         

    public static void main(String args[]) {
        new SetChangePIN("");
    }
}