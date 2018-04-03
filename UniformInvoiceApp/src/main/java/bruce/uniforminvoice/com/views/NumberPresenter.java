package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import bruce.uniforminvoice.com.UniformInvoice;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class NumberPresenter {

    @FXML
    private View number;

    @FXML
    private ComboBox cbxMonth;
    
    @FXML
    private Label label;

    public void initialize() {
        number.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e
                        -> MobileApplication.getInstance().showLayer(UniformInvoice.MENU_LAYER)));
                appBar.setTitleText("Number");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e
                        -> System.out.println("Search")));
                appBar.setVisible(false);
            }
        });

        this.cbxMonth.getItems().addAll("106-1112","107-0102");
    }

    @FXML
    void cbxMonthSelect() {
        label.setText(this.cbxMonth.getSelectionModel().getSelectedItem().toString());
    }

}
