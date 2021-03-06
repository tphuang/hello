package com.tw.hello.github.drxaos.samples;


import java.awt.*;
import java.net.URL;
import javax.swing.*;

import com.tw.hello.github.drxaos.browser.FxBrowser;
import com.tw.hello.github.drxaos.browser.WebAppURLStreamHandlerFactory;

public class Sample1 {

    public static void main(String... args) {
        URL.setURLStreamHandlerFactory(new WebAppURLStreamHandlerFactory(Sample1.class));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setBackground(Color.red);

                JPanel panel = new JPanel();
                panel.setBackground(Color.blue);
                panel.setLayout(new BorderLayout());

                FxBrowser webView = new FxBrowser("https://www.baidu.com");
                panel.add(webView, BorderLayout.CENTER);

                JButton button = new JButton("Reload");
                panel.add(button, BorderLayout.SOUTH);


                frame.getContentPane().add(panel);

                frame.setMinimumSize(new Dimension(640, 480));
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
