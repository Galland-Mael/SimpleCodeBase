CREATE TABLE author
(
    id                       BIGINT PRIMARY KEY,
    age                      INT NOT NULL,
    FOREIGN KEY (id) REFERENCES person (id)
);

CREATE INDEX idx_author_setting_literary_type_id ON author (setting_literary_type_id);
