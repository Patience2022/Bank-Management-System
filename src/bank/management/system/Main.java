package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JButton btnDeposit, btnWithdraw,btnStatement,btnExit, btnPin, btnBalance;
    String pinNo;
    Main(String pinNo){
        this.pinNo = pinNo;
        ImageIcon iconDeposit = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image imageDeposit = iconDeposit.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon iconShow = new ImageIcon(imageDeposit);
        JLabel labelImage = new JLabel(iconShow);
        labelImage.setBounds(0,0,1550,830);
        add(labelImage);

        JLabel labelOption = new JLabel("Please select your transaction: ");
        labelOption.setBounds(450, 180, 600,35);
        labelOption.setForeground(Color.white);
        labelOption.setFont(new Font("System", Font.BOLD, 28));
        labelImage.add(labelOption);

        btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setForeground(Color.white);
        btnDeposit.setBackground(new Color(65,125,128));
        btnDeposit.addActionListener(this);
        btnDeposit.setBounds(400, 274, 120, 35);
        labelImage.add(btnDeposit);

        btnWithdraw = new JButton("CASH WITHDRAWAL");
        btnWithdraw.setForeground(Color.white);
        btnWithdraw.setBackground(new Color(65,125,128));
        btnWithdraw.addActionListener(this);
        btnWithdraw.setBounds(700, 274, 150, 35);
        labelImage.add(btnWithdraw);


        btnStatement = new JButton("STATEMENT");
        btnStatement.setForeground(Color.white);
        btnStatement.setBackground(new Color(65,125,128));
        btnStatement.addActionListener(this);
        btnStatement.setBounds(700, 318, 150, 35);
        labelImage.add(btnStatement);

        btnPin = new JButton("CHANGE PIN");
        btnPin.setForeground(Color.white);
        btnPin.setBackground(new Color(65,125,128));
        btnPin.addActionListener(this);
        btnPin.setBounds(400, 362, 120, 35);
        labelImage.add(btnPin);

        btnBalance = new JButton("BALANCE ENQUIRY");
        btnBalance.setForeground(Color.white);
        btnBalance.setBackground(new Color(65,125,128));
        btnBalance.addActionListener(this);
        btnBalance.setBounds(700, 362, 150, 35);
        labelImage.add(btnBalance);

        btnExit = new JButton("Exit");
        btnExit.setForeground(Color.white);
        btnExit.setBackground(new Color(65,125,128));
        btnExit.addActionListener(this);
        btnExit.setBounds(550, 400, 100, 35);
        labelImage.add(btnExit);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnDeposit){
            new Deposit(pinNo);
            setVisible(false);
        } else if (e.getSource()==btnExit) {
            System.exit(0);
        } else if (e.getSource()==btnWithdraw) {
            new Withdrawal(pinNo);
            setVisible(false);
        } else if (e.getSource()==btnBalance) {
            new BalanceEnquiry(pinNo);
            setVisible(false);
        } else if (e.getSource()==btnPin) {
            new ChangePin(pinNo);
            setVisible(false);
        } else if (e.getSource()==btnStatement) {
            new BankStatement(pinNo);
            setVisible(false);
        }


    }
    public static void main(String[] args) {
        new Main("");
    }


}
