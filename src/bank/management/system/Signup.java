package bank.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    int random;
    JLabel formNo, personalDetails, name, fathersName, dateOfBirth, gender, contactNumber, emailAddress, maritalStatus, address, city, state, pinCode;
    JTextField nameField, fathersNameField, contactNumberField, emailAddressField, maritalStatusField, addressField, cityField, stateField, pinCodeField;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried;
    ButtonGroup genderGroup, maritalStatusGroup;
    JButton next;
    
    Signup(){
        Random ran = new Random();
        random = Math.abs(ran.nextInt());

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(820,700);
        setLocation(280,60);
        setVisible(true);
        
        formNo = new JLabel("APPLICATION FORM NO. : " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 32));
        formNo.setBounds(140, 20, 700, 40);
        add(formNo);
        
        personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(350, 70, 400, 30);
        add(personalDetails);
        
        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 140, 140, 30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("RaleWay", Font.BOLD, 14));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);

        fathersName = new JLabel("Father's Name: ");
        fathersName.setFont(new Font("Raleway", Font.BOLD, 18));
        fathersName.setBounds(100, 180, 140, 30);
        add(fathersName);

        fathersNameField = new JTextField();
        fathersNameField.setFont(new Font("RaleWay", Font.BOLD, 14));
        fathersNameField.setBounds(300, 180, 400, 30);
        add(fathersNameField);

        dateOfBirth = new JLabel("Date Of Birth: ");
        dateOfBirth.setFont(new Font("Raleway", Font.BOLD, 18));
        dateOfBirth.setBounds(100, 220, 140, 30);
        add(dateOfBirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 260, 140, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 260, 100, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(410, 260, 100, 30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(520, 260, 100, 30);
        other.setBackground(Color.white);
        add(other);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        contactNumber = new JLabel("Contact No: ");
        contactNumber.setFont(new Font("Ralway", Font.BOLD, 18));
        contactNumber.setBounds(100, 300, 140, 30);
        add(contactNumber);

        contactNumberField = new JTextField();
        contactNumberField.setFont(new Font("RaleWay", Font.BOLD, 14));
        contactNumberField.setBounds(300, 300, 400, 30);
        add(contactNumberField);

        emailAddress = new JLabel("Email: ");
        emailAddress.setFont(new Font("Raleway", Font.BOLD, 18));
        emailAddress.setBounds(100, 340, 140, 30);
        add(emailAddress);

        emailAddressField = new JTextField();
        emailAddressField.setFont(new Font("RaleWay", Font.BOLD, 14));
        emailAddressField.setBounds(300, 340, 400, 30);
        add(emailAddressField);

        maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        maritalStatus.setBounds(100, 380, 140, 30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(320, 380, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(480, 380, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        
        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 420, 140, 30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("RaleWay", Font.BOLD, 14));
        addressField.setBounds(300, 420, 400, 30);
        add(addressField);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 460, 140, 30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("RaleWay", Font.BOLD, 14));
        cityField.setBounds(300, 460, 400, 30);
        add(cityField);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 500, 140, 30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("RaleWay", Font.BOLD, 14));
        stateField.setBounds(300, 500, 400, 30);
        add(stateField);
        
        pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 18));
        pinCode.setBounds(100, 540, 140, 30);
        add(pinCode);

        pinCodeField = new JTextField();
        pinCodeField.setFont(new Font("RaleWay", Font.BOLD, 14));
        pinCodeField.setBounds(300, 540, 400, 30);
        add(pinCodeField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 580, 80, 30);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
        String name =  nameField.getText();
        String fathersName = fathersNameField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        } else if(other.isSelected()){
            gender = "Other";
        }
        String contactNumber = contactNumberField.getText();
        String email = emailAddressField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        } else if(unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinCodeField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formNo+"', '"+name+"', '"+fathersName+"', '"+dob+"', '"+gender+"', '"+contactNumber+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup2(formNo).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new Signup();
    }
}