package model

import groovy.sql.Sql

import java.sql.SQLException

class Type extends DatabaseConnector {

    private Sql sql = null

    ArrayList<String> selectAll() {
        try {
            ArrayList<String> types = new ArrayList<>()
            sql = getConnection()
            sql.eachRow("SELECT * FROM Type") { row ->
                if (row.type != null) {
                    types.add(row.type.toString())
                }
            }
            return types
        } catch (SQLException e) {
            println(e)
            throw e
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }

    String selectType(String type) {
        try {
            sql = getConnection()
            def row = sql.firstRow("Select type from Type where type like'" + type + "'")
            return row.type
        } catch (SQLException e) {
            throw new SQLException(e)
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }
}
