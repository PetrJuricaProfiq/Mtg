package model

import groovy.sql.Sql

import java.nio.file.Paths
import java.sql.*

abstract class DatabaseConnector {

    private static String url
    private static Sql conn

    static {
        url = "jdbc:sqlite:" + Paths.get(System.getProperty("user.dir") + "/DB/MTG.db").toString()
    }

    protected static Sql getConnection() {
        try {
            conn = Sql.newInstance(url,"org.sqlite.JDBC")
            if (conn != null) {
                return conn
            }
        } catch (SQLException e) {
            println(e.getMessage())
        }catch (Exception ex){
            println(ex)
        }
        return null
    }



}
