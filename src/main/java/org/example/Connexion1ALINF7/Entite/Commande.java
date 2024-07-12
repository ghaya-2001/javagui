package org.example.Connexion1ALINF7.Entite;

public class Commande {

    private int id;
    private int userid;
    private int total;
    private String comment;
    private String sauces;
    private String paymentType;
    private String cardType;
    private String cardNumber;

    public Commande(int id, int userid, int total, String comment, String sauces, String paymentType, String cardType, String cardNumber) {
        this.id = id;
        this.userid = userid;
        this.total = total;
        this.comment = comment;
        this.sauces = sauces;
        this.paymentType = paymentType;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSauces() {
        return sauces;
    }

    public void setSauces(String sauces) {
        this.sauces = sauces;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", userid=" + userid +
                ", total=" + total +
                ", comment='" + comment + '\'' +
                ", sauces='" + sauces + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
