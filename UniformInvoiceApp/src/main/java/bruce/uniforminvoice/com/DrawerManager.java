package bruce.uniforminvoice.com;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LifecycleService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import static bruce.uniforminvoice.com.UniformInvoice.MENU_LAYER;
import static bruce.uniforminvoice.com.UniformInvoice.NUMBER_VIEW;
import static bruce.uniforminvoice.com.UniformInvoice.KEYINCHECK_VIEW;
import static bruce.uniforminvoice.com.UniformInvoice.SCANCHECK_VIEW;
import static bruce.uniforminvoice.com.UniformInvoice.STOREINVOICE_VIEW;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class DrawerManager {

    private final NavigationDrawer drawer;

    public DrawerManager() {
        this.drawer = new NavigationDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Mobile",
                "Multi View Project",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item numberItem = new ViewItem("中獎號碼", MaterialDesignIcon.HOME.graphic(), NUMBER_VIEW, ViewStackPolicy.SKIP);
        final Item keyinCheckItem = new ViewItem("輸入兌獎", MaterialDesignIcon.DASHBOARD.graphic(), KEYINCHECK_VIEW);
        final Item scanCheckItem = new ViewItem("掃描兌獎", MaterialDesignIcon.DASHBOARD.graphic(), SCANCHECK_VIEW);
        final Item storeinvoiceItem = new ViewItem("記憶發票", MaterialDesignIcon.DASHBOARD.graphic(), STOREINVOICE_VIEW);
        drawer.getItems().addAll(numberItem, keyinCheckItem,scanCheckItem,storeinvoiceItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
        
        drawer.addEventHandler(NavigationDrawer.ITEM_SELECTED, 
                e -> MobileApplication.getInstance().hideLayer(MENU_LAYER));
        
        MobileApplication.getInstance().viewProperty().addListener((obs, oldView, newView) -> updateItem(newView.getName()));
        updateItem(NUMBER_VIEW);
    }
    
    private void updateItem(String nameView) {
        for (Node item : drawer.getItems()) {
            if (item instanceof ViewItem && ((ViewItem) item).getViewName().equals(nameView)) {
                drawer.setSelectedItem(item);
                break;
            }
        }
    }
    
    public NavigationDrawer getDrawer() {
        return drawer;
    }
}
