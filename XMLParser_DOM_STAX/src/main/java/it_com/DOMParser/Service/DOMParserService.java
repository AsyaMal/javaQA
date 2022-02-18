package it_com.DOMParser.Service;

import it_com.DOMParser.Util.DOMParserUtil;
import it_com.DOMParser.model.Articles;
import it_com.DOMParser.model.Contacts;
import it_com.DOMParser.model.Hotkeys;
import it_com.DOMParser.model.Journal;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;

public class DOMParserService {
    private final Journal journal;
    private final List<Articles> articleList;
    private final Contacts contacts;
    private final List<Hotkeys> hotkeyList;
    private final NodeList nodeList;

    public DOMParserService(Journal journal, List<Articles> articleList, Contacts contacts, List<Hotkeys> hotkeyList, NodeList nodeList) {
        this.journal = journal;
        this.articleList = articleList;
        this.contacts = contacts;
        this.hotkeyList = hotkeyList;
        this.nodeList = nodeList;
    }

    public Journal getJournalFromXML() {
        DOMParserUtil.getNodeListStream(nodeList).forEach(journalNode -> {
            if (journalNode instanceof Element) {
                switch (journalNode.getNodeName()) {
                    case "journal_title" -> journal.setJournalTitle(journalNode
                            .getLastChild()
                            .getTextContent()
                            .trim());
                    case "contacts" -> getContactsFromXML(journalNode.getChildNodes());
                    case "articles" -> getArticlesFromXML(journalNode.getChildNodes());
                }
            }
        });
        return journal;
    }

    private void getContactsFromXML(NodeList nodeList) {
        DOMParserUtil.getNodeListStream(nodeList).forEach(contactsNode -> {
            if (contactsNode instanceof Element) {
                String contactsContent = contactsNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (contactsNode.getNodeName()) {
                    case "address" -> contacts.setAddress(contactsContent);
                    case "tel" -> contacts.setTel(contactsContent);
                    case "email" -> contacts.setEmail(contactsContent);
                    case "journal_url" -> contacts.setJournalUrl(contactsContent);
                }
                journal.setContacts(contacts);
            }
        });
    }


    private void getArticlesFromXML(NodeList nodeList) {
        DOMParserUtil.getNodeListStream(nodeList).forEach(articlesNode -> {
            if (articlesNode instanceof Element) {
                Articles articles = new Articles();
                String articlesID = articlesNode.getAttributes().
                        getNamedItem("ID").getNodeValue();
                articles.setId(articlesID);
                articleList.add(getArticlesFromXML(articles, articlesNode.getChildNodes(), articlesID));
            }
        });
        journal.setArticles(articleList);
    }

    private Articles getArticlesFromXML(Articles articles, NodeList nodeList, String articlesID) {
        DOMParserUtil.getNodeListStream(nodeList).forEach(articlesNode -> {
            if (articlesNode instanceof Element) {
                String articlesContent = articlesNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (articlesNode.getNodeName()) {
                    case "title" -> articles.setTitle(articlesContent);
                    case "author" -> articles.setAuthor(articlesContent);
                    case "url" -> articles.setUrl(articlesContent);
                    case "hotkeys" -> getHotkeyFromXML(articles, articlesNode.getChildNodes(), articlesID);
                }
            }
        });
        return articles;
    }

    private void getHotkeyFromXML(Articles articles, NodeList nodeList, String articlesID) {
        DOMParserUtil.getNodeListStream(nodeList).forEach(hotkeysNode -> {
            if (hotkeysNode instanceof Element) {
                Hotkeys hotkey = new Hotkeys();
                hotkey.setId(articlesID);
                hotkey.setHotkey(hotkeysNode.getTextContent().trim());
                hotkeyList.add(hotkey);
            }
        });
        articles.setHotkeys(hotkeyList
                .stream()
                .filter(n -> n.getId().equals(articles.getId()))
                .collect(Collectors.toList()));
    }

}
