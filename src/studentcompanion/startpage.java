/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author rowdy
 */
public class startpage implements ActionListener
{
    
    
    JFrame f;
    JTextField roll,pwd;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2,b3;
    JPasswordField password;
    String str;
    static String str1;

    public startpage() {
        f=new JFrame();
        ImageIcon img1=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\studentcompanion.jpeg");
        ImageIcon img2=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\admin.jpg");
        ImageIcon img3=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\student.jpg");
        ImageIcon img4=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\sharda.jpg");
        ImageIcon img5=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\exit.jpg");
        ImageIcon img6=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\go.jpg");
        b1=new JButton(img5);
        b2=new JButton(img6);
        b3=new JButton(img6);
        b1.setBounds(670, 0, 30, 30);
        b2.setBounds(285, 275 ,35 ,35 );
        b3.setBounds(623,275 ,35 ,35 );
        l1=new JLabel(img1);
        l1.setBounds(150, 25, 400, 75);
        
        l2=new JLabel(img2);
        l2.setBounds(75, 150, 220, 90);
        l3=new JLabel(img3);
        l3.setBounds(408, 150, 220, 90);
        l5=new JLabel("Enter Password:-");
        l5.setBounds(45, 245, 200, 30);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Serif", Font.BOLD, 20));
        l6=new JLabel("Enter Your Roll:-");
        l6.setBounds(388, 245, 200, 30);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Serif", Font.BOLD, 20));        
        l4=new JLabel(img4);
        l4.setBounds(0, 335, 700, 80);
        l7=new JLabel("OR");
        l7.setBounds(325, 170, 100, 60);
        l7.setForeground(Color.white);
        l7.setFont(new Font("Serif", Font.BOLD, 35));
        password=new JPasswordField();
        password.setBounds(45, 275, 240, 35);
        roll=new JTextField();
        roll.setBounds(388,275 , 240, 35);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.add(b3);
        f.add(b1);
        f.add(b2);
        f.add(l1);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(password);
        f.add(roll);
        f.add(l2);
        f.add(l3);
        f.setSize(700,400);
        
        
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            f.dispose();
        }
        else if(e.getSource()==b2)
        {
            char ch[]=password.getPassword();
            String pass=String.valueOf(ch);
            if(pass.equals("tscadmin123"))
            {
                new adminselectionpage();
                f.dispose();
            }
            else
            {
                String alert=new String("Sorry, Password ERROR !");
                JOptionPane.showMessageDialog(null,alert );
                password.setText("");
            }
        }
        else if(e.getSource()==b3)
        {
            
             
             String y = roll.getText();
             int flag=0;
            
            
            
            
            try
            {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT * FROM studentsss ");
 
            while (rec.next())
            {
                str=rec.getString("rollnb");
                str1=rec.getString("name");
            
             
 
            
                if (y.equals(str))
                {
                    System.out.println("Logged in!");
                    new studentselectionpage();
                    f.dispose();
                    flag=1;
                    
                } 
            }
                if(flag==0)
                {
                    //System.out.println("Invalid Roll Number !");
                    String alert=new String("Sorry, Roll No. ERROR !");
                JOptionPane.showMessageDialog(null,alert );
                roll.setText("");
                }
            
          st.close();
            
       
            }   catch(SQLException d) {
            System.out.println(e.toString());
        } catch(ClassNotFoundException f) {
            System.out.println(e.toString());
        }
       
            
            
            
           /* String rolln= roll.getText();  
            try        
            {
               
            
                String query="select name,roll from students where roll='"+rolln+"'";
                System.out.println("hello1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("hello2");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","0004");
            System.out.println("hello3");
            Statement stmt=con.createStatement();
            System.out.println("hello4");
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("hello5");

            if (rolln.equals(rs.getString("roll")))
            {
                new studentselectionpage();
                    f.dispose();
                    
            }
            else
                {
                    //System.out.println("Invalid Roll Number !");
                    String alert=new String("Sorry, Roll No. ERROR !");
                JOptionPane.showMessageDialog(null,alert );
                roll.setText("");
                } 
                
           
                
            }
                
         
            catch(Exception e1)
            {
                System.out.println("hello6");
            } */
    
        } 
    }
     
public static void main(String[] args) 
    {
        new startpage();
        // TODO code application logic here
    }

    private void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
