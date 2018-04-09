package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import bruce.uniforminvoice.com.UniformInvoice;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NumberPresenter extends PresenterFather {

    @FXML
    private View number;

    @FXML
    private ComboBox cbx_Number_SelMonth;

    @FXML
    private TextField text_Number_Month;

    @FXML
    private TextField text_Number_SpecialPrize;

    @FXML
    private TextField text_Number_GrandPrize;

    @FXML
    private TextArea text_Number_FirstPrize;

    @FXML
    private TextField text_Number_AddSixPrize;

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
//                appBar.setVisible(false);
            }
        });

        this.cbx_Number_SelMonth.getItems().addAll("106-1112", "107-0102");
    }

    @FXML
    void cbx_Number_SelMonth_Select() {
        try {
            String strSelMonth = cbx_Number_SelMonth.getSelectionModel().getSelectedItem().toString();
            String strURL = "https://www.etax.nat.gov.tw/etw-main/web/ETW183W2_";
            if (strSelMonth == null || strSelMonth.trim().length() == 0) {
                ShowDialog("請選擇月份");
                return;
            } else {
                strURL += strSelMonth.substring(0, 3) + strSelMonth.substring(4, 6) + "/";
            }
            Document doc = Jsoup.connect(strURL).timeout(10000).validateTLSCertificates(false).get();

            Elements domInURL = doc.getAllElements();
            String strMonths = "";
            String strSpecialPrize = "";
            String strGrandPrize = "";
            String strFirstPrize = "";
            String strAddSixPrize = "";
            for (Element tempElement : domInURL) {
                Attributes atris = tempElement.attributes();
                if (atris.hasKey("headers") && atris.hasKey("class")) {
                    if (atris.get("headers").equals("months") && atris.get("class").equals("title")) {
                        strMonths = tempElement.text();
                        continue;
                    }
                }
                if (atris.hasKey("headers") && atris.hasKey("class")) {
                    if (atris.get("headers").equals("specialPrize") && atris.get("class").equals("number")) {
                        strSpecialPrize = tempElement.text();
                        continue;
                    }
                }
                if (atris.hasKey("headers") && atris.hasKey("class")) {
                    if (atris.get("headers").equals("grandPrize") && atris.get("class").equals("number")) {
                        strGrandPrize = tempElement.text();
                        continue;
                    }
                }
                if (atris.hasKey("headers") && atris.hasKey("class")) {
                    if (atris.get("headers").equals("firstPrize") && atris.get("class").equals("number")) {
                        strFirstPrize = tempElement.text();
                        continue;
                    }
                }
                if (atris.hasKey("headers") && atris.hasKey("class")) {
                    if (atris.get("headers").equals("addSixPrize") && atris.get("class").equals("number")) {
                        strAddSixPrize = tempElement.text();
                        break;
                    }
                }
            }
            if (strMonths == null || strMonths.trim().length() == 0) {
                ShowDialog("抓不到該月份中獎資料");
                return;
            } else {
                text_Number_Month.setText(strMonths);
            }
            if (strSpecialPrize == null || strSpecialPrize.trim().length() == 0) {
                ShowDialog("抓不到該月份中獎資料");
                return;
            } else {
                text_Number_SpecialPrize.setText(strSpecialPrize);
            }
            if (strGrandPrize == null || strGrandPrize.trim().length() == 0) {
                ShowDialog("抓不到該月份中獎資料");
                return;
            } else {
                text_Number_GrandPrize.setText(strGrandPrize);
            }
            if (strFirstPrize == null || strFirstPrize.trim().length() == 0) {
                ShowDialog("抓不到該月份中獎資料");
                return;
            } else {
                String strFirstPrizeA = strFirstPrize.substring(0, 8);
                String strFirstPrizeB = strFirstPrize.substring(9, 17);
                String strFirstPrizeC = strFirstPrize.substring(18, 26);
                text_Number_FirstPrize.setText(strFirstPrizeA + "\r\n" + strFirstPrizeB + "\r\n" + strFirstPrizeC);
            }
            if (strAddSixPrize == null || strAddSixPrize.trim().length() == 0) {
                ShowDialog("抓不到該月份中獎資料");
                return;
            } else {
                text_Number_AddSixPrize.setText(strAddSixPrize);
            }
        } catch (Exception error) {
            ShowDialog(error.getMessage());
        }
    }

}
