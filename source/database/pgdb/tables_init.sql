CREATE DATABASE locketdb;

\c locketdb;

CREATE TABLE IF NOT EXISTS users (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	username TEXT
);

CREATE TABLE IF NOT EXISTS msg (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	sender_id BIGSERIAL,
	receiver_id BIGSERIAL,
	FOREIGN KEY (sender_id) REFERENCES users (id),
	FOREIGN KEY (receiver_id) REFERENCES users (id)
);
