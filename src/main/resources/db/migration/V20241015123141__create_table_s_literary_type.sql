CREATE TABLE s_literary_type
(
    id   BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    code VARCHAR(50) NOT NULL,
    label VARCHAR(50) NOT NULL
);