package model

import Util.DatabaseConnector
import groovy.sql.Sql

import java.sql.SQLException

class Format extends DatabaseConnector {
    private Sql sql = null
    private String format



    ArrayList<String> selectAll() {
        try {
            ArrayList<String> types = new ArrayList<>()
            sql = getConnection()
            sql.eachRow("SELECT * FROM Format") { row ->
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

    String selectFormat(String format) {
        try {
            sql = getConnection()
            def row = sql.firstRow("SELECT format FROM Format WHERE format like'" + format + "'")
            return row.Format
        } catch (SQLException e) {
            throw new SQLException(e)
        } finally {
            if (sql != null) {
                sql.close()
            }
        }
    }
}
