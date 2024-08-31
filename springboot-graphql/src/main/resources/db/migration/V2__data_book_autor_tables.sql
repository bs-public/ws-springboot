INSERT INTO author (first_name, last_name, nationality, biography)
VALUES 
('George', 'Orwell', 'British', 'George Orwell was an English novelist, essayist, journalist and critic.'),
('Jane', 'Austen', 'British', 'Jane Austen was an English novelist known primarily for her six major novels.'),
('Mark', 'Twain', 'American', 'Mark Twain was an American writer, humorist, entrepreneur, publisher, and lecturer.'),
('Fyodor', 'Dostoevsky', 'Russian', 'Fyodor Dostoevsky was a Russian novelist, short story writer, essayist, and journalist.');


INSERT INTO book (title, author_id, published_date, isbn, pages, language, publisher, genre)
VALUES 
('1984', 1, '1949-06-08', '9780451524935', 328, 'English', 'Secker & Warburg', 'Dystopian'),
('Pride and Prejudice', 2, '1813-01-28', '9780679783268', 279, 'English', 'T. Egerton', 'Romance'),
('Adventures of Huckleberry Finn', 3, '1884-12-10', '9780486280615', 366, 'English', 'Chatto & Windus', 'Adventure'),
('Crime and Punishment', 4, '1866-01-01', '9780143058144', 671, 'Russian', 'The Russian Messenger', 'Psychological Fiction');
