drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

CREATE TABLE IF NOT EXISTS problems (
    problem_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    problem_name TEXT,
    code_problem TEXT NOT NULL,
    output BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS test (
    case_test_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    result TINYINT,
    code TEXT NOT NULL,
    problem_id BIGINT,
    FOREIGN KEY (problem_id) REFERENCES problems (problem_id)
);

CREATE TABLE IF NOT EXISTS solution (
    solution_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    author_name TEXT NOT NULL,
    file_name TEXT NOT NULL,
    status TINYINT,
    problem_code TEXT,
    created_at TIMESTAMP NOT NULL
);

