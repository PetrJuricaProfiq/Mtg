package model

class Decklist {
    private int id
    private String name
    private Format format

    int getId() {
        return this.id
    }

    void setId(id) {
        this.id = id
    }

    String getName() {
        return this.name
    }

    void setName(name) {
        this.name = name
    }

    String getFormat() {
        return this.format
    }

    void setFormat(format) { this.format = format }

}
