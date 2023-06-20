package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class BankStatement extends JFrame implements ActionListener {
    String pinNo;
    ResultSet resultSet1,resultSet, resultSet2;
    JButton btnExit;
    Statement statement;
    BankStatement(String pinNo){

        this.pinNo = pinNo;

        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel labelTransDetails = new JLabel();
        labelTransDetails.setBounds(20, 120, 400, 250);
        add(labelTransDetails);

        JLabel labelStatement = new JLabel("BANK STATEMENT");
        labelStatement .setFont(new Font("System", Font.BOLD,15));
        labelStatement .setBounds(150, 20, 200,20);
        add(labelStatement );

        JLabel labelDate = new JLabel();
        labelDate.setBounds(150, 50, 200,20);
        add(labelDate);

        JLabel labelUser = new JLabel();
        labelUser .setBounds(150, 80, 200,20);
        add(labelUser );

        JLabel label3CardNo = new JLabel();
        label3CardNo.setBounds(150, 100, 300,20);
        add(label3CardNo);

        JLabel labelTotalBal = new JLabel();
        labelTotalBal.setBounds(20, 400, 300,20);
        add(labelTotalBal);

        try {
            Connect connection = new Connect();
            String sql = "select * from login where pinNo ='"+pinNo+"'";
            resultSet = connection.statement.executeQuery(sql);
            while (resultSet.next()){
                label3CardNo.setText("Card Number: " + resultSet.getString("cardNo"));
            }

        }catch (Exception e){e.printStackTrace();}

        try {
            int balance = 0;
            String name ="";
            String lastName="";
            Connect connection = new Connect();
            String sql = "select * from bank where pin ='" +pinNo+"'";

            resultSet = connection.statement.executeQuery(sql);
            while(resultSet.next()){
                labelTransDetails.setText(labelTransDetails.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("serviceType")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if(resultSet.getString("serviceType").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            String sqlFormNo = "select * from login where pinNo ='"+pinNo+"'";
            resultSet1=connection.statement.executeQuery(sqlFormNo);
            String formNo ="";
            while (resultSet1.next()) {
                formNo = resultSet1.getString("formNo");
            }
            String sqlName = "select * from userdetails where formNo ='" +formNo+"'";
            resultSet2 = connection.statement.executeQuery(sqlName);
            while (resultSet2.next()){
                name = resultSet2.getString("name");
                lastName=resultSet2.getString("lastName");
            }
            labelTotalBal.setText("Total Balance R "+balance);
            Date date = new Date();
            labelDate.setText(date.toString());
            labelUser.setText(name +" "+lastName);

        }catch (Exception e){e.printStackTrace();}
        btnExit =new JButton("EXIT");
        btnExit.setBackground(Color.black);
        btnExit.setForeground(Color.white);
        btnExit.setBounds(20,500,100,25);
        btnExit.addActionListener(this);
        add(btnExit);



        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        new Main(pinNo);
        setVisible(false);
    }
    public static void main(String[] args) {
        new BankStatement("");
    }


}
