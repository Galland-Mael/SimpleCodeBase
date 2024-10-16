CREATE TABLE client
(
    id         BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES person (id)
)