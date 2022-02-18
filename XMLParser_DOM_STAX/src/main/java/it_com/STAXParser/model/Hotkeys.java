package it_com.STAXParser.model;

public class Hotkeys {

    private String hotkey;

    public Hotkeys() {

    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return "Hotkeys{" +
                " hotkey='" + hotkey + '\'' +
                '}';
    }
}
