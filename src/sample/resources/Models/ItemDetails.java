package sample.resources.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sample.resources.Controllers.OverviewController;

public class ItemDetails extends OverviewController {

    private final StringProperty item_name;
    private final StringProperty item_lang;
    private final IntegerProperty item_count_available;
    private final IntegerProperty item_count_lend;

    public ItemDetails(String item_name, String item_lang, Integer item_count_available, Integer item_count_lend) {
        this.item_name = new SimpleStringProperty(item_name);
        this.item_lang = new SimpleStringProperty(item_lang);
        this.item_count_available = new SimpleIntegerProperty(item_count_available);
        this.item_count_lend = new SimpleIntegerProperty(item_count_lend);
    }

    //getters
    public String getItem_name() {
        return item_name.get();
    }
    public String getItem_lang() {
        return item_lang.get();
    }
    public Integer getItem_count_available() { return item_count_available.get(); }
    public Integer getItem_count_lend() { return item_count_lend.get(); }

    public String getColumnItemEBooksName() { return item_name.get(); }
    public String getColumnItemEBooksLang() { return item_lang.get(); }
    public Integer getColumnItemEBooksCountAvailable() { return item_count_available.get(); }
    public Integer getColumnItemEBooksCountLend() { return item_count_lend.get(); }

    public String getColumnItemCDorDVDName() { return item_name.get(); }
    public String getColumnItemCDorDVDLang() { return item_lang.get(); }
    public Integer getColumnItemCDorDVDCountAvailable() { return item_count_available.get(); }
    public Integer getColumnItemCDorDVDCountLend() { return item_count_lend.get(); }

    public String getColumnItemMagazinesName() { return item_name.get(); }
    public String getColumnItemMagazinesLang() { return item_lang.get(); }
    public Integer getColumnItemMagazinesCountAvailable() { return item_count_available.get(); }
    public Integer getColumnItemMagazinesCountLend() { return item_count_lend.get(); }

    //setters
    public void setItem_name(String value) {
        item_name.set(value);
    }
    public void setItem_lang(String value) {
        item_lang.set(value);
    }
    public void setColumnItemBooksCountAvailable(Integer value) {
        item_count_available.set(value);
    }
    public void setColumnItemBooksCountLend(Integer value) {
        item_count_lend.set(value);
    }

    public void setColumnItemEBooksName(String value) { item_name.set(value); }
    public void setColumnItemEBooksLang(String value) { item_lang.set(value); }
    public void setColumnItemEBooksCountAvailable(Integer value) { item_count_available.set(value); }
    public void setColumnItemEBooksCountLend(Integer value) { item_count_lend.set(value); }

    public void setColumnItemCDorDVDName(String value) { item_name.set(value); }
    public void setColumnItemCDorDVDLang(String value) { item_lang.set(value); }
    public void setColumnItemCDorDVDCountAvailable(Integer value) { item_count_available.set(value); }
    public void setColumnItemCDorDVDCountLend(Integer value) { item_count_lend.set(value); }

    public void setColumnItemMagazinesName(String value) { item_name.set(value); }
    public void setColumnItemMagazinesLang(String value) { item_lang.set(value); }
    public void setColumnItemMagazinesCountAvailable(Integer value) { item_count_available.set(value); }
    public void setColumnItemMagazinesCountLend(Integer value) { item_count_lend.set(value); }

    //Property values
    public StringProperty itemBooksNameProp() {
        return item_name;
    }
    public StringProperty itemBooksLangProp() {
        return item_lang;
    }
    public IntegerProperty itemBooksCountAvailableProp() {
        return item_count_available;
    }
    public IntegerProperty itemBooksCountLendProp() {
        return item_count_lend;
    }

    public StringProperty itemEBooksNameProp() {
        return item_name;
    }
    public StringProperty itemEBooksLangProp() {
        return item_lang;
    }
    public IntegerProperty itemEBooksCountAvailableProp() {
        return item_count_available;
    }
    public IntegerProperty itemEBooksCountLendProp() {
        return item_count_lend;
    }

    public StringProperty itemCDorDVDNameProp() {
        return item_name;
    }
    public StringProperty itemCDorDVDLangProp() {
        return item_lang;
    }
    public IntegerProperty itemCDorDVDCountAvailableProp() {
        return item_count_available;
    }
    public IntegerProperty itemCDorDVDCountLendProp() {
        return item_count_lend;
    }

    public StringProperty itemMagazinesNameProp() {
        return item_name;
    }
    public StringProperty itemMagazinesLangProp() {
        return item_lang;
    }
    public IntegerProperty itemMagazinesCountAvailableProp() {
        return item_count_available;
    }
    public IntegerProperty itemMagazinesCountLendProp() {
        return item_count_lend;
    }
}
