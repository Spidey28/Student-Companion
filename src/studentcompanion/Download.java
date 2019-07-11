/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;
import java.awt.Desktop;
import java.net.URI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author acer
 */
public class Download implements ActionListener{
    JFrame f;
    JButton likeb,dislikeb,downloadb,exitb,backb;
    JLabel like,dislike,up,down,book,or;//sharda;
    ResultSet rec;
    int count,dcount;
    static String book_name=BooksLink.Selected_book;
    Download()
    {
        //System.out.println(book_name);
        ImageIcon img_back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon img_exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Exit.jpg");
        ImageIcon img_sharda=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\th1 - Copy.jpg");
        ImageIcon img_like=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\like.jpg");
        ImageIcon img_dislike=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\dislike.jpg");
        f=new JFrame();
        likeb=new JButton("Like");
        dislikeb=new JButton("Dislike");
        downloadb=new JButton("Download");
        exitb=new JButton(img_exit);
        backb=new JButton(img_back);
        //sharda=new JLabel(img_sharda);
        
        likeb.addActionListener(this);
        dislikeb.addActionListener(this);
        downloadb.addActionListener(this);
        exitb.addActionListener(this);
        backb.addActionListener(this);
        
        like=new JLabel();
        dislike=new JLabel();
        up=new JLabel(img_like);
        down=new JLabel(img_dislike);
        book=new JLabel(book_name);
        or=new JLabel("OR");
        
        book.setBounds(50, 10, 150, 50);
        up.setBounds(50,90,80, 50);
        like.setBounds(150, 90, 80, 50);
        or.setBounds(240,90,50,50);
        down.setBounds(310, 90, 80, 50);
        dislike.setBounds(410, 90, 80, 50);
        //sharda.setBounds(0, 335, 700, 80);
        
        exitb.setBounds(670, 0, 30, 30);
        backb.setBounds(640, 0, 30, 30);
        likeb.setBounds(50,170,150,50);
        dislikeb.setBounds(260, 170, 150, 50);
        
        downloadb.setBounds(160, 260, 150, 50);
        
        downloadb.setFont(new Font("Serif", Font.BOLD, 20));
        book.setFont(new Font("Serif", Font.BOLD, 20));
        likeb.setFont(new Font("Serif", Font.BOLD, 20));
        dislikeb.setFont(new Font("Serif", Font.BOLD, 20));
        book.setForeground(Color.white);
        
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setSize(700,400);
        
        
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        
        //f.add(sharda);
        f.add(book);
        f.add(likeb);
        f.add(dislikeb);
        f.add(downloadb);
        f.add(exitb);
        f.add(backb);
        f.add(up);
        f.add(down);
        f.add(like);
        f.add(dislike);
        
        
        like.setText(String.valueOf(count));
        dislike.setText(String.valueOf(dcount));
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exitb)
        {
            f.dispose();
        }
        else if(e.getSource()==backb)
        {
            new BooksLink();
            f.dispose();
        }
        else if(e.getSource()==likeb)
        {
            try{
                System.out.println("hello1");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("hello2");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
                System.out.println("hello3");
                //Statement st = conn.createStatement();
                PreparedStatement prst=conn.prepareStatement("select * from feeds");
                System.out.println("hello4");
                rec=prst.executeQuery();
         
                
                while(rec.next())
                {
                    String book_namedb=rec.getString(1);
                    System.out.println(book_namedb);
                    System.out.println("hello5");
                    if(book_name==(book_namedb))
                    {
                        System.out.println("hello6");
                        count=Integer.parseInt(rec.getString(2));
                        count++;
                        prst.executeUpdate("update feeds set likes=count where feeds.name=book_name");
                        System.out.println("hello7");
                        break;
                    }
                }
                
                
                
            }catch(Exception x){}
        }
        else if(e.getSource()==dislikeb)
        {
             try{
                 System.out.println("hello8");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("hello9");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
                System.out.println("hello10");
                //Statement st = conn.createStatement();
                PreparedStatement prst=conn.prepareStatement("select * from feeds");
                System.out.println("hello11");
                rec=prst.executeQuery();
         
                
                while(rec.next())
                {
                    System.out.println("hello12");
                    String book_namedb=rec.getString(1);
                    System.out.println("hello13");
                    if(book_name.equals(book_namedb))
                    {
                        System.out.println("hello14");
                        dcount=Integer.parseInt(rec.getString(3));
                        System.out.println("hello int");
                        dcount++;
                        prst.executeUpdate("update feeds set dislikes=dcount where feeds.name=book_name");
                        System.out.println("hello15");
                        break;
                    }
                }
                
                
                
            }catch(Exception x){}
        }
        else if(e.getSource()==downloadb)
        {
            try{
                System.out.println("hello16");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("hello17");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
                //Statement st = conn.createStatement();
                System.out.println("hello18");
                PreparedStatement prst=conn.prepareStatement("select link from books where books.name='book_name'");
                System.out.println("hello19");
                rec=prst.executeQuery();
                if(Desktop.isDesktopSupported()){
                    
                    Desktop.getDesktop().browse(new URI(String.valueOf(rec)));
                    System.out.println("hello20");
                }
                    
            }catch(Exception x){}
        }
        
    }
    public static void main(String args[])
    {
        System.out.println(book_name);
        new Download();
    }
    private void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
