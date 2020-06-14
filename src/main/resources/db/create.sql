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
);

CREATE TABLE IF NOT EXISTS news (
    id int PRIMARY KEY auto_increment,
    headline VARCHAR,
    content VARCHAR ,
    author VARCHAR ,
    departmentId INTEGER
)