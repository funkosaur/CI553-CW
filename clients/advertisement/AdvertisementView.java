package clients.advertisement;

import clients.shopDisplay.DisplayController;
import middle.MiddleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class AdvertisementView extends JFrame implements Observer {

    private static final long serialVersionUID = 1L;
    private int H = 300;         // Height of window
    private int W = 400;         // Width  of window
    private String textToDisplay = "";
    private AdvertisementController cont= null;

    private JLabel imageLabel;

    public AdvertisementView(RootPaneContainer rpc, int x, int y) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new BorderLayout() );                // Border Layout for this frame
        setSize( W, H );                               // Size of this frame
        setLocation( x, y );                            // Position of this frame on screen
        setVisible( true );                                // Make this frame visible
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);
    }


    public void setController( AdvertisementController c )
    {
        cont = c;
    }
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof BufferedImage) {
            BufferedImage newImage = (BufferedImage) arg;
            imageLabel.setIcon(new ImageIcon(newImage));
            revalidate();
            repaint();
        }
    }
}


