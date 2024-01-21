package clients.advertisement;

import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementClient {

    public static void main (String args[])
    {
        String stockURL = args.length < 1     // URL of stock RW
                ? Names.STOCK_RW      //  default  location
                : args[0];            //  supplied location
        String orderURL = args.length < 2     // URL of order
                ? Names.ORDER         //  default  location
                : args[1];            //  supplied location

        RemoteMiddleFactory mrf = new RemoteMiddleFactory();
        mrf.setStockRWInfo( stockURL );
        mrf.setOrderInfo  ( orderURL );        //
        displayAd();                       // Create GUI
    }

    public static void displayAd() {

        JFrame  window = new JFrame();

        window.setTitle( "Pick Client MVC");
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        SwingUtilities.invokeLater(() -> {
            List<BufferedImage> images = loadImages();
            AdvertisementModel model = new AdvertisementModel(images);
            AdvertisementView view = new AdvertisementView(window, 0, 0);
            AdvertisementController controller = new AdvertisementController(model, view);
        });
    }

    private static List<BufferedImage> loadImages() {
        // Implement a method to load your images
        // Example: BufferedImage image1 = loadImage("path/to/image1.jpg");
        //          BufferedImage image2 = loadImage("path/to/image2.jpg");
        //          List<BufferedImage> images = new ArrayList<>();
        //          images.add(image1);
        //          images.add(image2);
        //          return images;
        return new ArrayList<>();
    }
}