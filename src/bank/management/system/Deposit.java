package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    Statement statement;
String pinNo;
JTextField  textDeposit;
JButton btnDeposit, btnCancel;
    Deposit(String pinNo){
        this.pinNo =pinNo;

        ImageIcon iconDeposit = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image imageDeposit = iconDeposit.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon iconShow = new ImageIcon(imageDeposit);
        JLabel labelImage = new JLabel(iconShow);
        labelImage.setBounds(0,0,1550,830);
        add(labelImage);

        JLabel labelDeposit = new JLabel("Enter Deposit Amount: ");
        labelDeposit.setFont(new Font("Raleway",Font.BOLD,16));
        labelDeposit.setForeground(Color.white);
        labelDeposit.setBounds(420,180,300, 35);
        labelImage.add(labelDeposit);

        textDeposit = new JTextField();
        textDeposit.setBackground(new Color(65,125,128));
        textDeposit.setForeground(Color.white);
        textDeposit.setBounds(420, 230, 300, 30);
        textDeposit.setFont(new Font("Raleway", Font.BOLD,22));
        labelImage.add(textDeposit);

        btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(new Color(65,125,128));
        btnDeposit.setBounds(650,362,150,35);
        btnDeposit.setForeground(Color.white);
        btnDeposit.addActionListener(this);
        labelImage.add(btnDeposit);

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

        try {


        int amount = Integer.parseInt(textDeposit.getText());
        SimpleDateFormat format = new SimpleDateFormat();
        Date date = new Date();

        String serviceType = "Deposit";
        System.out.println(date);

        if(e.getSource()==btnDeposit){
            if(amount <= 49) {
                JOptionPane.showMessageDialog(null, "Please enter amount greater than 50");
            }else {
                Connect connection = new Connect();
                String sql = "insert into bank values('"+pinNo+"','"+date+"','"+serviceType+"','"+amount+"')";
                connection.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "R "+amount+".00 has been successfully deposited");
                setVisible(false);
                new Main(pinNo);
            }
        }else if(e.getSource()==btnCancel){

                setVisible(false);
                new Main(pinNo);

            }

        }
        catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(null,"Please enter numeric values only");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }


}
