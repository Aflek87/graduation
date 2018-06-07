DROP TABLE IF EXISTS dish;
DROP TABLE IF EXISTS voting;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS restoran;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
  );

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restoran
(
  id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name   VARCHAR(255),
  description   VARCHAR(255)
);

CREATE TABLE menu
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  operdate    TIMESTAMP    NOT NULL,
  restoran    INTEGER      NOT NULL,
  FOREIGN KEY (restoran) REFERENCES RESTORAN (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX menu_unique_restoran_datetime_idx ON menu (restoran, operdate);

CREATE TABLE dish
(
  id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  menu    INTEGER      NOT NULL,
  name    VARCHAR(255),
  price   VARCHAR(255),
  FOREIGN KEY (menu) REFERENCES MENU (id) ON DELETE CASCADE
);

CREATE TABLE voting
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  operdate TIMESTAMP NOT NULL,
  menu     INTEGER   NOT NULL,
  user_id     INTEGER   NOT NULL,
  FOREIGN KEY (menu) REFERENCES MENU (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
)

