package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangePin extends JFrame implements ActionListener {
    String pinNo;
    JButton btnChange, btnCancel;
    JPasswordField jpOld, jpNew, jpConfirm;
    Statement statement;
    ResultSet resultSet;
    ChangePin(String pinNo){
        this.pinNo = pinNo;

        ImageIcon iconDeposit = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image imageDeposit = iconDeposit.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon iconShow = new ImageIcon(imageDeposit);
        JLabel labelImage = new JLabel(iconShow);
        labelImage.setBounds(0,0,1550,830);
        add(labelImage);

        JLabel labelChange = new JLabel("Change your pin");
        labelChange.setFont(new Font("Raleway",Font.BOLD,16));
        labelChange.setForeground(Color.white);
        labelChange.setBounds(420,180,300, 35);
        labelImage.add(labelChange);

        JLabel labelNew = new JLabel("New Pin :");
        labelNew.setFont(new Font("Raleway",Font.BOLD,18));
        labelNew.setForeground(Color.white);
        labelNew.setBounds(420,220,150, 35);
        labelImage.add(labelNew);

        jpNew = new JPasswordField();
        jpNew.setBackground(new Color(65,125,128));
        jpNew.setForeground(Color.white);
        jpNew.setBounds(600,220,200,35);
        jpNew.setFont(new Font("Raleway", Font.BOLD,22));
        labelImage.add(jpNew);

        JLabel labelConfirm = new JLabel("Confirm New Pin :");
        labelConfirm.setFont(new Font("Raleway",Font.BOLD,18));
        labelConfirm.setForeground(Color.white);
        labelConfirm.setBounds(420,270,300, 35);
        labelImage.add(labelConfirm);

        jpConfirm = new JPasswordField();
        jpConfirm.setBackground(new Color(65,125,128));
        jpConfirm.setForeground(Color.white);
        jpConfirm.setBounds(600,270,200,35);
        jpConfirm.setFont(new Font("Raleway", Font.BOLD,22));
        labelImage.add(jpConfirm);

        btnChange = new JButton("SUBMIT");
        btnChange.setBackground(new Color(65,125,128));
        btnChange.setBounds(650,362,150,35);
        btnChange.setForeground(Color.white);
        btnChange.addActionListener(this);
        labelImage.add(btnChange);

        btnCancel = new JButton("BACK");
        btnCancel.setBackground(new Color(65,125,128));
        btnCancel.setBounds(650,408,150,35);
        btnCancel.setForeground(Color.white);
        btnCancel.addActionListener(this);
        labelImage.add(btnCancel);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnChange){
            try {

                String newPin = jpNew.getText();
                String confirmPin = jpConfirm.getText();
                if(!newPin.equals(confirmPin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match \n Try again");
                    return;
                }else {
                    if(newPin.equals("") || confirmPin.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter new pin value");
                        return;
                    }
                    Connect connection = new Connect();
                    String sqlBank ="update bank set pin ='"+newPin+"' where pin ='"+pinNo+"'";
                    String sqLogin ="update login set pinNo ='"+newPin+"' where pinNo ='"+pinNo+"'";
                    String sql ="update userdetails3 set pinNo ='"+newPin+"' where pinNo ='"+pinNo+"'";
                    connection.statement.executeUpdate(sqlBank);
                    connection.statement.executeUpdate(sqLogin);
                    connection.statement.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null,"Pin Code has been changed successfully");
                    new Login();
                    setVisible(false);
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }else {
            setVisible(false);
            new Main(pinNo);
        }


    }

    public static void main(String[] args) {
        new ChangePin("");

    }
}
