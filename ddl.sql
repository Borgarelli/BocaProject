drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

CREATE TABLE IF NOT EXISTS problems (
    problem_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    problem_name TEXT,
    problem_code TEXT NOT NULL
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
    problem_code VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);

INSERT INTO problems (problem_name, problem_code)
VALUES (
    'Mergulho',
    'A');

INSERT INTO test (params, result, problem_id)
VALUES ('5 5\n1 2 3 4 5', '1 2 3 4 5', 1);


INSERT INTO test (params, result, problem_id)
VALUES ('7 5\n1 3 5 6 7', '2 4 6 7', 1);
