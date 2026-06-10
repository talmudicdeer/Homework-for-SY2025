Alexis Baker


Databases


Lab 3 (Zylab 19.13)


`Initialize.sql` (read-only)

```sql
-- Drop current Sakila database
DROP DATABASE sakila;

-- Restore Sakila to initial state
source /zyfiles/mysql/sakila/sakila-schema.sql; 
source /zyfiles/mysql/sakila/sakila-data.sql;

-- Set default database to Sakila
USE sakila;
```


`Main.sql`

```sql
-- Initialize database
source Initialize.sql

-- Your CREATE TABLE and ALTER TABLE statements go here


CREATE TABLE phone (
    phone_type VARCHAR(12),
    phone_id  INTEGER UNSIGNED NOT NULL,
    country_code INTEGER UNSIGNED NOT NULL,
    phone_number INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY (phone_id)
    );

SELECT *
FROM customer;

ALTER TABLE address
DROP COLUMN phone;

ALTER TABLE customer
ADD COLUMN phone_id INTEGER UNSIGNED UNIQUE,
ADD FOREIGN KEY (phone_id) REFERENCES phone(phone_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE staff
ADD COLUMN phone_id INTEGER UNSIGNED UNIQUE,
ADD FOREIGN KEY (phone_id) REFERENCES phone(phone_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE store
ADD COLUMN phone_id INTEGER UNSIGNED UNIQUE,
ADD FOREIGN KEY (phone_id) REFERENCES phone(phone_id) ON DELETE SET NULL ON UPDATE CASCADE;
```
