CREATE TABLE library_book
(
    library_id BIGINT NOT NULL,
    book_id    BIGINT NOT NULL,
    PRIMARY KEY (library_id, book_id),
    FOREIGN KEY (library_id) REFERENCES library (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);