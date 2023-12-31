CREATE DATABASE tlocket;

\c tlocket;

CREATE TABLE IF NOT EXISTS users (
	username TEXT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS msg (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	content TEXT,
	sender_uname TEXT,
	receiver_uname TEXT,
	FOREIGN KEY (sender_uname) REFERENCES users (username),
	FOREIGN KEY (receiver_uname) REFERENCES users (username)
);
