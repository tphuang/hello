package com.tw.hello.browsers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

import org.lobobrowser.gui.FramePanel;
import org.lobobrowser.main.PlatformInit;

/**
* use lobo to render
* @author kwan4833
*/
public class LoboBrowserTest extends JFrame implements ActionListener
{
    public final static long serialVersionUID=12345L;
    private JLabel label=new JLabel("输入网址：");
    private JTextField urlText=new JTextField();
    private FramePanel browser=new FramePanel();

    public LoboBrowserTest()
    {
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());

        JPanel north=new JPanel(new BorderLayout());
        north.add(label,BorderLayout.WEST);
        north.add(urlText,BorderLayout.CENTER);
        con.add(north,BorderLayout.NORTH);
        con.add(new JScrollPane(browser),BorderLayout.CENTER);

        urlText.addActionListener(this);

        this.setTitle("Lobo Browser test");
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
                browser.navigate(input);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])throws Exception
    {
        PlatformInit.getInstance().initLogging(false);
        PlatformInit.getInstance().init(false, false);
        new LoboBrowserTest();
    }
}
