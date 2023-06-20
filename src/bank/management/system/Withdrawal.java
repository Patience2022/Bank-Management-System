package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    Statement statement;
    ResultSet resultSet;
    String pinNo;
    JTextField  textWithdraw;
    JButton btnWithdraw, btnCancel;
    Withdrawal(String pinNo){


        this.pinNo =pinNo;

        ImageIcon iconDeposit = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image imageDeposit = iconDeposit.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon iconShow = new ImageIcon(imageDeposit);
        JLabel labelImage = new JLabel(iconShow);
        labelImage.setBounds(0,0,1550,830);
        add(labelImage);

        JLabel labelDeposit = new JLabel("Enter Amount: ");
        labelDeposit.setFont(new Font("Raleway",Font.BOLD,16));
        labelDeposit.setForeground(Color.white);
        labelDeposit.setBounds(420,180,300, 35);
        labelImage.add(labelDeposit);

        textWithdraw = new JTextField();
        textWithdraw.setBackground(new Color(65,125,128));
        textWithdraw.setForeground(Color.white);
        textWithdraw.setBounds(420, 230, 300, 30);
        textWithdraw.setFont(new Font("Raleway", Font.BOLD,22));
        labelImage.add(textWithdraw);

        JLabel labelNotice = new JLabel("Minimum withdrawal amount is R100");
        labelNotice.setFont(new Font("Raleway",Font.BOLD,12));
        labelNotice.setForeground(Color.white);
        labelNotice.setBounds(420,260,210, 20);
        labelImage.add(labelNotice);


        btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw .setBackground(new Color(65,125,128));
        btnWithdraw .setBounds(650,362,150,35);
        btnWithdraw .setForeground(Color.white);
        btnWithdraw .addActionListener(this);
        labelImage.add(btnWithdraw );

        btnCancel = new JButton("BACK");
        btnCancel.setBackground(new Color(65,125,128));
        btnCancel.setBounds(650,408,150,35);
        btnCancel.setForeground(Color.white);
        btnCancel.addActionListener(this);
        labelImage.add(btnCancel);

            setLayout(null);
            setSize(1550,1080);
            setLocation(0,0);
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnWithdraw) {
            try {
                int amount = Integer.parseInt(textWithdraw.getText());
                System.out.println(amount);
                Date date = new Date();

                Connect connection = new Connect();
                String sql = "select *from bank where pin = '"+pinNo+"'";
                resultSet = connection.statement.executeQuery(sql);
                int balance =0;
                while (resultSet.next()){
                    if(resultSet.getString("serviceType").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(balance < amount){
                    JOptionPane.showMessageDialog(null, "Insufficient amount"+"\nYour balance is "+balance);
                    return;
                }else {
                    String serviceType = "Withdrawal";
                    String withdraw = "insert into bank values('"+pinNo+"','"+date+"','"+serviceType+"','"+amount+"')";
                    connection.statement.executeUpdate(withdraw);
                    JOptionPane.showMessageDialog(null,"Collect your cash");
                    setVisible(false);
                    new Main(pinNo);
                }

            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Please enter a valued amount");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else if(e.getSource()==btnCancel) {
            setVisible(false);
            new Main(pinNo);
        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }


}
