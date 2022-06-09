package main.java.views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MapOptionPane extends WindowAdapter {
    JFrame frame;

    public MapOptionPane(String lat, String log) {
        frame = new JFrame();
        frame.addWindowListener(this);
        frame.setSize(250, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void windowClosing(WindowEvent e) {
        int res = JOptionPane.showConfirmDialog(frame,"Are you sure?");
        if(res == JOptionPane.YES_OPTION)
        {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
