package Util

import model.CardInfo
import org.json.JSONObject

class MtgJsonParser {
    private static final String json = new File(System.getProperty("user.dir") + "/AllSets.json").text

    static LinkedHashMap<String, String> getMtgEditions() {
        def map = [:]
        JSONObject jsonfile = new JSONObject(json)
        for (edition in jsonfile.keys()) {
            def jsonEdition = jsonfile.get(edition)
            map.put(edition, jsonEdition.getString("name"))
        }
        assert map.size() > 0
        return map
    }

    static ArrayList<CardInfo> getMtgCards() {
        ArrayList<CardInfo> cardsList = new ArrayList<>()
        JSONObject jsonfile = new JSONObject(json)
        for (edition in jsonfile.keys()) {
            def jsonEdition = jsonfile.get(edition)
            def jsonCards = jsonEdition.get("cards")
            for (card in jsonCards) {
                CardInfo info = new CardInfo()
                if (card.optInt("multiverseid") == 0) {
                    continue
                }
                info.setId(card.getInt("multiverseid"))
                info.setName(card.getString("name"))
                info.setRarity(card.getString("rarity"))
                info.setEdition(edition)
                info.setText(card.optString("text"))
                info.setType(card.getString("type"))
                info.setManaCost(card.optString("manaCost"))
                info.setFlavor(card.optString("flavor"))
                info.setPower(card.optString("power"))
                info.setToughness(card.optString("toughness"))
                cardsList.add(info)
            }
        }
        def cleanCardList = cardsList.unique { user -> user.id }
        return cleanCardList
    }
}
