drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

CREATE TABLE IF NOT EXISTS problems (
    problem_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    problem_name TEXT,
    code_problem TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS test (
    case_test_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    params TEXT NOT NULL,
    result TEXT NOT NULL,
    problem_id BIGINT,
    FOREIGN KEY (problem_id) REFERENCES problems (problem_id)
);

CREATE TABLE IF NOT EXISTS solution (
    solution_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    author_name TEXT NOT NULL,
    file_name TEXT NOT NULL,
    status TINYINT,
    problem_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY (problem_id) REFERENCES problems (problem_id)
);

INSERT INTO problems (problem_name, code_problem)
VALUES (
    'Mergulho',
    'A');

INSERT INTO test (params, result, problem_id)
VALUES ('5 5\n1 2 3 4 5', '6 7 8 9 10', 1);

INSERT INTO test (params, result, problem_id)
VALUES ('7 5\n1 3 5 6 7', '2 4 8 9 10 11 12', 1);
