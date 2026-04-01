CREATE TABLE citizens (
    id BIGSERIAL PRIMARY KEY,
    identification VARCHAR(50) NOT NULL,
    kindof VARCHAR(50),
    name VARCHAR(100) NOT NULL,
    age INT,
    gender CHAR(1),
    imageurl TEXT
);
INSERT INTO citizens (identification, kindof, name, age, gender, imageurl) VALUES
('123456789', 'employee', 'Alice Smith', 30, 'F', 'https://example.com/images/alice.jpg'),
('987654321', 'contractor', 'Bob Johnson', 45, 'M', 'https://example.com/images/bob.jpg'),
('456123789', 'employee', 'Carol White', 28, 'F', 'https://example.com/images/carol.jpg'),
('789456123', 'intern', 'David Brown', 22, 'M', 'https://example.com/images/david.jpg'),
('321654987', 'employee', 'Eva Green', 35, 'F', 'https://example.com/images/eva.jpg');