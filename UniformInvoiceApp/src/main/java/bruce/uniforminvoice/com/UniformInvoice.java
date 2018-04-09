package bruce.uniforminvoice.com;

import bruce.uniforminvoice.com.views.NumberView;
import bruce.uniforminvoice.com.views.KeyInCheckView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class UniformInvoice extends MobileApplication {

    public static final String NUMBER_VIEW = HOME_VIEW;
    public static final String KEYINCHECK_VIEW = "KeyInCheck View";
    public static final String SCANCHECK_VIEW = "ScanCheck View";
    public static final String STOREINVOICE_VIEW = "StoreInvoice View";
    public static final String MENU_LAYER = "Side Menu";

    @Override
    public void init() {
        addViewFactory(NUMBER_VIEW, () -> new NumberView(NUMBER_VIEW).getView());
        addViewFactory(KEYINCHECK_VIEW, () -> new KeyInCheckView(KEYINCHECK_VIEW).getView());
        addViewFactory(SCANCHECK_VIEW, () -> new KeyInCheckView(SCANCHECK_VIEW).getView());
        addViewFactory(STOREINVOICE_VIEW, () -> new KeyInCheckView(STOREINVOICE_VIEW).getView());

        addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);
        scene.getStylesheets().add(UniformInvoice.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(UniformInvoice.class.getResourceAsStream("/icon.png")));
    }
}
