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


/**
 *
 * @author rowdy
 */
public class studentselectionpage implements ActionListener
{
    JFrame f;
    JButton exitb,backb,bookb,accomb,restrb,messb,addstdntb;
    JLabel stdntimg,wlcm,shrdalogo,wlcm1;

    public studentselectionpage() 
    {
        f=new JFrame();
        
        ImageIcon exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\exit.jpg");
        ImageIcon back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon stdntpic=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\studentlogo.jpg");
        ImageIcon shardalogo= new ImageIcon("C:\\Users\\rowdy\\Pictures\\Saved Pictures\\shardalogo.jpg");
        
        exitb=new JButton(exit);
        backb=new JButton(back);
        bookb=new JButton("<html>BOOKS/ONLINE <br/>STUDY POINTS</html>");
        accomb=new JButton("ACCOMODATION");
        restrb=new JButton("RESTAURANTS");
        messb=new JButton("<html>MESS/TIFFIN <br/>SERVICES</html>");
        //addstdntb=new JButton("<html>ADD <br/>STUDENTs <br/>IN THE <br/>DATABASE</html>");
        
        stdntimg=new JLabel(stdntpic);
        wlcm=new JLabel("Welcome");
        shrdalogo=new JLabel(shardalogo);
        wlcm1=new JLabel(startpage.str1);
        
        exitb.setBounds(670, 0, 30, 30);
        backb.setBounds(640, 0 ,30 ,30 );
        bookb.setBounds(50,100 ,150 ,80 );
        accomb.setBounds(250,100 ,150 ,80 );
        restrb.setBounds(50,250 ,150 ,80 );
        messb.setBounds(250,250 ,150 ,80 );
        //addstdntb.setBounds(500,120 ,150 ,190);
        
        stdntimg.setBounds(480, 50,150,300);
        wlcm.setBounds(50, 10, 100, 50);
        wlcm1.setBounds(135, 10, 150, 50);
        shrdalogo.setBounds(0, 335, 700, 80);
   
        
        wlcm.setForeground(Color.white);
        wlcm1.setForeground(Color.white);
        wlcm.setFont(new Font("Serif", Font.BOLD, 20));
        wlcm1.setFont(new Font("Serif", Font.BOLD, 20));
        //accomb.setForeground(Color.white);
        //accomb.setFont(new Font("Serif", Font.BOLD, 20));        
               
        exitb.addActionListener(this);
        backb.addActionListener(this);
        bookb.addActionListener(this);
        
        f.add(exitb);
        f.add(backb);
        f.add(bookb);
        f.add(accomb);
        f.add(restrb);
        f.add(messb);
        //f.add(addstdntb);
        f.add(stdntimg);
        f.add(wlcm);
        f.add(wlcm1);
        f.add(shrdalogo);
        
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setSize(700,400);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== exitb)
        {
            f.dispose();
        }
        else if(e.getSource()== backb)
        {
           new startpage();
           f.dispose();
        }
        else if(e.getSource()==bookb)
        {
            new Books();
            f.dispose();
        }
    }   
    public static void main(String args[])
    {
        new studentselectionpage();
    }
    
    
}
