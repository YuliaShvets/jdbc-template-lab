CREATE DATABASE IF NOT EXISTS shvets_db;
USE shvets_db;


DROP TABLE IF EXISTS use_of_drug;
DROP TABLE IF EXISTS composition_of_drug;
DROP TABLE IF EXISTS category_of_drug;
DROP TABLE IF EXISTS primary_package;
DROP TABLE IF EXISTS drug;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS producer;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS drugstore;
DROP TABLE IF EXISTS country;


CREATE TABLE country
(
    name varchar(20) NOT NULL,
    PRIMARY KEY (name)
) ENGINE=INNODB;


CREATE TABLE drugstore
(
    id   int AUTO_INCREMENT NOT NULL,
    name varchar(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;


CREATE TABLE city
(
    id           int AUTO_INCREMENT NOT NULL,
    name         varchar(15) NOT NULL,
    country_name varchar(20) NOT NULL,
    PRIMARY KEY (id),
    KEY          city_country (country_name),
    CONSTRAINT city_country FOREIGN KEY (country_name) REFERENCES country (name)
) ENGINE=INNODB;


CREATE TABLE producer
(
    id           int AUTO_INCREMENT NOT NULL,
    name         varchar(30) NOT NULL,
    country_name varchar(20) NOT NULL,
    PRIMARY KEY (id),
    KEY          producer_country (country_name),
    CONSTRAINT producer_country FOREIGN KEY (country_name) REFERENCES country (name)
) ENGINE=INNODB;


CREATE TABLE department
(
    id           int AUTO_INCREMENT NOT NULL,
    number       int NOT NULL,
    drugstore_id int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT department_drugstore FOREIGN KEY (drugstore_id) REFERENCES drugstore (id)
) ENGINE=INNODB;


CREATE TABLE location
(
    id            int AUTO_INCREMENT NOT NULL,
    street        varchar(15) NOT NULL,
    department_id int         NOT NULL,
    city_id       int         NOT NULL,
    PRIMARY KEY (id),
    KEY           location_city (city_id),
    KEY           location_department (department_id),
    CONSTRAINT location_city FOREIGN KEY (city_id) REFERENCES city (id),
    CONSTRAINT location_department FOREIGN KEY (department_id) REFERENCES department (id)
) ENGINE=INNODB;


CREATE TABLE drug
(
    id               int AUTO_INCREMENT NOT NULL,
    name             varchar(20) NOT NULL,
    production_date  date        NOT NULL,
    expiration_date  date        NOT NULL,
    is_available     tinyint(1) NOT NULL,
    price_in_dollars double(10, 2
) NOT NULL,
  producer_id int NOT NULL,
  drugstore_id int NOT NULL,
  PRIMARY KEY (id),
  KEY drug_drugstore (drugstore_id),
  KEY drug_producer (producer_id),
  CONSTRAINT drug_drugstore FOREIGN KEY (drugstore_id) REFERENCES drugstore (id),
  CONSTRAINT drug_producer FOREIGN KEY (producer_id) REFERENCES producer (id)
) ENGINE=INNODB;


CREATE TABLE primary_package
(
    id             int AUTO_INCREMENT NOT NULL,
    type_packaging varchar(35) NOT NULL,
    drug_id        int         NOT NULL,
    PRIMARY KEY (id),
    KEY            primary_package_drug (drug_id),
    CONSTRAINT primary_package_drug FOREIGN KEY (drug_id) REFERENCES drug (id)
) ENGINE=INNODB;


CREATE TABLE category_of_drug
(
    id                    int AUTO_INCREMENT NOT NULL,
    required_prescription tinyint(1) NOT NULL,
    type                  varchar(20) NOT NULL,
    drug_id               int         NOT NULL,
    PRIMARY KEY (id),
    KEY                   category_of_drug_drug (drug_id),
    CONSTRAINT category_of_drug_drug FOREIGN KEY (drug_id) REFERENCES drug (id)
) ENGINE=INNODB;


CREATE TABLE composition_of_drug
(
    id                 int AUTO_INCREMENT NOT NULL,
    active_ingredients varchar(30) NOT NULL,
    drug_id            int         NOT NULL,
    PRIMARY KEY (id),
    KEY                composition_of_drug_drug (drug_id),
    CONSTRAINT composition_of_drug_drug FOREIGN KEY (drug_id) REFERENCES drug (id)
) ENGINE=INNODB;


CREATE TABLE use_of_drug
(
    id       int AUTO_INCREMENT NOT NULL,
    use_type varchar(40) NOT NULL,
    drug_id  int         NOT NULL,
    PRIMARY KEY (id),
    KEY      using_of_drug_drug (drug_id),
    CONSTRAINT using_of_drug_drug FOREIGN KEY (drug_id) REFERENCES drug (id)
) ENGINE=INNODB;


INSERT INTO country
VALUES ('England'),
       ('France'),
       ('Germany'),
       ('Italy'),
       ('Norway'),
       ('Poland'),
       ('Scotland'),
       ('Spain'),
       ('Sweden'),
       ('Ukraine');


INSERT INTO drugstore
VALUES (10, 'Apoteket Korpen'),
       (7, 'Boots'),
       (6, 'Dosfarma'),
       (3, 'Eurapon'),
       (9, 'KomplettApotek'),
       (5, 'La Spezia'),
       (4, 'Pharmacie'),
       (8, 'Pharmacy'),
       (1, 'Podorozhnyk'),
       (2, 'Zielona');


INSERT INTO city
VALUES (1, 'Lviv', 'Ukraine'),
       (2, 'Krakiv', 'Poland'),
       (3, 'Berlin', 'Germany'),
       (4, 'Paris', 'France'),
       (5, 'Rome', 'Italy'),
       (6, 'Barcelona', 'Spain'),
       (7, 'London', 'England'),
       (8, 'Edinburg', 'Scotland'),
       (9, 'Oslo', 'Norway'),
       (10, 'Stockholm', 'Sweden');


INSERT INTO producer
VALUES (1, 'Farmak', 'Ukraine'),
       (2, 'Biowet Pylawy', 'Poland'),
       (3, 'Dermapharm', 'Germany'),
       (4, 'Servier', 'France'),
       (5, 'Berlin-Chemie', 'Italy'),
       (6, 'Uriach', 'Spain'),
       (7, 'Morningside', 'England'),
       (8, 'Edinburg-drug', 'Scotland'),
       (9, 'Pharmaceutical', 'Norway'),
       (10, 'ACIHO', 'Sweden');


INSERT INTO department
VALUES (1, 10, 1),
       (2, 11, 2),
       (3, 12, 3),
       (4, 13, 4),
       (5, 14, 5),
       (6, 15, 6),
       (7, 16, 7),
       (8, 17, 8),
       (9, 18, 9),
       (10, 19, 10);


INSERT INTO location
VALUES (1, 'Shevchencko', 1, 1),
       (2, 'Saint Anna', 2, 2),
       (3, 'Rathausplatz', 3, 3),
       (4, 'Via del Corso', 4, 4),
       (5, 'Rue de Roule', 5, 5),
       (6, 'Valenica', 6, 6),
       (7, 'Pall Mall', 7, 7),
       (8, 'Bread St', 8, 8),
       (9, 'Grubeggata', 9, 9),
       (10, 'Hornsgatan', 10, 10);


INSERT INTO drug
VALUES (1, 'Vizyvit', '2022-09-15', '2025-09-15', 1, 5.00, 1, 1),
       (2, 'Linkas', '2022-09-10', '2024-09-10', 0, 6.00, 2, 2),
       (3, 'Rapitus', '2022-08-13', '2026-09-13', 1, 4.00, 3, 3),
       (4, 'Alora', '2022-09-14', '2028-09-14', 1, 10.00, 4, 4),
       (5, 'Solgar', '2022-09-10', '2025-09-10', 1, 9.00, 5, 5),
       (6, 'Now', '2022-09-12', '2025-11-12', 1, 5.00, 6, 6),
       (7, 'Diahema', '2022-08-03', '2026-11-03', 0, 5.00, 7, 7),
       (8, 'Cartigen', '2022-07-04', '2027-09-04', 0, 7.00, 8, 8),
       (9, 'Pemovo', '2022-08-16', '2028-10-16', 1, 11.00, 9, 9),
       (10, 'A-Keton', '2022-09-01', '2025-09-01', 1, 3.00, 10, 10);


INSERT INTO primary_package
VALUES (1, 'drops', 1),
       (2, 'spray', 2),
       (3, 'pills', 3),
       (4, 'pills', 4),
       (5, 'ointment', 5),
       (6, 'drops', 6);


INSERT INTO category_of_drug
VALUES (1, 1, 'for the eyes', 1),
       (2, 1, 'for the throat', 2),
       (3, 1, 'for the stomach', 3),
       (4, 1, 'from a headache', 4),
       (5, 1, 'from injures', 5),
       (6, 1, 'for the nose', 5);

INSERT INTO composition_of_drug
VALUES (1, 'naphazoline', 1),
       (2, 'benzydamine', 2),
       (3, 'simethicone', 3),
       (4, 'indomethacin', 4),
       (5, 'xylomethazoline', 5);


INSERT INTO use_of_drug
VALUES (1, 'for adults', 1),
       (2, 'without age restriction', 2),
       (3, 'for adults', 3),
       (4, 'without age restriction', 4),
       (5, 'for adults', 5);


CREATE INDEX drug_indx ON drug (name, production_date, expiration_date);
CREATE INDEX producer_indx ON producer (name);
CREATE INDEX drugstore_indx ON drugstore (name);
CREATE INDEX active_ingredients_indx ON composition_of_drug (active_ingredients);
CREATE INDEX use_type_indx ON use_of_drug (use_type);
CREATE INDEX package_indx ON primary_package (type_packaging);

SHOW INDEX FROM producer;




