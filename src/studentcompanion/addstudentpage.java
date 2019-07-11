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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
/**
 *
 * @author rowdy
 */
public class addstudentpage implements ActionListener 
{
    JFrame f;
    JButton addb,deleteb,backb,exitb;
    JTextField nametf,rolltf;
    JLabel namel,rolll,shrdalogo,orl;
    public addstudentpage()
    {
        f=new JFrame("Add/Delete Students");
        ImageIcon shardalogo= new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\sharda.jpg");
        ImageIcon back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\exit.jpg");
        shrdalogo=new JLabel(shardalogo);
        shrdalogo.setBounds(0, 130, 700, 80);
        namel=new JLabel("NAME:-");
        namel.setBounds(50, 50, 100, 30);
        nametf=new JTextField();
        nametf.setBounds(250, 50, 200, 30);
        
        namel.setForeground(Color.white);
        namel.setFont(new Font("Serif", Font.BOLD, 20));
        
        rolll=new JLabel("ROLL NO.:-");
        rolll.setBounds(50, 90, 150, 30);
        rolltf=new JTextField();
        rolltf.setBounds(250, 90, 200, 30);
        
        rolll.setForeground(Color.white);
        rolll.setFont(new Font("Serif", Font.BOLD, 20));
        
        addb=new JButton("<html>A<br/>d<br/>d</html>");
        addb.setBounds(500, 30, 40, 100);
        deleteb=new JButton("<html>D<br/>e<br/>l<br/>e<br/>t<br/>e</html>");
        deleteb.setBounds(620, 30, 40, 100);
        backb=new JButton(back);
        backb.setBounds(30, 0, 30, 30);
        exitb=new JButton(exit);
        exitb.setBounds(0, 0, 30, 30);
        orl=new JLabel("OR");
        orl.setBounds(565, 65, 30, 30);
        orl.setForeground(Color.white);
        orl.setFont(new Font("Serif", Font.BOLD, 20));
        f.add(orl);
        f.add(deleteb);
        f.add(addb);
        f.add(backb);
        f.add(exitb);
        f.add(shrdalogo);
        f.add(namel);
        f.add(nametf);
        f.add(rolll);
        f.add(rolltf);
        f.setSize(700, 200);
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        addb.addActionListener(this);
        deleteb.addActionListener(this);
        backb.addActionListener(this);
        exitb.addActionListener(this);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addb)
        {
            String namestr=nametf.getText();
            String rollstr=rolltf.getText();
            
            try
        {
            System.out.println("hello1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("hello2");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
            System.out.println("hello3");
            Statement stmt=con.createStatement();
            System.out.println("hello4");
            //stmt.executeQuery("create table tabish (name varchar(20),rollnb number(20))");
            //stmt.executeQuery("create table studentsss (name varchar(20),rollnb number(20))");
           // System.out.println("created");
           //String str= "insert into studentsss values('"namestr+"','"+rollstr"')";
            stmt.executeUpdate("insert into studentsss values('"+namestr+"','"+rollstr+"')");
           // stmt.executeUpdate("insert into tabish values('YASH',160101331)");
            System.out.println("INSERTED");
            
            String alert=new String("Congrats, You have successfully INSERTED !");
            JOptionPane.showMessageDialog(null,alert );
            nametf.setText("");
            rolltf.setText("");
            
            con.close();
        }
        catch(ClassNotFoundException | SQLException e1)
        {
            System.out.println("hello6");
        }
            
            
        }
        else if(e.getSource()== deleteb)
        {
            
            String namestr=nametf.getText();
            String rollstr=rolltf.getText();
            int a=Integer.parseInt(rollstr);
            
            try
        {
            System.out.println("hello1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("hello2");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
            System.out.println("hello3");
            //Statement stmt=con.createStatement();
            PreparedStatement ps=con.prepareStatement("delete from studentsss where rollnb=?");
            System.out.println("hello4");
            //stmt.executeQuery("create table tabish (name varchar(20),rollnb number(20))");
            //stmt.executeQuery("create table studentsss (name varchar(20),rollnb number(20))");
           // System.out.println("created");
           //String str= "insert into studentsss values('"namestr+"','"+rollstr"')";
            ps.setInt(1,a); 
            ps.executeUpdate();
            //stmt.executeQuery("delete * from studentsss where rollnb= 'rollstr' ");
           // stmt.executeUpdate("insert into tabish values('YASH',160101331)");
            System.out.println("DELETED");
            
            String alert=new String("Congrats, You have successfully DELETED !");
            JOptionPane.showMessageDialog(null,alert );
            nametf.setText("");
            rolltf.setText("");
                
            con.close();
        }
        catch(ClassNotFoundException | SQLException e1)
        {
            System.out.println("hello6");
        }
            
           
        }
        else if(e.getSource()== backb)
        {
            new adminselectionpage();
            f.dispose();
            
        }
        else if(e.getSource()== exitb)
        {
            f.dispose();
            
        }
    }   
    public static void main(String args[])
    {
        //setDefaultLookAndFeelDecorated(true);
        new addstudentpage();
    }

    

   
    
}
