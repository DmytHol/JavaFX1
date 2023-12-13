CREATE TABLE coach (
    coach_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    studio VARCHAR(100),
    city VARCHAR(55)
);
-- number_of_students will be calculayed by the number of students in the couple table

CREATE TABLE couple (
    couple_id INT PRIMARY KEY,
    coach_id INT, -- Assuming a coach is associated with a couple
    CONSTRAINT couple_coach_id_fk FOREIGN KEY (coach_id) REFERENCES Coach(coach_id)
);

CREATE TABLE dancer (
    dancer_id INT PRIMARY KEY AUTO_INCREMENT,
    fname VARCHAR(30),
    lname VARCHAR(30),
    birthdate DATE,
    dance_level VARCHAR(30)
);


CREATE TABLE dancer_couple (
    dancer_id INT,
    couple_id INT,
    CONSTRAINT dancer_couple_pk PRIMARY KEY (dancer_id, couple_id),
    CONSTRAINT dancer_couple_dancer_id_fk FOREIGN KEY (dancer_id) REFERENCES Dancer(dancer_id),
    CONSTRAINT dancer_couple_couple_id_fk FOREIGN KEY (couple_id) REFERENCES Couple(couple_id)
);


-- Insert dummy data into the coach table
INSERT INTO coach (first_name, last_name, studio, city)
VALUES
    ('John', 'Smith', 'Studio A', 'New York'),
    ('Alice', 'Johnson', 'Dance Studio X', 'Los Angeles'),
    ('Bob', 'Williams', 'Dance Haven', 'Chicago'),
    ('Eva', 'Davis', 'Dance Unlimited', 'Miami'),
    ('Chris', 'Martin', 'City Dance Studio', 'San Francisco'),
    ('Olivia', 'Wilson', 'Studio 123', 'Dallas'),
    ('Michael', 'Jones', 'Elite Dance Center', 'Houston'),
    ('Sophia', 'Clark', 'Dance World', 'Atlanta'),
    ('David', 'Taylor', 'Studio XYZ', 'Seattle'),
    ('Emma', 'Moore', 'Dynamic Dance', 'Denver');

-- Insert dummy data into the couple table
INSERT INTO couple (couple_id, coach_id)
VALUES
    (1, 1), (2, 2), (3, 3),
    (4, 4), (5, 5), (6, 6),
    (7, 7), (8, 8), (9, 9),
    (10, 10);

-- Insert dummy data into the dancer table
INSERT INTO dancer (dancer_id, fname, lname, birthdate, dance_level)
VALUES
    (1, 'Emily', 'Johnson', '1990-05-15', 'Intermediate'),
    (2, 'Daniel', 'Miller', '1995-08-22', 'Advanced'),
    (3, 'Sophie', 'Davis', '1992-03-10', 'Beginner'),
    (4, 'Matthew', 'Brown', '1988-12-03', 'Intermediate'),
    (5, 'Olivia', 'Lee', '1993-06-28', 'Advanced'),
    (6, 'Henry', 'Smith', '1998-02-17', 'Beginner'),
    (7, 'Ava', 'Wang', '1991-09-05', 'Intermediate'),
    (8, 'Logan', 'Garcia', '1997-04-12', 'Advanced'),
    (9, 'Grace', 'Hernandez', '1985-11-20', 'Beginner'),
    (10, 'Carter', 'Lopez', '1996-07-08', 'Intermediate');

-- Insert dummy data into the dancer_couple table
INSERT INTO dancer_couple (dancer_id, couple_id)
VALUES
    (1, 1), (2, 1), (3, 2),
    (4, 2), (5, 3), (6, 3),
    (7, 4), (8, 4), (9, 5),
    (10, 5);



