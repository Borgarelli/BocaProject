drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

CREATE TABLE IF NOT EXISTS problems (
    problem_id INTEGER PRIMARY KEY auto_increment,
    problem_name TEXT,
    code_problem TEXT NOT NULL,
    output INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS case_Test (
    case_test_id INTEGER PRIMARY KEY auto_increment,
    result INTEGER,
    code TEXT NOT NULL,
    problem_id INTEGER,
    FOREIGN KEY (problem_id) REFERENCES problems (problem_id)
);

CREATE TABLE IF NOT EXISTS solution (
    solution_id INTEGER PRIMARY KEY auto_increment,
    author_name TEXT NOT NULL,
    file_name TEXT NOT NULL,
    status TEXT,
    problem_code TEXT,
    created_at TEXT NOT NULL
);
