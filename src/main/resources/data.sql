DROP TABLE IF EXISTS players;

CREATE TABLE players (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL

);

INSERT INTO players (name) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');