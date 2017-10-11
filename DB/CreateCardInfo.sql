CREATE TABLE Cardinfo (
    Id INTEGER PRIMARY KEY,
    Name TEXT NOT NULL,
    Rarity TEXT NOT NULL,
    Edition TEXT NOT NULL,
    CardText TEXT,
    ManaCost Text,
    Type Text,
    Flavor Text,
    Power Text,
    Toughness Text,
    FOREIGN KEY(Edition) REFERENCES Edition(Shortcut)
)