package com.tw.hello.browsers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.jdic.web.BrTabbed;

/**
* use JDIC browse
* @author kwan4833
*
*/
public class JDICBrowserTest extends JFrame implements ActionListener
{
    public final static long serialVersionUID=12345L;
    private JLabel label=new JLabel("输入网址：");
    private JTextField urlText = new JTextField();
    private BrTabbed browser = new BrTabbed();

    public JDICBrowserTest()
    {
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());

        JPanel north=new JPanel(new BorderLayout());
        north.add(label,BorderLayout.WEST);
        north.add(urlText,BorderLayout.CENTER);
        con.add(north,BorderLayout.NORTH);
        con.add(new JScrollPane(browser),BorderLayout.CENTER);

        urlText.addActionListener(this);

        this.setTitle("JDIC Browser test");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==urlText)
        {
            String input=urlText.getText().trim();
            if(input.length()==0)return;
            if(!input.startsWith("http://"))
            {
                input="http://"+input;
                urlText.setText(input);
            }
            browser.setURL(input);
        }
    }

    public static void main(String args[])
    {
        org.jdic.web.BrComponent.DESIGN_MODE = false;
        new JDICBrowserTest();
    }
}
