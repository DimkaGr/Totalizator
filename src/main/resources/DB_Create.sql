DROP DATABASE IF EXISTS totalizator;
CREATE DATABASE totalizator DEFAULT CHARACTER SET utf8 ;
USE totalizator;
CREATE TABLE role (
id INT NOT NULL AUTO_INCREMENT,
name ENUM('admin','user','bookmaker') NOT NULL,
PRIMARY KEY (id));
INSERT INTO role(name) VALUES('admin');
INSERT INTO role(name) VALUES('user');
INSERT INTO role(name) VALUES('bookmaker');
CREATE TABLE client_account (
id INT NOT NULL AUTO_INCREMENT,
status ENUM('banned','active','not client') NOT NULL,
user_cash DOUBLE NOT NULL,
PRIMARY KEY (id));
INSERT INTO client_account VALUES(-1,'not client',0.0);
CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
login VARCHAR(45) NOT NULL,
password VARCHAR(64) NOT NULL,
email VARCHAR(45) NOT NULL,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
role_id INT NOT NULL,
client_account_id INT,
PRIMARY KEY (id),
CONSTRAINT fk_client_account_id FOREIGN KEY (client_account_id) REFERENCES client_account(id)  ON DELETE CASCADE,
CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE);
CREATE TABLE competition_result (
id INT NOT NULL AUTO_INCREMENT,
result VARCHAR(100) NOT NULL,
PRIMARY KEY (id));
CREATE TABLE kind_of_sport (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
PRIMARY KEY (id));
CREATE TABLE competition_events (
id INT NOT NULL AUTO_INCREMENT,
event_name VARCHAR(45) NOT NULL,
factor DOUBLE NOT NULL,
PRIMARY KEY (id));
CREATE TABLE competition (
id INT NOT NULL AUTO_INCREMENT,
date DATETIME NOT NULL,
participant_1 VARCHAR(45) NOT NULL,
participant_2 VARCHAR(45) NOT NULL,
kind_of_sport_id INT NOT NULL,
competition_result_id INT NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_kind_of_sport_id FOREIGN KEY (kind_of_sport_id) REFERENCES kind_of_sport (id) ON DELETE CASCADE,
CONSTRAINT fk_competition_result_id FOREIGN KEY (competition_result_id) REFERENCES competition_result (id) ON DELETE CASCADE);
CREATE TABLE bet (
id INT NOT NULL AUTO_INCREMENT,
min_value DOUBLE NOT NULL,
competition_id INT NOT NULL,
competition_events_id INT NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_competition_id FOREIGN KEY (competition_id) REFERENCES competition (id) ON DELETE CASCADE,
CONSTRAINT fk_competition_event_id FOREIGN KEY (competition_events_id) REFERENCES competition_events (id) ON DELETE CASCADE);
CREATE TABLE client_bet (
id INT NOT NULL AUTO_INCREMENT,
deposit DOUBLE NOT NULL,
status VARCHAR(10) NOT NULL,
income DOUBLE NOT NULL,
bet_id INT NOT NULL,
users_id INT NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_bet_id FOREIGN KEY (bet_id) REFERENCES bet (id) ON DELETE CASCADE,
CONSTRAINT fk_users_id FOREIGN KEY (users_id) REFERENCES users (id) ON DELETE CASCADE);

