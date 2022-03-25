USE test;

DROP TABLE IF EXISTS Films;
CREATE TABLE Films
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    year int(4),
    genre VARCHAR(20),
    watched BIT DEFAULT false  NOT NULL
)
    COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX films_title_index ON films (title);

INSERT INTO films (title,year,genre,watched)
VALUES
    ('Inception', 2010, 'sci-fi', 1),
    ('The Lord of the Rings: The Fellowship of the Ring', 2001, 'fantasy', 1),
    ('Tag', 2018, 'comedy', 0),
    ('Gunfight at the O.K. Corral', 1957, 'western', 0),
    ('Die Hard', 1988, 'action', 1);