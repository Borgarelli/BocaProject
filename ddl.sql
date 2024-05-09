CREATE TABLE IF NOT EXISTS problems (
    problem_id INTEGER PRIMARY KEY AUTOINCREMENT,
    problem_name TEXT,
    code_problem TEXT NOT NULL UNIQUE,
    output INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS caseTests (
    case_test_id INTEGER PRIMARY KEY AUTOINCREMENT,
    result INTEGER,
    code TEXT NOT NULL,
    problem_id INTEGER,
    FOREIGN KEY (problem_id) REFERENCES problems (problem_id)
);

CREATE TABLE IF NOT EXISTS solution (
    solution_id INTEGER PRIMARY KEY AUTOINCREMENT,
    author_name TEXT NOT NULL,
    file_name TEXT NOT NULL,
    status TEXT,
    problem_code TEXT,
    created_at TEXT NOT NULL
);
