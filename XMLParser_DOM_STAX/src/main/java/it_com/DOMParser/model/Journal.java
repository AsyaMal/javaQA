package it_com.DOMParser.model;

import java.util.List;

public class Journal {
    private String journalTitle;
    private Contacts contacts;
    private List<Articles> articles;

    public Journal(String journal_title, Contacts contacts, List<Articles> articles) {
        this.journalTitle = journal_title;
        this.contacts = contacts;
        this.articles = articles;
    }

    public Journal() {

    }

    public void setJournalTitle(String journal_title) {
        this.journalTitle = journal_title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journal_title='" + journalTitle + '\'' +
                ", contacts='" + contacts + '\'' +
                ", articles=" + articles +
                '}';
    }
}
