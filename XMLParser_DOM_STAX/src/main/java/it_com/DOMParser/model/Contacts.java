package it_com.DOMParser.model;

public class Contacts {
    private String address;
    private String tel;
    private String email;
    private String journalUrl;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJournalUrl(String journal_url) {
        this.journalUrl = journal_url;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", journal_url='" + journalUrl + '\'' +
                '}';
    }
}
