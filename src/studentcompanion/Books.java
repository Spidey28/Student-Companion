/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.net.*;
/**
 *
 * @author acer
 */

public class Books implements ActionListener {
    JFrame f;
    JButton b1,b2,b3,b4,b5,back,off;
    JLabel l,l1;
    Books()
    {
        ImageIcon img_back=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Back.jpg");
        ImageIcon img_exit=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\Exit.jpg");
        ImageIcon img_sharda=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\sharda.jpg");
        ImageIcon img_books=new ImageIcon("C:\\Users\\acer\\Downloads\\Project\\books.jpg");
        f=new JFrame();
        back=new JButton(img_back);
        off=new JButton(img_exit);
        l=new JLabel(img_sharda);
        l1=new JLabel(img_books);
        b1=new JButton("ENGINEERING");
        b2=new JButton("MEDIA");
        b3=new JButton("LAW");
        b4=new JButton("B.SC.");
        b5=new JButton("BUSINESS");
        b1.addActionListener(this);
        back.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        off.addActionListener(this);
        b1.setFont(new Font("Serif", Font.BOLD, 20));
        b2.setFont(new Font("Serif", Font.BOLD, 20));
        b3.setFont(new Font("Serif", Font.BOLD, 20));
        b4.setFont(new Font("Serif", Font.BOLD, 20));
        b5.setFont(new Font("Serif", Font.BOLD, 20));
        off.setBounds(570, 0, 30, 30);
        back.setBounds(540,0,30,30);
        l.setBounds(0, 335, 600, 80);
        l1.setBounds(420,50,200,310);
        b1.setBounds(80,80,150,80);
        b2.setBounds(80,180,150,80);
        b3.setBounds(260,80,150,80);
        b4.setBounds(260,180,150,80);
        b5.setBounds(300,290,150,80);
        b1.setMargin(new Insets(0, 0, 0, 0));//To set text accordingly
        f.add(back);f.add(off);f.add(b1);f.add(b2);f.add(b3);
        f.add(b4);f.add(l);f.add(l1);
        
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
        
        if(e.getSource()==off)
            f.dispose();
        else if(e.getSource()==b1)
        {
            new BooksLink();
            f.dispose();
                       
        }
        else if(e.getSource()==back)
        {
           f.dispose();
           new startpage();
        }
        else
        {
                String alert=new String("Sorry, UNDER CONSTRUCTION !");

                JOptionPane.showMessageDialog(null,alert );
        }
    }
    public static void main(String args[])
    {
        new Books();
    }
    
}
