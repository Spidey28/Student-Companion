package studentcompanion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.*;
import java.net.URI;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentcompanion.BooksLink;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**_
 *
 * @author acer
 */
public class Download2_1 implements ActionListener {
    JFrame f;
    JLabel bname,bcode,sharda,bimg;
    JButton exit,back,download;
    ResultSet rec;
    String link;
    Download2_1()
    {
        ImageIcon img_back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon img_exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Exit.jpg");
        ImageIcon img_sharda=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\th1 - Copy.jpg");
        ImageIcon img_books=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\books.jpg");
        f=new JFrame();
        bname=new JLabel(BooksLink.Selected_book);
        bname.setBounds(50, 50, 300, 50);
        bname.setForeground(Color.white);
        bcode=new JLabel();
        bcode.setBounds(150, 140, 100, 50);
        sharda=new JLabel(img_sharda);
        sharda.setBounds(0,335,600,80);
        bimg=new JLabel(img_books);
        bimg.setBounds(400, 50, 200, 300);
        exit=new JButton(img_exit);
        exit.setBounds(570, 0, 30, 30);
        back=new JButton(img_back);
        back.setBounds(540,0,30,30);
        download=new JButton("DOWNLOAD");
        download.setBounds(150,220,150,50);
        download.setMargin(new Insets(0, 0, 0, 0));
        bname.setFont(new Font("Serif", Font.BOLD, 20));
        bcode.setFont(new Font("Serif", Font.BOLD, 20));
        download.setFont(new Font("Serif", Font.BOLD, 20));
        
        download.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);
        
        
        try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
                //Statement st = conn.createStatement();
                PreparedStatement prst=conn.prepareStatement("select * from Books");
                rec = prst.executeQuery();
                
                while(rec.next())
                {
                    String codedb=rec.getString(1);
                    if(BooksLink.Selected_book.equals(codedb))
                    {
                        
                        bcode.setText(rec.getString(2));
                        bcode.setForeground(Color.white);
                        
                        link=rec.getString(3);
                    }
                    
                }
                

        }catch(Exception x){}
        
        f.add(download);
        f.add(exit);
        f.add(back);
        f.add(sharda);
        f.add(bimg);
        f.add(bcode);
        f.add(bname);
        
         
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setSize(600,400);
        
        f.setLayout(null);

        f.setLocationRelativeTo(null);

       

        f.setVisible(true);

       

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setResizable(false);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            new BooksLink();
            f.dispose();
        }
        else if(e.getSource()==exit)
        {
            f.dispose();
        }
        else if(e.getSource()==download)
        {
            System.out.println("Enter");
             if (Desktop.isDesktopSupported())
             {
                 System.out.println("Hello3"); 
                try {
                    Desktop.getDesktop().browse(new URI(link));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Download2_1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Download2_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                            System.out.println("Hello4");
             }
            /* try{
                while(rec.next())
                {
                    System.out.println("INNER");
                    String codedb=rec.getString(1);
                    System.out.println("Almost");;
                    if(BooksLink.Selected_book.equals(codedb))
                    {
                        System.out.println("Hello1");
                        String link=rec.getString(3);
                        System.out.println("Hello2");
                        System.out.println(link);
                         if (Desktop.isDesktopSupported())
                         {
                            System.out.println("Hello3"); 
                            Desktop.getDesktop().browse(new URI(link));
                            System.out.println("Hello4");
                         }
                    }
                }
            }catch(Exception m){}*/
        }
    }
    /*public static void main(String args[])
    {
        new Download2_1();
    }*/
    
}
