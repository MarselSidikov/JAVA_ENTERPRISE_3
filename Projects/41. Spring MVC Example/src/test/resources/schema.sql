DROP TABLE IF EXISTS account_room;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS simple_user;

CREATE TABLE simple_user
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    email        VARCHAR(250),
    password     VARCHAR(250) NOT NULL,
    confirmcode VARCHAR(250) DEFAULT NULL
);