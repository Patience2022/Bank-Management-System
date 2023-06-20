package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {
    Statement statement;
    JRadioButton r1,r2,m1,m2;
    JButton next;
    JTextField textName, textLastName,textEmail,textMStatus,textHomeAddress,textCity,textCode,textProvince;
    JDateChooser dateChooser;
    Random random = new Random();
    long first4 = (random.nextLong()%9000L)+1000L;
    String first =" "+Math.abs(first4);
    SignUp(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(160, 20, 600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Information");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelLastName = new JLabel("LastName :");
        labelLastName.setFont(new Font("Raleway",Font.BOLD,20));
        labelLastName.setBounds(100,240,150,30);
        add(labelLastName);

        textLastName = new JTextField();
        textLastName.setFont(new Font("Raleway",Font.BOLD,14));
        textLastName.setBounds(300,240,400,30);
        add(textLastName);

        JLabel dateOfBirth = new JLabel("Date of Birth :");
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD,20));
        dateOfBirth.setBounds(100,340,200,30);
        add(dateOfBirth);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setFont(new Font("Raleway",Font.BOLD,20));
        labelGender.setBounds(100,290,100,30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,290, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450, 290, 90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMStatus = new JLabel("Marital Status:");
        labelMStatus .setFont(new Font("Raleway",Font.BOLD,20));
        labelMStatus .setBounds(100,440,200,30);
        add(labelMStatus );

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,440, 100, 30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450, 440, 100,30);
        add(m2);

        ButtonGroup buttonStatus = new ButtonGroup();
        buttonStatus .add(m1);
        buttonStatus .add(m2);

        JLabel labelAddress = new JLabel("Home address :");
        labelAddress.setFont(new Font("Raleway",Font.BOLD,20));
        labelAddress.setBounds(100,490,200,30);
        add(labelAddress);

        textHomeAddress = new JTextField();
        textHomeAddress.setFont(new Font("Raleway",Font.BOLD,14));
        textHomeAddress.setBounds(300,490,400,30);
        add(textHomeAddress);

        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        JLabel labelProvince = new JLabel("Province:");
        labelProvince.setFont(new Font("Raleway",Font.BOLD,20));
        labelProvince.setBounds(100,590,200,30);
        add(labelProvince);

        textProvince = new JTextField();
        textProvince.setFont(new Font("Raleway",Font.BOLD,14));
        textProvince.setBounds(300,590,400,30);
        add(textProvince);

        JLabel labelCityCode = new JLabel("City Code:");
        labelCityCode.setFont(new Font("Raleway",Font.BOLD,20));
        labelCityCode.setBounds(100,640,200,30);
        add(labelCityCode);

        textCode = new JTextField();
        textCode.setFont(new Font("Raleway",Font.BOLD,14));
        textCode.setBounds(300,640,400,30);
        add(textCode);

         next = new JButton("Next");
         next.setFont(new Font("Raleway",Font.BOLD,14));
         next.setBackground(Color.black);
         next.setForeground(Color.WHITE);
         next.setBounds(620,710,80,30);
         next.addActionListener(this);
         add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo =first;
        String name = textName.getText();
        String lastName = textLastName.getText();
        String DateOfBirth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if(r2.isSelected()) {
            gender = "Female";
        }

        String email = textEmail.getText();
        String maritalStatus = null;
        if( m1.isSelected()){
            maritalStatus = "Married";
        }else if(m2.isSelected()){
            maritalStatus = "UnMarried";
        }
        String address = textHomeAddress.getText();
        String city = textCity.getText();
        String province = textProvince.getText();
        String cityCode = textCode.getText();
        try {
            if(textName.getText().equals("")|| textLastName.getText().equals("")
            ||textEmail.getText().equals("")||gender==null){
                JOptionPane.showMessageDialog(null,"Please fill in all the details");
                return;
            }
            Connect connect = new Connect();
            String sql = "insert into userdetails values('"+formNo+"','"+name+"','"+lastName+"','"+DateOfBirth+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+province+"','"+cityCode+"')";
            connect.statement.executeUpdate(sql);
            new SignUp2(first);
            setVisible(false);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {

        new SignUp();
    }


}
