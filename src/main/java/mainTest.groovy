import groovy.json.JsonParser
import groovy.json.JsonSlurper
import model.*
import org.codehaus.groovy.*
class mainTest {

    static void main(String[] args) {
        //DatabaseConnector db = new DatabaseConnector()
        //db.getConnection()
        //db.checkDbEmpty()
        //Type typ = new Type()
        //Format form = new Format()
        //println(form.selectFormat("modern"))
        //println(typ.selectAll())
        //println(typ.selectType("Instant"))
        //sendingPostRequest()
        parseJSON()
    }

    private static void sendingPostRequest() throws Exception {
        final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"
        String url = "http://www.cernyrytir.cz/index.php3?akce=995"
        URL obj = new URL(url)
        HttpURLConnection con = (HttpURLConnection) obj.openConnection()

        // Setting basic post request
        con.setRequestMethod("POST")
        //con.setRequestProperty("Origin", "http://www.cernyrytir.cz")
        //con.setRequestProperty("Accept-Encoding", "gzip, deflate")
        //con.setRequestProperty("Accept-Language", "cs,en-US;q=0.8,en;q=0.6")
        //con.setRequestProperty("Upgrade-Insecure-Requests", "1")
        con.setRequestProperty("User-Agent", USER_AGENT)
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        //con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
        //con.setRequestProperty("Cache-Control", "max-age=0")
        //con.setRequestProperty("Referer", "http://www.cernyrytir.cz/")
        //con.setRequestProperty("Connection", "keep-alive")
        //con.setRequestProperty("DNT", "1")
        String card = "--data edice_magic=libovolna&rarita=A&foil=F&exp=%2B&typkarty=instant&typtext=&powmin=0&powmax=99&thgmin=0&thgmax=99&textkarty=&ccmin=0&ccmax=99&language%5B%5D=EN&stav%5B%5D=NM&jmenokarty=Path+to+Exile&triditpodle=ceny&submit=Vyhledej"

        // Send post request
        con.setDoOutput(true)
        DataOutputStream wr = new DataOutputStream(con.getOutputStream())
        wr.writeBytes(card)
        wr.flush()
        wr.close()

        int responseCode = con.getResponseCode()
        System.out.println("nSending 'POST' request to URL : " + url)
        System.out.println("Post Data : " + card)
        System.out.println("Response Code : " + responseCode)

        BufferedReader bufIn = new BufferedReader(
                new InputStreamReader(con.getInputStream()))
        String output
        StringBuffer response = new StringBuffer()

        while ((output = bufIn.readLine()) != null) {
            response.append(output)
        }
        bufIn.close()

        //printing result from response
        System.out.println(response.toString())
    }


    private static void parseJSON() {
        File jsonFile = new File(System.getProperty("user.dir") + "/AllSets.json")
        JsonSlurper slurp = new JsonSlurper()
        //def jsonObject = slurp.parse(jsonFile)

    }
}
