/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion; //image set karni hai 

import java.awt.Color;
import java.awt.Insets;
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
public class BooksLink2 implements ActionListener {

    static String Selected_book;
    ResultSet rec;
    JFrame f;
    JComboBox cb;
    JTextField searchtf;
    JButton exitb,backb,bsearch,gotolink;
    JLabel sharda,notfound;
    String codedb;
    String code;
    BooksLink2(){
        ImageIcon img_back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg ");
        ImageIcon img_exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Exit.jpg");
        ImageIcon img_sharda=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\sharda.jpg");
        ImageIcon img_go=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\go.jpg");
        
        f=new JFrame();
        searchtf=new JTextField();
        exitb=new JButton(img_exit);
        backb=new JButton(img_back);
        bsearch=new JButton(img_go);
        gotolink=new JButton("Go To Link");
        sharda=new JLabel(img_sharda);
        
        exitb.addActionListener(this);
        backb.addActionListener(this);
        bsearch.addActionListener(this);
        gotolink.addActionListener(this);
        
        searchtf.setBounds(50,160,100,30);
        exitb.setBounds(570, 0, 30, 30);
        backb.setBounds(540, 0, 30, 30);
        bsearch.setBounds(150,160,30,30);
        gotolink.setBounds(300,210,100,30); //   cb.setBounds(300, 150, 200, 50);
        gotolink.setMargin(new Insets(0, 0, 0, 0));
        sharda.setBounds(0,335,600,80);
        
        f.add(searchtf);
        f.add(exitb);
        f.add(bsearch);
        f.add(backb);
       // f.add(gotolink);
        f.add(sharda);
        
       
        f.setUndecorated(true);
        f.setBackground(new Color(0,0,0,220));
        f.setSize(600,400);
        
        f.setLayout(null);

        f.setLocationRelativeTo(null);

       

        f.setVisible(true);

       

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setResizable(false);
        
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
            //Statement st = conn.createStatement();
            PreparedStatement prst=conn.prepareStatement("select * from books");
            rec = prst.executeQuery();
            
        }catch(Exception e){}
        
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
            new Books();
            f.dispose();
        }
        else if(e.getSource()==bsearch)
        {
            
            int flag=0;
            code=searchtf.getText();
            cb=new JComboBox();
            cb.addActionListener(this);
            cb.setBounds(300, 150, 200, 50);
            f.add(cb);
            f.add(gotolink);
            try{
                
                while(rec.next())
                {
                    
                    codedb=rec.getString(2);
                    if(code.equals(codedb))
                    {
                        flag=1;
                        while(rec.next())
                        {
                            cb.addItem(rec.getString(1));
                        }
                    }
                    
                }
                
            }catch(Exception x){}
            /*try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
                //Statement st = conn.createStatement();
                PreparedStatement prst=conn.prepareStatement("select * from books");
                ResultSet rec = prst.executeQuery();
                while(rec.next())
                {
                    String codedb=rec.getString(2);
                    if(code.equals(codedb))
                    {
                        flag=1;
                        while(rec.next())
                        {
                            cb.addItem(rec.getString(1));
                        }
                    }
                }
                
                e.getSource()==gotolink)
                {
                    //new BooksLink2();
                    f.dispose();
                }
                    
                    if(code.equals(codedb))
                    {
                        System.out.println("Gya");
                        flag=1;
                        System.out.println("Flag set");
                    }
                }
                if(flag==1)
                {
                    System.out.println("jjjj");
                    f.add(cb);
                    while(rec.next())
                    { 
                        System.out.println("Mila");
                        cb.addItem(rec.getString(1));
                        System.out.println("Books");
                    }
                }
                else if(flag==0)
                            {
                            System.out.println("Not Found");
                            }
            }catch(Exception x){}*/
            
        }
        else if(e.getSource()==gotolink)
        {
            new Download2_1();
            //Selected_book=cb.getSelectedItem().toString();
            System.out.println(Selected_book);
            
            f.dispose();
        }
        Selected_book=cb.getSelectedItem().toString();
        
    }
    
    public static void main(String args[])
    {
        new BooksLink();
    }
    private void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
