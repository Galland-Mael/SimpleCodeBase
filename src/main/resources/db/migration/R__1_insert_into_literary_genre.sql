INSERT INTO s_literary_type (id, code, label)
VALUES
    (1, 'FICTION', 'Fiction'),
    (2, 'POETRY', 'Poetry'),
    (3, 'DRAMA', 'Drama'),
    (4, 'SCIENCE_FICTION', 'Science Fiction'),
    (6, 'MYSTERY', 'Mystery'),
    (7, 'HISTORICAL', 'Historical'),
    (8, 'ROMANCE', 'Romance'),
    (9, 'THRILLER', 'Thriller')
ON CONFLICT (id) DO UPDATE
SET code = excluded.code,
    label = excluded.label;
