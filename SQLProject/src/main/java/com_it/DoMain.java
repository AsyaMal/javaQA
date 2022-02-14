package com_it;

import com_it.utils.Menu;

public class DoMain {
    public static void main(String[] args) {
        ConnectionDB.getConnection();
        Menu menu = new Menu();
        menu.start();
        ConnectionDB.closeConnection();
    }
}
