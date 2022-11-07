CREATE TABLE sandwiches (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_sandwiches PRIMARY KEY (id)
);

--ALTER TABLE sandwich_components ADD sandwich_id INT;

ALTER TABLE sandwich_components ADD CONSTRAINT FK_SANDWICHCOMPONENTS_ON_SANDWICH FOREIGN KEY (sandwich_id) REFERENCES sandwiches (id);