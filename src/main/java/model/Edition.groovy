package model

import Util.DatabaseConnector
import groovy.sql.*

import java.sql.SQLException

class Edition extends DatabaseConnector {
    private String shortcut
    private String name
    private Sql sql = null

    String getShortcut() {
        return this.shortcut
    }

    void setShortcut(String shortcut) {
        this.shortcut = shortcut
    }

    String getName() {
        return this.name
    }

    void setName(String shortcut) {
        this.name = name
    }

    void insert(String shortcut, String name) {
        try {
            sql = getConnection()
            sql.execute("INSERT INTO Edition(shortcut, name) Values(${shortcut}, ${name})")
        } catch (SQLException e) {
            println(e)
        }finally{
            if(sql != null){
                sql.close()
            }
        }
    }

    void batchInsert(def map) {
        try {
            Sql sql = getConnection()
            map.each { item ->
                sql.execute("INSERT INTO Edition(Shortcut, Name) Values(${item.key}, ${item.value})")
                //println("'${item.key}', '${item.value}'")
            }
        } catch (SQLException e) {
            println(e)
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }

}
