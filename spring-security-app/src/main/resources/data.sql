INSERT INTO users (username,password,enabled)
VALUES ('user','pass',TRUE);

INSERT INTO users (username,password,enabled)
VALUES ('admin','pass',TRUE);

INSERT INTO authorities (username,authority)
VALUES ('user','ROLE_USER');
INSERT INTO authorities (username,authority)
VALUES ('admin','ROLE_ADMIN');