package model

import Util.DatabaseConnector
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

import java.sql.SQLException

class CardInfo extends DatabaseConnector {
    private int id
    private String name
    private String rarity
    private String edition
    private String cardText
    private String type
    private String manaCost
    private String flavor
    private String power
    private String toughness

    private Sql sql

    CardInfo(){}

    CardInfo(long id ){
        this.select(id)
    }

    String getManaCost() {
        return manaCost
    }

    void setManaCost(String manaCost) {
        this.manaCost = manaCost
    }

    String getPower() {
        return power
    }

    void setPower(String power) {
        if (power.empty) {
            this.power = null
        } else {
            this.power = power
        }
    }

    String getType() {
        return type
    }

    void setType(String type) {
        this.type = type
    }

    String getText() {
        return cardText
    }

    void setText(String text) {
        if (text.empty) {
            this.cardText = null
        } else {
            this.cardText = text
        }
    }

    String getEdition() {
        return edition
    }

    void setEdition(String edition) {
        this.edition = edition
    }

    String getRarity() {
        return rarity
    }

    void setRarity(String rarity) {
        this.rarity = rarity
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getToughness() {
        return toughness
    }

    void setToughness(String toughness) {
        if (toughness.empty) {
            this.toughness = null
        } else {
            this.toughness = toughness
        }
    }

    String getFlavor() {
        return flavor
    }

    void setFlavor(String flavor) {
        if (flavor.empty) {
            this.flavor = null
        } else {
            this.flavor = flavor
        }
    }


    static void batchInsert(ArrayList<CardInfo> list) {
        Sql sql= null
        try {
            sql = getConnection()
            list.each { item ->
                sql.execute """INSERT INTO CardInfo(Id, Name, Rarity, Edition, Type, CardText, ManaCost, Flavor, Power, Toughness) 
Values(${item.id}, ${item.name}, ${item.rarity},${item.edition}, ${item.type},${item.cardText},${item.manaCost}, 
${item.flavor}, ${item.power}, ${item.toughness})"""
            }
        } catch (SQLException e) {
            println(e)
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }

    void select(long id) {
        sql = getConnection()
        GroovyRowResult result = sql.firstRow("SELECT * FROM CardInfo WHERE id = ${id}")
        if (result == null) {
            throw new Exception("Card ID not found in DB")
        } else {
            this.id =(int)result.get("Id")
            this.name = result.get("Name")
            this.rarity = result.get("Rarity")
            this.edition = result.get("Edition")
            this.cardText = result.get("cardText")
            this.type = result.get("type")
            this.manaCost = result.get("Manacost")
            this.flavor = result.get("Flavor")
            this.power = result.get("power")
            this.toughness = result.get("toughness")
        }
    }

    @Override
    String toString() {
        return "CardInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", edition='" + edition + '\'' +
                ", cardText='" + cardText + '\'' +
                ", type='" + type + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", flavor='" + flavor + '\'' +
                ", power='" + power + '\'' +
                ", toughness='" + toughness + '\'' +
                '}'
    }
}
