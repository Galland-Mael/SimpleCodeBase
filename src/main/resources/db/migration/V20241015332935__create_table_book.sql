CREATE TABLE book (
  id BIGINT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  identifiant VARCHAR(255) NOT NULL,
  publication_year DATE NOT NULL,
  author_id BIGINT NOT NULL,
  FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE INDEX idx_book_author_id ON book(author_id);