package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchDatatableForEdit extends JFrame implements ActionListener
{
    String x[]={"Id","Name","NIck Name","Phone","Mobile","Email","Address","Comapny","Position","Group Name"};
    String y[][]=new String[20][10];
    int i=0,j=0;
    JTable t;
    Font f;
    JLabel l1;
    JButton bt1;
    JTextField tf1;
    JPanel p1;
    SearchDatatableForEdit()
    {
        
    }
    SearchDatatableForEdit(String name1)
    {
        super("Contact Information");
        setLocation(1,1);
        setSize(800,400);
        
        f=new Font("Arial",Font.BOLD,14);
        try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from add_contact where name='"+name1+"'";
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
        
        l1=new JLabel("Enter Contact Id");
        tf1=new JTextField();
        bt1=new JButton("Edit");
        
        bt1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        int idno=Integer.parseInt(tf1.getText());
        
        if(e.getSource()==bt1)
        {
            new EditData(idno).setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) 
    {
        new SearchDatatableForEdit("aman").setVisible(true);
    }
}
