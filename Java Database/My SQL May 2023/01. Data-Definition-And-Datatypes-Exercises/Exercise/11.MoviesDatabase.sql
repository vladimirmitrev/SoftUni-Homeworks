CREATE DATABASE movies;
use movies;

CREATE TABLE directors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO directors (director_name) VALUES
("Spielberg"),
("Lucas"),
("Cameron"),
("Abrams"),
("Yates");

CREATE TABLE genres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO genres (genre_name) VALUES
("Thriller"),
("Sci-Fi"),
("Mystery"),
("Comedy"),
("Action");

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO categories (category_name) VALUES
("ThrillerC"),
("Sci-FiC"),
("MysteryC"),
("ComedyC"),
("ActionC");

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length DOUBLE(3 , 2 ),
    genre_id INT,
    category_id INT,
    rating DOUBLE(10 , 2 ),
    notes TEXT
    -- FOREIGN KEY (director_id)
--        REFERENCES directors (id),
--    FOREIGN KEY (genre_id)
--        REFERENCES genres (id),
--     FOREIGN KEY (category_id)
--        REFERENCES categories (id)
);

INSERT INTO movies(id, title,director_id, copyright_year,length,genre_id,category_id,rating,notes)
VALUES
(1, 'Harry', 5, 2001, 2.7, 1, 4, 9.5, 'good'),
(2, 'Star Wars', 2, 2010, 3.2, 3, 4, 9.8, 'great'),
(3, 'Spiderman', 3, 2018, 2.5, 5, 3, 8.2, 'nice'),
(4, 'Star Trek', 4, 1997,  2.4, 2, 3, 8.8, 'awesome'),
(5, 'LOST', 1, 2008, 0.8, 1, 5, 7.9, 'interesting');


select * from directors;
select * from genres;
select * from categories;
select * from movies;

-- drop table movies;
