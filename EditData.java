package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EditData extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    Font f,f1;
    
    EditData()
    {
        
    }
    EditData(int idno)
    {
        super("Edit Contact");
        setLocation(450,50);
        setSize(450,650);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1=new JLabel("Update Contact");
        l2=new JLabel("Name");
        l3=new JLabel("Nick Name");
        l4=new JLabel("Phone No");
        l5=new JLabel("Mobile No");
        l6=new JLabel("Email Address");
        l7=new JLabel("Home Address");
        l8=new JLabel("Company");
        l9=new JLabel("Position");
        l10=new JLabel("Group Name");
        l11= new JLabel("ID");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
        tf9=new JTextField();
        tf10=new JTextField();
        
        bt1=new JButton("Edit Contact");
        bt2=new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(11,2,10,10));
        
        p2.add(l11);
        p2.add(tf10);
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l7);
        p2.add(tf6);
        p2.add(l8);
        p2.add(tf7);
        p2.add(l9);
        p2.add(tf8);
        p2.add(l10);
        p2.add(tf9);
        p2.add(bt1);
        p2.add(bt2);
        
        try
        {
            ConnectionClass obj1=new ConnectionClass();
            String q1="select * from add_contact where Id='"+idno+"'";
            ResultSet rest1=obj1.stm.executeQuery(q1);
            while(rest1.next())
            {
                tf10.setText(rest1.getString("Id"));
                tf1.setText(rest1.getString("name"));
                tf2.setText(rest1.getString("nickname"));
                tf3.setText(rest1.getString("phone"));
                tf4.setText(rest1.getString("mobile"));
                tf5.setText(rest1.getString("email"));
                tf6.setText(rest1.getString("address"));
                tf7.setText(rest1.getString("company"));
                tf8.setText(rest1.getString("position"));
                tf9.setText(rest1.getString("group_name"));
            }
        }
        catch(Exception exx)
        {
            exx.printStackTrace();
        }
        
        tf10.setEditable(false);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {        
        if(e.getSource()==bt1)
        {
            int Cid=Integer.parseInt(tf10.getText());
            String name=tf1.getText();
            String nickname=tf2.getText();
            String phone=tf3.getText();
            String mobile=tf4.getText();
            String email=tf5.getText();
            String address=tf6.getText();
            String company=tf7.getText();
            String position=tf8.getText();
            String groupname=tf9.getText();
            
            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q1="update add_contact set name='"+name+"',nickname='"+nickname+"',phone='"+phone+"',mobile='"+mobile+"',email='"+email+"',address='"+address+"',company='"+company+"',position='"+position+"',group_name='"+groupname+"' where Id='"+Cid+"'";
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "your data successfully updated");
                    this.setVisible(false);
                    new SearchDatatableForEdit(name).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Plese!, Fill all details carefully");
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String[] args) 
    {
        new EditData().setVisible(true);
    }
}
