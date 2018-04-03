package bruce.uniforminvoice.com.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import bruce.uniforminvoice.com.UniformInvoice;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

public class NumberPresenter {

    @FXML
    private View number;

    @FXML
    private ComboBox cbxMonth;
    
    @FXML
    private WebView webInvoiceNumber;

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
        //label.setText(this.cbxMonth.getSelectionModel().getSelectedItem().toString());
        StringBuilder strbHtml = new StringBuilder();
        strbHtml.append(" <html> ");
        strbHtml.append(" <head> ");
        strbHtml.append("    <link href='../bootstrap.min.fia.css' rel='stylesheet'> ");
        strbHtml.append(" </head> ");
        strbHtml.append(" <body> ");
        strbHtml.append(" <table class='table table-bordered' summary='統一發票中獎號碼單'> ");
        strbHtml.append(" <caption class='hide'> ");
        strbHtml.append("    統一發票 ");
        strbHtml.append(" </caption> ");
        strbHtml.append(" <tbody> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group0'>月份</th> ");
        strbHtml.append(" <td headers='group0' class='title'> 01 ~ 02 月 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group1' rowspan='2'>特別獎</th> ");
        strbHtml.append(" <td headers='group1' class='number'> 21735266 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <td headers='specialPrize'> 同期統一發票收執聯8位數號碼與特別獎號碼相同者獎金1,000萬元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group2' rowspan='2'>特獎</th> ");
        strbHtml.append(" <td headers='group2' class='number'> 91874254 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <td headers='grandPrize'> 同期統一發票收執聯8位數號碼與特獎號碼相同者獎金200萬元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group3' rowspan='2'>頭獎</th> ");
        strbHtml.append(" <td headers='group3' class='number'> 56065209、05739340、69001612 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <td headers='firstPrize'> 同期統一發票收執聯8位數號碼與頭獎號碼相同者獎金20萬元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group4'>二獎</th> ");
        strbHtml.append(" <td headers='group4'> 同期統一發票收執聯末7 位數號碼與頭獎中獎號碼末7 位相同者各得獎金4萬元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group5'>三獎</th> ");
        strbHtml.append(" <td headers='group5'> 同期統一發票收執聯末6 位數號碼與頭獎中獎號碼末6 位相同者各得獎金1萬元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group6'>四獎</th> ");
        strbHtml.append(" <td headers='group6'> 同期統一發票收執聯末5 位數號碼與頭獎中獎號碼末5 位相同者各得獎金4千元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group7'>五獎</th> ");
        strbHtml.append(" <td headers='group7'> 同期統一發票收執聯末4 位數號碼與頭獎中獎號碼末4 位相同者各得獎金1千元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group8'>六獎</th> ");
        strbHtml.append(" <td headers='group8'> 同期統一發票收執聯末3 位數號碼與 頭獎中獎號碼末3 位相同者各得獎金2百元 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group9'>增開六獎</th> ");
        strbHtml.append(" <td headers='group9' class='number'> 591、342 </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" <tr> ");
        strbHtml.append(" <th id='group10'>領獎注意事項</th> ");
        strbHtml.append(" <td headers='group10' class='des'> ");
        strbHtml.append(" <div style='margin-left: 11.7pt;'> ");
        strbHtml.append(" <div style='margin-left: 11.7pt;'> ");
        strbHtml.append(" <p style='margin-left: 11.7pt;'> 1.領獎期間自107年04月06日起至107年07月05日止，請於郵局公告之兌獎營業時間內辦理，中獎人填妥領獎收據並在收據上粘貼0.4%印花稅票【中五獎(含)以上者】，攜帶國民身分證（非本國國籍人士得以護照、居留證等文件替代）及中獎統一發票收執聯兌領獎金。中特別獎、特獎、頭獎者請向各直轄市及各縣、市經指定之郵局領取獎金；中二獎、三獎、四獎、五獎、六獎者請向各地郵局兌獎。（各地郵局延時營業窗口及夜間郵局均不辦理兌獎業務。）<br> 2.統一發票收執聯未依規定載明金額者，不得領獎。<br> 3.統一發票買受人為政府機關、公營事業、公立學校、部隊及營業人者，不得領獎。<br> 4.中四獎(含)以上者，依規定應由發獎單位扣繳20%所得稅款。<br> 5.中獎之統一發票，每張按其最高中獎獎別限領1個獎金。<br> 6.其他有關領獎事項均依「統一發票給獎辦法」規定辦理。<br> 7.若有任何兌獎疑義，請洽詢服務專線電話：(02)2396-1651<br> 8.本期無實體電子發票中獎號碼，公告於財政部稅務入口網站：<a href='http://invoice.etax.nat.gov.tw/' title='http://invoice.etax.nat.gov.tw/'>http://invoice.etax.nat.gov.tw/</a></p> ");
        strbHtml.append(" </div> ");
        strbHtml.append(" </div> <p> &nbsp;</p> </td> ");
        strbHtml.append(" </tr> ");
        strbHtml.append(" </tbody> ");
        strbHtml.append(" </table> ");
        strbHtml.append(" </body> ");
        strbHtml.append(" </html> ");
        webInvoiceNumber.getEngine().loadContent(strbHtml.toString());
    }

}
