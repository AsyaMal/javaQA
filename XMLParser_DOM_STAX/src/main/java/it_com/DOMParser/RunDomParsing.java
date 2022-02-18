package it_com.DOMParser;

import it_com.DOMParser.Service.DOMParserService;
import it_com.DOMParser.Util.DOMParserUtil;
import it_com.DOMParser.model.Articles;
import it_com.DOMParser.model.Contacts;
import it_com.DOMParser.model.Hotkeys;
import it_com.DOMParser.model.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class RunDomParsing {
    public static void main(String[] args) {
        Journal journal = new Journal();
        Contacts contacts = new Contacts();
        List<Articles> articles = new ArrayList<>();
        List<Hotkeys> hotkeys = new ArrayList<>();
        Document document = DOMParserUtil.parseXMLDocument();
        NodeList nodeList = DOMParserUtil.getNodeList(document);
        DOMParserService domParserService = new DOMParserService(journal, articles, contacts, hotkeys, nodeList);
        System.out.println("The result of the DOM parsing:");
        System.out.println(domParserService.getJournalFromXML().toString());
    }
}
