CREATE TABLE author
(
    id                       BIGINT PRIMARY KEY,
    age                      INT NOT NULL,
    FOREIGN KEY (id) REFERENCES person (id)
);
