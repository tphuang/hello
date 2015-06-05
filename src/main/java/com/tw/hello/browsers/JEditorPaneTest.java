package com.tw.hello.browsers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * use JEditorPane to show web pages
 * @author kwan4833
 */
public class JEditorPaneTest extends JFrame implements ActionListener,HyperlinkListener
{
    public final static long serialVersionUID=12345L;
    private JEditorPane jep=new JEditorPane();
    private JLabel label=new JLabel("输入网址:");
    private JTextField urlText=new JTextField();
    
    public JEditorPaneTest()
    {
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());
        
        JPanel north=new JPanel(new BorderLayout());
        north.add(label,BorderLayout.WEST);
        north.add(urlText,BorderLayout.CENTER);
        con.add(north,BorderLayout.NORTH);
        con.add(new JScrollPane(jep),BorderLayout.CENTER);
        
        urlText.addActionListener(this);
        jep.setContentType("text/html");
        jep.setEditable(false);
        jep.addHyperlinkListener(this);
        
        this.setTitle("JEditorPane test");
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
            try
            {
                jep.setPage(input);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void hyperlinkUpdate(HyperlinkEvent event)
    {
        if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
        {
            try
            {
                jep.setPage(event.getURL());
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }        
    }
    
    public static void main(String args[])
    {
        new JEditorPaneTest();
    }    
}
