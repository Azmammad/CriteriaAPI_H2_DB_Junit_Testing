CREATE TABLE app_user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255),
                          age INTEGER
);

INSERT INTO app_user (username, age) VALUES ('john_doe', 30);
INSERT INTO app_user (username, age) VALUES ('jane_doe', 25);
INSERT INTO app_user (username, age) VALUES ('mary_doe', 35);
INSERT INTO app_user (username, age) VALUES ('alfa_doe', 20);

