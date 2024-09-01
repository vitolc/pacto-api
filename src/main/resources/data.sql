/****************************  EXTENSIONS HERE  *****************************/

CREATE EXTENSION IF NOT EXISTS unaccent;

/****************************   END EXTENSIONS  *****************************/


/****************************  SEQUENCES HERE  *****************************/

CREATE SEQUENCE IF NOT EXISTS users_id_seq START WITH 1 INCREMENT BY 1;

/****************************  END SEQUENCES   *****************************/

/****************************   TABLES HERE  ****************************/

CREATE TABLE IF NOT EXISTS users
(
    id                          INT8                    DEFAULT nextval('users_id_seq') PRIMARY KEY,
    name                        VARCHAR(78)             NOT NULL,
    email                       VARCHAR(78)             NOT NULL,
    password                    VARCHAR(255)            NOT NULL,
    role                        VARCHAR(5)              NOT NULL
);

/****************************   END TABLES  ****************************/

INSERT INTO "users" (name, email, password, role)
SELECT 'Admin', 'admin@example.com', '$2a$10$MvVyyWr5kYvdCT8hc93ulOUkZptmUI69vnpw4xnAoKk9q31HZfrXa', 'ADMIN'
    WHERE NOT EXISTS (
    SELECT 1 FROM "users"
    WHERE email = 'admin@example.com'
);
