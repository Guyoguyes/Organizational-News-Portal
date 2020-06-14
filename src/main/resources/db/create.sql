SET MODE postgresql;

CREATE TABLE IF NOT EXISTS departments(
    id int PRIMARY  KEY auto_increment,
    name VARCHAR,
    description VARCHAR
);

CREATE TABLE IF NOT EXISTS employees (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    position VARCHAR,
    role VARCHAR,
    departmentId VARCHAR
)