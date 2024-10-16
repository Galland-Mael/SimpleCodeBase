CREATE TABLE author
(
    id  BIGINT PRIMARY KEY,
    age INT NOT NULL,
    s_literary_type_id   BIGINT,
    FOREIGN KEY (s_literary_type_id) REFERENCES s_literary_type (id),
    FOREIGN KEY (id) REFERENCES person (id)
);

CREATE INDEX idx_author_s_literary_type_id ON author (s_literary_type_id);
