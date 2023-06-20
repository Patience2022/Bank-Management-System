package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton btnBalance, btnCancel;
    String pinNo;
    JLabel labelBalance;
    Statement statement;
    ResultSet resultSet;
    BalanceEnquiry(String pinNo){
        this.pinNo = pinNo;

        ImageIcon iconDeposit = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image imageDeposit = iconDeposit.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon iconShow = new ImageIcon(imageDeposit);
        JLabel labelImage = new JLabel(iconShow);
        labelImage.setBounds(0,0,1550,830);
        add(labelImage);

        JLabel labelDeposit = new JLabel(" Your current balance is  ");
        labelDeposit.setFont(new Font("System",Font.BOLD,16));
        labelDeposit.setForeground(Color.white);
        labelDeposit.setBounds(420,180,300, 35);
        labelImage.add(labelDeposit);

        labelBalance = new JLabel();
        labelBalance.setFont(new Font("System",Font.BOLD,16));
        labelBalance.setForeground(Color.white);
        labelBalance.setBounds(420,220,300, 35);
        labelImage.add(labelBalance);

        btnCancel = new JButton("BACK");
        btnCancel.setBackground(new Color(65,125,128));
        btnCancel.setBounds(650,408,150,35);
        btnCancel.setForeground(Color.white);
        btnCancel.addActionListener(this);
        labelImage.add(btnCancel);

        int balance = 0;

        try {
            Connect connection = new Connect();
            String sql = "select * from bank where pin ='" +pinNo+"'";
            resultSet = connection.statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getString("serviceType").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        labelBalance.setText("R "+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main(pinNo);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
}
