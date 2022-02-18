package it_com.DOMParser.model;

public class Hotkeys {
    private String id;
    private String hotkey;

    public Hotkeys() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return "Hotkeys{" +
                "id='" + id + '\'' +
                ", hotkey='" + hotkey + '\'' +
                '}';
    }
}
