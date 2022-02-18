package it_com.STAXParser;

import it_com.STAXParser.Service.STAXParserService;

public class RunSTAXParsing {
    public static void main(String[] args) {
        STAXParserService staxParserService = new STAXParserService();
        System.out.println("The result of the STAX parsing:");
        System.out.println(staxParserService.printJournalSTAX().toString());
    }
}
