package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class ScanCheckView extends PresenterFather{

    private final String name;

    public ScanCheckView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(ScanCheckView.class.getResource("scanCheck.fxml"));
            view.setName(name);
            return view;
        } catch (IOException error) {
            ShowDialog(error.getMessage());
            return new View(name);
        }
    }
}
