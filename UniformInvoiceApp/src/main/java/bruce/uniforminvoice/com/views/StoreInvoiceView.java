package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class StoreInvoiceView extends PresenterFather{

    private final String name;

    public StoreInvoiceView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(StoreInvoiceView.class.getResource("storeInvoice.fxml"));
            view.setName(name);
            return view;
        } catch (IOException error) {
            ShowDialog(error.getMessage());
            return new View(name);
        }
    }
}
