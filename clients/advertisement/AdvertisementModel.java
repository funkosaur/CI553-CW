package clients.advertisement;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Observable;

public class AdvertisementModel extends Observable {


    private List<BufferedImage> images;
    private int currentIndex = 0;

    public AdvertisementModel(List<BufferedImage> images) {
        this.images = images;
        startImageCycler();
    }

    private void startImageCycler() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(4000);
                    currentIndex = (currentIndex + 1) % images.size();
                    setChanged();
                    notifyObservers(images.get(currentIndex));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
