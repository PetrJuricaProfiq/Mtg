Create Table Price (
    Id INTEGER PRIMARY KEY,
    Price INTEGER NOT NUll,
    CardId INTEGER NOT NULL, FOREIGN Key(CardId) REFERENCES Card(Id)
)