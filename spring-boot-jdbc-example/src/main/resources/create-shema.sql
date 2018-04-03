DROP TABLE IF EXISTS test_users;

CREATE TABLE test_users
(
  id SERIAL NOT NULL CONSTRAINT test_users_pkey PRIMARY KEY,
  login    VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  createdate TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

INSERT INTO test_users (login, password) VALUES ('test1','password1');
INSERT INTO test_users (login, password) VALUES ('test2','password2');
INSERT INTO test_users (login, password) VALUES ('test3','password3');
INSERT INTO test_users (login, password) VALUES ('test4','password4');
INSERT INTO test_users (login, password) VALUES ('test5','password5');
