package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JRadioButton rBtnDeposit, rBtnSavings, rBtnCurrent, rBtnRDeposit;
    JCheckBox checkCard,checkIBanking,checkCBanking,checkStatement,checkEmail,checkBook;
    JButton btnSubmit, btnCancel;
    String formNo;
    Statement statement;
    SignUp3(String first){
        this.formNo = first;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel labelImage = new JLabel(imageIcon1);
        labelImage.setBounds(150,5,100,100);
        add(labelImage);

        JLabel labelPage3 = new JLabel("Page 3: ");
        labelPage3.setFont(new Font("Raleway", Font.BOLD,22));
        labelPage3.setBounds(280,40,400,40);
        add(labelPage3);

        JLabel labelDetails = new JLabel("Account Details: ");
        labelDetails.setFont(new Font("Raleway",Font.BOLD,22));
        labelDetails.setBounds(280,70,400,40);
        add(labelDetails);

        JLabel labelAccount = new JLabel("Account Type: ");
        labelAccount.setFont(new Font("Raleway",Font.BOLD,18));
        labelAccount.setBounds(100,140,200,30);
        add(labelAccount);

        rBtnSavings = new JRadioButton("Savings Account ");
        rBtnSavings.setFont(new Font("Raleway",Font.BOLD,16));
        rBtnSavings.setBackground(new Color(215,252,252));
        rBtnSavings.setBounds(100,180,180,30);
        add(rBtnSavings);

        rBtnDeposit = new JRadioButton("Fixed Deposit");
        rBtnDeposit.setFont(new Font("Raleway",Font.BOLD,16));
        rBtnDeposit.setBackground(new Color(215,252,252));
        rBtnDeposit.setBounds(350,180,150,30);
        add(rBtnDeposit);

        rBtnCurrent = new JRadioButton("Current Account ");
        rBtnCurrent.setFont(new Font("Raleway",Font.BOLD,16));
        rBtnCurrent.setBackground(new Color(215,252,252));
        rBtnCurrent.setBounds(100,220,180,30);
        add(rBtnCurrent);

        rBtnRDeposit = new JRadioButton("Recurring Deposit Account ");
        rBtnRDeposit.setFont(new Font("Raleway",Font.BOLD,16));
        rBtnRDeposit.setBackground(new Color(215,252,252));
        rBtnRDeposit.setBounds(350,220,250,30);
        add(rBtnRDeposit);

        ButtonGroup group = new ButtonGroup();
        group.add(rBtnRDeposit);
        group.add(rBtnDeposit);
        group.add(rBtnSavings);
        group.add(rBtnCurrent);

        JLabel labelCard = new JLabel("Card Number: ");
        labelCard.setFont(new Font("Raleway",Font.BOLD,18));
        labelCard.setBounds(100,300,200,30);
        add(labelCard);

        JLabel labelCardMessage = new JLabel("(Enter your 16 digit card number)");
        labelCardMessage.setFont(new Font("Raleway",Font.BOLD,10));
        labelCardMessage.setBounds(100,330,300,20);
        add(labelCardMessage);

        JLabel labelCardNo = new JLabel("XXXX-XXXX-XXXX-XXXX");
        labelCardNo.setFont(new Font("Raleway",Font.BOLD,18));
        labelCardNo.setBounds(350, 300,250,30);
        add(labelCardNo);

        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setFont(new Font("Raleway",Font.BOLD,18));
        labelPin.setBounds(100,360,200,30);
        add(labelPin);

        JLabel labelPinNo = new JLabel("X X X X");
        labelPinNo.setFont(new Font("Raleway",Font.BOLD,18));
        labelPinNo.setBounds(350,360,200,30);
        add(labelPinNo);

        JLabel labelService = new JLabel("Services Required:");
        labelService.setFont(new Font("Raleway",Font.BOLD,18));
        labelService.setBounds(100,400,200,30);
        add(labelService);

        checkCard = new JCheckBox("New Card");
        checkCard.setFont(new Font("Raleway",Font.BOLD,12));
        checkCard.setBackground(new Color(215,252,252));
        checkCard.setBounds(100,440,80,30);
        add(checkCard);

        checkIBanking = new JCheckBox("Internet Banking");
        checkIBanking.setFont(new Font("Raleway",Font.BOLD,12));
        checkIBanking.setBackground(new Color(215,252,252));
        checkIBanking.setBounds(350,440,120,30);
        add(checkIBanking);

        checkCBanking = new JCheckBox("Cellphone Banking");
        checkCBanking.setFont(new Font("Raleway",Font.BOLD,12));
        checkCBanking.setBackground(new Color(215,252,252));
        checkCBanking.setBounds(100,490,135,30);
        add(checkCBanking);

        checkStatement= new JCheckBox("E-Statement");
        checkStatement.setFont(new Font("Raleway",Font.BOLD,12));
        checkStatement.setBackground(new Color(215,252,252));
        checkStatement.setBounds(350,490,135,30);
        add(checkStatement);

        checkEmail = new JCheckBox("Email Alerts");
        checkEmail.setFont(new Font("Raleway",Font.BOLD,12));
        checkEmail.setBackground(new Color(215,252,252));
        checkEmail.setBounds(100,540,135,30);
        add(checkEmail);

        checkBook = new JCheckBox("Check Book");
        checkBook.setFont(new Font("Raleway",Font.BOLD,12));
        checkBook.setBackground(new Color(215,252,252));
        checkBook.setBounds(350,540,135,30);
        add(checkBook);

        JCheckBox checkDeclare = new JCheckBox("I declare that the above information is correct",true);
        checkDeclare.setFont(new Font("Raleway",Font.BOLD,12));
        checkDeclare.setBackground(new Color(215,252,252));
        checkDeclare.setBounds(100,590,300,30);
        add(checkDeclare);

        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Raleway",Font.BOLD,22));
        btnSubmit.setBackground(Color.black);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setBounds(100,660,120,30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Raleway",Font.BOLD,22));
        btnCancel.setBackground(Color.black);
        btnCancel.setForeground(Color.white);
        btnCancel.setBounds(350,660,120,30);
        btnCancel.addActionListener(this);
        add(btnCancel);

        JLabel labelForm = new JLabel("Form No: "+ first);
        labelForm.setFont(new Font("Raleway",Font.BOLD,18));
        labelForm.setBounds(600,5,100,30);
        add(labelForm);

        getContentPane().setBackground( new Color(76,252,211));
        setSize(850,750);
        setLocation(400,20);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountType = "";
        if(rBtnCurrent.isSelected()){
            accountType = "Current Account";
        } else if (rBtnDeposit.isSelected()) {
            accountType = "Deposit Account";
        } else if (rBtnRDeposit.isSelected()) {
            accountType ="recurring Deposit Account";
        } else if (rBtnSavings.isSelected()) {
            accountType ="Savings Account";
        }
        Random random = new Random();
        long first7 = (random.nextLong()%90000000L)+1457659000000000L;
        String cardNo =""+ Math.abs(first7);
        long first3 = (random.nextLong()%9000l)+1000l;
        String pinNo =""+Math.abs(first3);

        String serviceType = "";
        if(checkCard.isSelected()){
            serviceType +="NEW ATM CARD";
        } else if (checkStatement.isSelected()) {
            serviceType += "New Statement";
        } else if (checkBook.isSelected()) {
            serviceType += "New Check Book";
        } else if (checkEmail.isSelected()) {
            serviceType +="Email Alert Settings";
        } else if (checkIBanking.isSelected()) {
            serviceType +="Internet Banking";
        } else if (checkCBanking.isSelected()) {
            serviceType += "Cellphone Banking";
        }

        try{
            if(e.getSource()==btnSubmit){
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select type of an account");
                    return;
                }else {
                     Connect connection = new Connect();
                    String sql = "insert into userdetails3 values('"+formNo+"','"+accountType+"','"+cardNo+"','"+pinNo+"','"+serviceType+"')";
                    String sqlLogin = "insert into login values('"+formNo+"','"+cardNo+"',"+pinNo+")";
                    //('"+formNo+"','"+race+"','"+employmentStatus+"',' "+incomeRange+"',' "+industry+"','"+position+"','"+companyName+"','"+companyPhone+"','"+citizenshipStatus+"')"
                     connection.statement.executeUpdate(sql);
                     connection.statement.executeUpdate(sqlLogin);
                     JOptionPane.showMessageDialog(null, "Account opened successfully");
                     new Deposit(pinNo);
                     setVisible(false);
                }
            }else if (e.getSource()==btnCancel){
                JOptionPane.showMessageDialog(null,"Thank you for using our service, goodbye!");
                System.exit(0);
            }

        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void main(String[] args) {
        new SignUp3("");
    }


}

