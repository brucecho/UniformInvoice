/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.control.Dialog;
import javafx.scene.control.Button;

/**
 *
 * @author bruce
 */
public class PresenterFather {
    public Dialog MessageDialog;

    public PresenterFather() {
        MessageDialog = new Dialog();
        MessageDialog.setTitleText("Message");
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            MessageDialog.hide();
        });
        MessageDialog.getButtons().add(okButton);
    }
    
    public void ShowDialog(String strMessage) {
        MessageDialog.setContentText(strMessage);
        MessageDialog.showAndWait();
    }
}
