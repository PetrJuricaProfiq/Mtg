package model

import Util.DatabaseConnector
import groovy.sql.Sql

class Price extends DatabaseConnector {
    private int Id
    private int price
    private Card card

    private Sql sql

    int getId() {
        return Id
    }

    int getPrice() {
        return price
    }

    void setPrice(int price) {
        this.price = price
    }

    Card getCard() {
        return card
    }

    void setCard(Card card) {
        this.card = card
    }

    void insert(int price, int idCard){
        sql = getConnection()
        sql.execute("INSERT INTO Price(Price, Card) VALUES()")
    }
}
