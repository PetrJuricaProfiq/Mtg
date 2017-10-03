
import java.sql.*

class DatabaseConnector {
    static final String url = "jdbc:sqlite:C:/sqlite/db/MTG.db"
    private Connection conn

    Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC")
            conn = DriverManager.getConnection(url)
            if (conn != null) {
                return conn
            }
        } catch (SQLException e) {
            println(e.getMessage())
        }
        return null
    }

//    boolean checkDbEmpty(){
//        try {
//            Connection conn = this.getConnection()
//            Statement stmnt = conn.createStatement()
//            ResultSet set = stmnt.execute("SELECT * FROM Edition")
//            println(set)
//        }catch (SQLException e){
//            println(e)
//        }
//    }
}
