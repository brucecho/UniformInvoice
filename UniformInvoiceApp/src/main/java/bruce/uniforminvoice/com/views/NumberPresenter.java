package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import bruce.uniforminvoice.com.UniformInvoice;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class NumberPresenter {

    @FXML
    private View number;

    @FXML
    private ComboBox cbx_Number_SelMonth;
    
    @FXML
    private TextField text_Number_Month;
    
    @FXML
    private TextField text_Number_PriceNumberA;
    
    @FXML
    private TextField text_Number_PriceNumberB;
    
    @FXML
    private TextField text_Number_PriceNumberC;
    
    @FXML
    private TextField text_Number_PriceNumberD;
    
    @FXML
    private TextField text_Number_PriceNumberE;
    
    @FXML
    private TextField text_Number_PriceNumberF;
    
    @FXML
    private TextField text_Number_PriceNumberG;
    
    @FXML
    private TextField text_Number_PriceNumberH;
    
    @FXML
    private TextField text_Number_PriceNumberI;
    
    @FXML
    private TextField text_Number_Note;
    
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

        this.cbx_Number_SelMonth.getItems().addAll("106-1112","107-0102");
    }

    @FXML
    void cbx_Number_SelMonth_Select() {
        //label.setText(this.cbxMonth.getSelectionModel().getSelectedItem().toString());
    }

}
