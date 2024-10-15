CREATE TABLE library_book
(
    library_id BIGINT NOT NULL,
    book_id    BIGINT NOT NULL,
    PRIMARY KEY (library_id, book_id)
)