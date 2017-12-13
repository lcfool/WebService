DROP TABLE IF EXISTS users;

CREATE TABLE users(
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    age INT(11) NOT NULL,
    token VARCHAR(255),
    active BOOLEAN,
    PRIMARY KEY (username)
)ENGINE=innoDB DEFAULT CHARSET=utf8;