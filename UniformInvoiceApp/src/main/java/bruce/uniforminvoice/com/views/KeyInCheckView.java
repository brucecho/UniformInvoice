package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class KeyInCheckView extends PresenterFather{

    private final String name;

    public KeyInCheckView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(KeyInCheckView.class.getResource("keyinCheck.fxml"));
            view.setName(name);
            return view;
        } catch (IOException error) {
            ShowDialog(error.getMessage());
            return new View(name);
        }
    }
}
