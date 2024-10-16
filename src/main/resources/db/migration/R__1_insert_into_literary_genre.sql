INSERT INTO setting_literary_type (code, label)
VALUES
    ( 'FICTION', 'Fiction'),
    ( 'POETRY', 'Poetry'),
    ( 'DRAMA', 'Drama'),
    ( 'SCIENCE_FICTION', 'Science Fiction'),
    ( 'MYSTERY', 'Mystery'),
    ( 'HISTORICAL', 'Historical'),
    ( 'ROMANCE', 'Romance'),
    ( 'THRILLER', 'Thriller')
ON CONFLICT (id) DO UPDATE
SET code = excluded.code,
    label = excluded.label;
