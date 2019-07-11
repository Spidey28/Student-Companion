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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author rowdy
 */
public class addbookpage implements ActionListener
{
    JFrame f;
    JButton addb,backb,exitb;
    JTextField nametf,subjtf,authortf;
    JLabel namel,subjl,authorl,shrdalogo;
    
    public addbookpage()
    {
        f=new JFrame();
        ImageIcon shardalogo= new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\sharda.jpg");
        ImageIcon back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\exit.jpg");
        shrdalogo=new JLabel(shardalogo);
        shrdalogo.setBounds(0, 170, 700, 80);
        namel=new JLabel("BOOK NAME:-");
        namel.setBounds(50, 50, 150, 30);
        nametf=new JTextField("FILL IN CAPITAL LETTERS ONLY");
        nametf.setBounds(250, 50, 200, 30);
        
        namel.setForeground(Color.white);
        namel.setFont(new Font("Serif", Font.BOLD, 20));
        
        subjl=new JLabel("SUBJECT CODE:-");
        subjl.setBounds(50, 90, 180, 30);
        subjtf=new JTextField("FILL IN CAPITAL LETTERS ONLY");
        subjtf.setBounds(250, 90, 200, 30);
        
        subjl.setForeground(Color.white);
        subjl.setFont(new Font("Serif", Font.BOLD, 20));
        
        authorl=new JLabel("LINK:-");
        authorl.setBounds(50, 130, 150, 30);
        authorl.setForeground(Color.white);
        authorl.setFont(new Font("Serif", Font.BOLD, 20));
        authortf=new JTextField("FILL IN CAPITAL LETTERS ONLY");
        authortf.setBounds(250, 130, 200, 30);
        
        
        addb=new JButton("Add");
        addb.setBounds(500, 55, 150, 100);
        //deleteb=new JButton("<html>D<br/>e<br/>l<br/>e<br/>t<br/>e</html>");
        //deleteb.setBounds(620, 30, 40, 100);
        backb=new JButton(back);
        backb.setBounds(30, 0, 30, 30);
        exitb=new JButton(exit);
        exitb.setBounds(0, 0, 30, 30);
        //orl=new JLabel("OR");
        //orl.setBounds(565, 65, 30, 30);
        //orl.setForeground(Color.white);
        //orl.setFont(new Font("Serif", Font.BOLD, 20));
        f.add(authorl);
        f.add(authortf);
        //f.add(orl);
        //f.add(deleteb);
        f.add(addb);
        f.add(backb);
        f.add(exitb);
        f.add(shrdalogo);
        f.add(namel);
        f.add(nametf);
        f.add(subjl);
        f.add(subjtf);
        f.setSize(700, 240);
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        addb.addActionListener(this);
        backb.addActionListener(this);
        exitb.addActionListener(this);
        subjtf.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent ee)
            {
                subjtf.setText("");
            }
            @Override
            public void mousePressed(MouseEvent ae){}
            @Override
            public void mouseReleased(MouseEvent aee){}
            @Override
            public void mouseEntered(MouseEvent eee){}
            @Override
            public void mouseExited(MouseEvent aeee){}
        });
        
        nametf.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent ee)
            {
                nametf.setText("");
            }
            @Override
            public void mousePressed(MouseEvent ae){}
            @Override
            public void mouseReleased(MouseEvent aee){}
            @Override
            public void mouseEntered(MouseEvent eee){}
            @Override
            public void mouseExited(MouseEvent aeee){}
        });
        
        authortf.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent ee)
            {
                authortf.setText("");
            }
            @Override
            public void mousePressed(MouseEvent ae){}
            @Override
            public void mouseReleased(MouseEvent aee){}
            @Override
            public void mouseEntered(MouseEvent eee){}
            @Override
            public void mouseExited(MouseEvent aeee){}
        });
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addb)
        {
            String namestr=nametf.getText();
            String subjstr=subjtf.getText();
            String authorstr=authortf.getText();
            System.out.println(authorstr);
            
            try
        {
            System.out.println("hello1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("hello2");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
            System.out.println("hello3");
            Statement stmt=con.createStatement();
            System.out.println("hello4");
            
           
            stmt.executeUpdate("insert into books values('"+namestr+"','"+subjstr+"','"+authorstr+"')");
           
            System.out.println("INSERTED");
            
            String alert=new String("Congrats, You have successfully ADDED !");
            JOptionPane.showMessageDialog(null,alert );
            nametf.setText("");
            subjtf.setText("");
            authortf.setText("");
            
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
        else if(e.getSource()==exitb)
        {
            f.dispose();
        }
    }
    
    
    public static void main(String args[])
    {
        //setDefaultLookAndFeelDecorated(true);
        new addbookpage();
    }
    

   
    
    
}

