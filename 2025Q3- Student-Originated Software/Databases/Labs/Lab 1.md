Alexis Baker


Databases


Lab 1 (Zylab 17.19)


`Initialize.sql`

```sql
-- Initialize Horse table
DROP TABLE IF EXISTS Horse;
```


`Main.sql`

```sql
-- Initialize database
source Initialize.sql

-- Your SQL statements go here 
CREATE TABLE Horse (
    ID SMALLINT UNSIGNED AUTO_INCREMENT,
    PRIMARY KEY (ID),
    RegisteredName VARCHAR(15) NOT NULL,
    Breed VARCHAR(20) CHECK  (Breed IN ('Egyptian Arab', 'Holsteiner', 'Quarter Horse, Paint', 'Saddlebred')),
    Height DECIMAL(3,1) CHECK (Height >=10.0 AND Height <=20.0),
    BirthDate DATE CHECK (BirthDate >= '2015-01-01')
);

SHOW COLUMNS FROM HORSE;
```
