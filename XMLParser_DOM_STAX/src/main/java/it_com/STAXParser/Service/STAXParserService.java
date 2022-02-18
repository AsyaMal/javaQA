package it_com.STAXParser.Service;

import it_com.STAXParser.model.Journal;
import it_com.STAXParser.Util.STAXParserUtil;
import it_com.STAXParser.model.Articles;
import it_com.STAXParser.model.Contacts;
import it_com.STAXParser.model.Hotkeys;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class STAXParserService {
    private Journal journal;
    private Contacts contacts;
    private List<Articles> articlesLists;
    private Articles articles;
    private List<Hotkeys> hotkeysList;
    private String tagContent;
    private Hotkeys hotkeys;

    public Journal printJournalSTAX() {
        try {
            XMLStreamReader reader = STAXParserUtil.getXMLStreamReader();
            if (reader != null) {
                while (reader.hasNext()) {
                    int event = reader.next();
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT -> {
                            if ("journal_title".equals(reader.getLocalName())) {
                                journal = new Journal();
                            }
                            if ("contacts".equals(reader.getLocalName())) {
                                contacts = new Contacts();
                            }
                            if ("articles".equals(reader.getLocalName())) {
                                articlesLists = new ArrayList<>();
                            }
                            if ("article".equals(reader.getLocalName())) {
                                articles = new Articles();
                                articles.setId(reader.getAttributeValue(0));
                            }
                            if ("hotkeys".equals(reader.getLocalName())) {
                                hotkeysList = new ArrayList<>();
                            }
                            if ("hotkey".equals(reader.getLocalName())) {
                                hotkeys = new Hotkeys();
                            }
                        }
                        case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                        case XMLStreamConstants.END_ELEMENT -> {
                            if ("journal_title".equals(reader.getLocalName())) {
                                journal.setJournalTitle(tagContent);
                            }
                            if ("address".equals(reader.getLocalName())) {
                                contacts.setAddress(tagContent);
                            }
                            if ("tel".equals(reader.getLocalName())) {
                                contacts.setTel(tagContent);
                            }
                            if ("email".equals(reader.getLocalName())) {
                                contacts.setEmail(tagContent);
                            }
                            if ("journal_url".equals(reader.getLocalName())) {
                                contacts.setJournalUrl(tagContent);
                            }
                            if ("contacts".equals(reader.getLocalName())) {
                                journal.setContacts(contacts);
                            }
                            if ("title".equals(reader.getLocalName()) && articles != null) {
                                articles.setTitle(tagContent);
                            }
                            if ("author".equals(reader.getLocalName()) && articles != null) {
                                articles.setAuthor(tagContent);
                            }
                            if ("url".equals(reader.getLocalName()) && articles != null) {
                                articles.setUrl(tagContent);
                            }
                            if ("hotkey".equals(reader.getLocalName())) {
                                hotkeys.setHotkey(tagContent);
                                hotkeysList.add(hotkeys);
                                articles.setHotkeys(hotkeysList);
                            }
                            if ("article".equals(reader.getLocalName())) {
                                articlesLists.add(articles);
                            }
                            if ("articles".equals(reader.getLocalName())) {
                                journal.setArticles(articlesLists);
                            }
                        }
                    }
                }
            }
            return journal;
        } catch (XMLStreamException e) {
            System.out.println("XMLStreamException error");
            e.printStackTrace();
            return null;
        }
    }

}
