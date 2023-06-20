package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp2 extends JFrame implements ActionListener {
    JComboBox comboRace, comboEmployment, comboIncome,comboIndustry,comboPosition;
    JTextField textOrganization,textOrgTelephone;
    private Statement statement;
    JButton next;

    JRadioButton buttonCitizen, buttonNonCitizen;
    String formNo;

    SignUp2(String first){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formNo =first;
        JLabel l1 = new JLabel("Page 2: ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Deatils");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,400,40);
        add(l2);

        JLabel labelRace = new JLabel("Ethnicity: ");
        labelRace.setFont(new Font("Raleway",Font.BOLD,18));
        labelRace.setBounds(100,120,100,30);
        add(labelRace);

        String race[] ={
                "African","Asian", "White","Coloured","Other"
        };
        comboRace = new JComboBox(race);
        comboRace.setBackground(new Color(222,255,228));
        comboRace.setFont(new Font("Raleway", Font.BOLD,14));
        comboRace.setBounds(350,120,320,30);
        add(comboRace);

        JLabel labelCat = new JLabel("Category: ");
        labelCat.setFont(new Font("Raleway",Font.BOLD,18));
        labelCat.setBounds(100,170,100,30);
        add(labelCat);

        String employmentState[] = {"Employed","Self-employed","Unemployed"};
        comboEmployment = new JComboBox(employmentState);
        comboEmployment.setBackground(new Color(222,255,228));
        comboEmployment.setFont(new Font("Raleway",Font.BOLD,14));
        comboEmployment.setBounds(350,170,320,30);
        add(comboEmployment);

        JLabel labelIncome = new JLabel("Income range: ");
        labelIncome.setFont(new Font("Raleway",Font.BOLD,18));
        labelIncome.setBounds(100,220,150,30);
        add(labelIncome);

        String incomeRange[] = {"R10 000- R15 000","R15 001- R20 000","R20 001 - R25 000","R25 001 - R30 000","Above R30 000"};
        comboIncome = new JComboBox(incomeRange);
        comboIncome.setBackground(new Color(222,255,228));
        comboIncome.setFont(new Font("Raleway",Font.BOLD,14));
        comboIncome.setBounds(350,220,320,30);
        add(comboIncome);

        JLabel labelIndustry = new JLabel("Employment Industry: ");
        labelIndustry.setFont(new Font("Raleway",Font.BOLD,18));
        labelIndustry.setBounds(100,270,200,30);
        add(labelIndustry);

        String industry[] = {"Administration","Information Technology","Human Resources","Manufacturing","Law","Other"};
        comboIndustry = new JComboBox(industry);
        comboIndustry.setBackground(new Color(222,255,228));
        comboIndustry.setFont(new Font("Raleway",Font.BOLD,14));
        comboIndustry.setBounds(350,270,320,30);
        add(comboIndustry);

        JLabel labelPosition = new JLabel("Functions: ");
        labelPosition.setFont(new Font("Raleway",Font.BOLD,18));
        labelPosition.setBounds(100,320,200,30);
        add(labelPosition);

        String position[] = {"Administrator","Clerk","Software Developer","Bookkeeper","Lawyer","Advocate","Director","Sales","HR Manager","Other"};
        comboPosition = new JComboBox(position);
        comboPosition.setBackground(new Color(222,255,228));
        comboPosition.setFont(new Font("Raleway",Font.BOLD,14));
        comboPosition.setBounds(350,320,320,30);
        add(comboPosition);

        JLabel labelOrganization = new JLabel("Company Name: ");
        labelOrganization.setFont(new Font("Raleway",Font.BOLD,18));
        labelOrganization.setBounds(100,370,200,30);
        add(labelOrganization);

        textOrganization = new JTextField();
        textOrganization.setFont(new Font("Raleway",Font.BOLD,18));
        textOrganization.setBounds(350,370,320,30);
        add(textOrganization);

        JLabel labelOrgTelephone = new JLabel("Company Phone: ");
        labelOrgTelephone.setFont(new Font("Raleway",Font.BOLD,18));
        labelOrgTelephone.setBounds(100,420,200,30);
        add(labelOrgTelephone);

        textOrgTelephone = new JTextField();
        textOrgTelephone.setFont(new Font("Raleway",Font.BOLD,18));
        textOrgTelephone.setBounds(350,420,320,30);
        add(textOrgTelephone);

        JLabel labelCitizen = new JLabel("Citizenship: ");
        labelCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        labelCitizen.setBounds(100,470,200,30);
        add(labelCitizen);

        buttonCitizen = new JRadioButton("SA Citizen");
        buttonCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        buttonCitizen.setBounds(350,470,120,30);
        add(buttonCitizen);

        buttonNonCitizen = new JRadioButton("Non-Citizen");
        buttonNonCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        buttonNonCitizen.setBounds(480,470,150,30);
        add(buttonNonCitizen);

        ButtonGroup group = new ButtonGroup();
        group.add(buttonCitizen);
        group.add(buttonNonCitizen);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(530,560,90,30);
        next.addActionListener(this);
        add(next);

        JLabel labelForm = new JLabel("Form No:"+first);
        labelForm.setFont(new Font("Raleway",Font.BOLD,14));
        labelForm.setBounds(700,10,200,30);
        add(labelForm);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(76, 252, 211));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String race = (String) comboRace.getSelectedItem();
      String employmentStatus = (String) comboEmployment.getSelectedItem();
      String incomeRange = (String) comboIncome.getSelectedItem();
      String industry = (String) comboIndustry.getSelectedItem();
      String position = (String) comboPosition.getSelectedItem();
      String companyName = textOrganization.getText();
      String companyPhone = textOrgTelephone.getText();
      String citizenshipStatus = null;
      if(buttonCitizen.isSelected()){
          citizenshipStatus = "SA Citizen";
      }
      else if (buttonNonCitizen.isSelected()){
          citizenshipStatus ="Non SA Citizen";
      }
      if(citizenshipStatus==null){
          JOptionPane.showMessageDialog(null,"Please select your status code");
          return;
      }
      if(employmentStatus.equals("Employed") && companyName.equals("")||companyPhone.equals("")){
          JOptionPane.showMessageDialog(null,"Please enter full company details");
          return;
      }

      String sql ="insert into userdetails2 values ('"+formNo+"','"+race+"','"+employmentStatus+"',' "+incomeRange+"',' "+industry+"','"+position+"','"+companyName+"','"+companyPhone+"','"+citizenshipStatus+"')";
        Connect connect = new Connect();
        try {
            connect.statement.executeUpdate(sql);
            new SignUp3(formNo);
            setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new SignUp2("");
    }


}
