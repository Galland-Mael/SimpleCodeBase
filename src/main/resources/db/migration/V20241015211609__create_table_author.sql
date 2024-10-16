CREATE TABLE author
(
    id  BIGINT PRIMARY KEY,
    age INT NOT NULL,
    setting_literary_type_id   BIGINT,
    FOREIGN KEY (setting_literary_type_id) REFERENCES setting_literary_type (id),
    FOREIGN KEY (id) REFERENCES person (id)
);

CREATE INDEX idx_author_setting_literary_type_id ON author (setting_literary_type_id);
