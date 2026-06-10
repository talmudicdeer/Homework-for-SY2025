Alexis Baker


Databases


Lab 4 (Zylab 20.8)


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

-- Your SQL statements go here
EXPLAIN
    SELECT *
    FROM film
    WHERE title = 'ALONE TRIP';

ALTER TABLE film
DROP INDEX idx_title;

EXPLAIN
    SELECT *
    FROM film
    WHERE title = 'ALONE TRIP';

EXPLAIN
    SELECT rating, COUNT(*)
    FROM film
    GROUP BY rating;

CREATE INDEX idx_rating ON film (rating);

EXPLAIN
    SELECT rating, COUNT(*)
    FROM film
    GROUP BY rating;
```
