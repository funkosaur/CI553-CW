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
    private Font font = new Font("Monospaced",Font.BOLD,24);
    private int H = 300;         // Height of window
    private int W = 400;         // Width  of window
    private String textToDisplay = "";
    private AdvertisementController cont= null;

    private JLabel imageLabel;

    public AdvertisementView(RootPaneContainer rpc, int x, int y) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp         = rpc.getContentPane();    // Content Pane
        Container rootWindow = (Container) rpc;         // Root Window
        cp.setLayout( new BorderLayout() );             // Border N E S W CENTER
        rootWindow.setSize( W, H );                     // Size of Window
        rootWindow.setLocation( x, y );                 // Position on screen
        rootWindow.add( this, BorderLayout.CENTER );    //  Add to rootwindow

        rootWindow.setVisible( true );                  // Make visible

        imageLabel = new JLabel();
        getContentPane().add(imageLabel, BorderLayout.CENTER);

        pack();
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


