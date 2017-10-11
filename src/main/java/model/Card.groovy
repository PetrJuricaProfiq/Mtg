package model

import Util.DatabaseConnector
import groovy.sql.Sql

import java.sql.SQLException

class Card extends DatabaseConnector {
    private int id
    private CardInfo info
    private boolean own

    private Sql sql

    void insert(int infoId, boolean own) {
        try {
            sql = getConnection()
            sql.execute("INSERT INTO Card(Info, Own) VALUES(${infoId}, ${own})")
        } catch (SQLException e) {
            throw e
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }

    void updateOwn(int id, boolean own) {
        try {
            sql = getConnection()
            sql.execute("UPDATE Card SET own = ${own} WHERE id = ${id}")
        } catch (SQLException e) {
            throw e
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }
}
