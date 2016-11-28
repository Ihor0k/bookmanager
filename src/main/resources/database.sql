#Table: books
CREATE TABLE books (
  id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title       VARCHAR(255) NOT NULL,
  author      VARCHAR(255) NOT NULL,
  description VARCHAR(2047)         DEFAULT NULL,
  filename    VARCHAR(255) NOT NULL,
  user_id     INT          NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id)
)
  ENGINE = InnoDB;

#Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role     VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

#Table: comment
CREATE TABLE comments (
  id      INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  text    VARCHAR(2047) NOT NULL,
  time    DATETIME      NOT NULL,
  user_id INT           NOT NULL,
  book_id INT           NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (book_id) REFERENCES books (id)
)
  ENGINE = InnoDB;