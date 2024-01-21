package clients.advertisement;


import clients.advertisement.AdvertisementModel;
import clients.advertisement.AdvertisementView;

/**
 * The BackDoor Controller
 * @author M A Smith (c) June 2014
 */
public class AdvertisementController {

    private AdvertisementModel model;
    private AdvertisementView view;

    public AdvertisementController(AdvertisementModel model, AdvertisementView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        model.addObserver(view);
        view.setVisible(true);
    }
}

