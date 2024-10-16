CREATE TABLE library_client
(
    library_id BIGINT NOT NULL,
    client_id  BIGINT NOT NULL,
    PRIMARY KEY (library_id, client_id),
    CONSTRAINT fk_library FOREIGN KEY (library_id) REFERENCES library (id),
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE INDEX idx_library_client_library_id ON library_client (library_id);
CREATE INDEX idx_library_client_client_id ON library_client (client_id);