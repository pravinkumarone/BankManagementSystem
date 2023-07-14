package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {
    JLabel additionalDetails, income, education, occupation, panNumber, aadharNumber, seniorCitizen, existingAccount;
    JComboBox educationDropDown, incomeDropDown, occupationDropDown; 
    JTextField panNumberField, aadharNumberField;
    JRadioButton seniorCitizenYes, seniorCitizenNo, existingAccountYes, existingAccountNo;
    ButtonGroup seniorCitizenGroup, existingAccountGroup;
    String formNo;
    JButton next;
    String incomeList[] = {"2,00,000 INR and Below","5,00,000 INR - 10,00,000 INR","10,00,000 INR - 20,00,000 INR","20,00,000 INR and Above"}; 
    String educationList[] = {"None", "Non-Graduate", "Graduate", "Post Graducate"};
    String occupationList[] = {"Goverment Sector", "Private Sector", "Self-Employed", "Student", "None"};

    Signup2(String formNo) {
        this.formNo = formNo;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(818,500);
        setLocation(280,60);
        setVisible(true);

        additionalDetails = new JLabel("Page 2: Additional details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(280, 40, 400, 30);
        add(additionalDetails);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(80, 120, 150, 30);
        add(income);

        incomeDropDown = new JComboBox(incomeList);
        incomeDropDown.setBounds(240, 120, 350, 30);
        incomeDropDown.setFont(new Font("Raleway", Font.BOLD, 18));
        incomeDropDown.setBackground(Color.white);
        add(incomeDropDown);

        education = new JLabel("Education: ");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(80, 160, 150, 30);
        add(education);

        educationDropDown = new JComboBox(educationList);
        educationDropDown.setFont(new Font("Raleway", Font.BOLD, 18));
        educationDropDown.setBackground(Color.white);
        educationDropDown.setBounds(240, 160, 350, 30);
        add(educationDropDown);

        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(80, 200, 150, 30);
        add(occupation);

        occupationDropDown = new JComboBox(occupationList);
        occupationDropDown.setFont(new Font("Raleway", Font.BOLD, 18));
        occupationDropDown.setBackground(Color.white);
        occupationDropDown.setBounds(240, 200, 350, 30);
        add(occupationDropDown);

        panNumber = new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        panNumber.setBounds(80, 240, 150, 30);
        add(panNumber);

        panNumberField = new JTextField();
        panNumberField.setFont(new Font("Raleway", Font.BOLD, 18));
        panNumberField.setBackground(Color.white);
        panNumberField.setBounds(240, 240, 350, 30);
        add(panNumberField);

        aadharNumber = new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNumber.setBounds(80, 280, 150, 30);
        add(aadharNumber);

        aadharNumberField = new JTextField();
        aadharNumberField.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNumberField.setBackground(Color.white);
        aadharNumberField.setBounds(240, 280, 350, 30);
        add(aadharNumberField);

        seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizen.setBounds(80, 320, 150, 30);
        add(seniorCitizen);

        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizenYes.setBackground(Color.WHITE);
        seniorCitizenYes.setBounds(240, 320, 150, 30);
        add(seniorCitizenYes);

        
        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizenNo.setBackground(Color.WHITE);
        seniorCitizenNo.setBounds(400, 320, 150, 30);
        add(seniorCitizenNo);
        
        seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorCitizenYes);
        seniorCitizenGroup.add(seniorCitizenNo);

        existingAccount = new JLabel("Existing Acount: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        existingAccount.setBounds(80, 360, 150, 30);
        add(existingAccount);
        
        existingAccountYes = new JRadioButton("Yes");
        existingAccountYes.setFont(new Font("Raleway", Font.BOLD, 18));
        existingAccountYes.setBackground(Color.white);
        existingAccountYes.setBounds(240, 360, 150, 30);
        add(existingAccountYes);

        existingAccountNo = new JRadioButton("No");
        existingAccountNo.setFont(new Font("Raleway", Font.BOLD, 18));
        existingAccountNo.setBackground(Color.white);
        existingAccountNo.setBounds(400, 360, 150, 30);
        add(existingAccountNo);

        existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountYes);
        existingAccountGroup.add(existingAccountNo);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(500, 400, 80, 40);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae){
        String income = (String) incomeDropDown.getSelectedItem();
        String education = (String) educationDropDown.getSelectedItem();
        String occupation = (String) occupationDropDown.getSelectedItem();
        String panNumber = panNumberField.getText();
        String aadharNumber = aadharNumberField.getText();
        String seniorCitizen = null;
        if(seniorCitizenYes.isSelected()){
            seniorCitizen = "Yes";
        } else if(seniorCitizenNo.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if(existingAccountYes.isSelected()){
            existingAccount = "Yes";
        } else if(existingAccountNo.isSelected()){
            existingAccount = "No";
        }

        try{
            if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values ('"+formNo+"', '"+income+"', '"+education+"', '"+occupation+"', '"+panNumber+"', '"+aadharNumber+"', '"+seniorCitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);

                new Signup3(formNo).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new Signup2("");
    }
}
