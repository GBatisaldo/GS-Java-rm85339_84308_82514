package main.java.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String url) {
        super(new GridBagLayout());
        try {
            image = ImageIO.read(new URL(url));
            JLabel label = new JLabel(new ImageIcon(image));
            add(label);
            setOpaque(true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, this);
//    }
}
