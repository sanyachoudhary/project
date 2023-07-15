package PhoneBook;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteContact extends JFrame implements ActionListener
{
    String x[]={"Id","Name","Nick Name","Phone","Mobile","Email","Address","Company","Position","Group Name"};
    JButton bt;
    String y[][]=new String[20][10];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    JLabel l1;
    JTextField tf;
    JPanel p1,p2;
    
    DeleteContact()
    {
        super("Contact information");
        setSize(800,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select * from add_contact";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("Id");   
                y[i][j++]=rest.getString("name");   
                y[i][j++]=rest.getString("nickname");  
                y[i][j++]=rest.getString("phone");  
                y[i][j++]=rest.getString("mobile");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("company");
                y[i][j++]=rest.getString("position");
                y[i][j++]=rest.getString("group_name");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        
        l1=new JLabel("Enter Contact ID for Delete");
        tf=new JTextField();
        bt=new JButton("Delete");

        bt.setBackground(Color.BLACK);
        bt.setForeground(Color.RED);
        
        bt.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf);
        p1.add(bt);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt)
        {
            int idno=Integer.parseInt(tf.getText());
            try
            {
                ConnectionClass obj1=new ConnectionClass();
                String q0="delete from add_contact where Id='"+idno+"'";
                int res=obj1.stm.executeUpdate(q0);
                
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null,"Your Contact Successfully deleted.");
                    this.setVisible(false);
                    new DeleteContact().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Your Contact Did not deleted.");
                    this.setVisible(false);
                    new DeleteContact().setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
        new DeleteContact().setVisible(true);
    }
}

