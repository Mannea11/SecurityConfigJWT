CREATE TABLE IF NOT EXISTS Address (
   id INT AUTO_INCREMENT PRIMARY KEY,
   postal_code INT NOT NULL,
    city VARCHAR NOT NULL,
   street VARCHAR NOT NULL
    );

CREATE TABLE IF NOT EXISTS members (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    address INT NOT NULL,
    email VARCHAR NOT NULL,
    phone VARCHAR,
    date_of_birth DATE NOT NULL,
    FOREIGN KEY (address) REFERENCES Address(id)
    );

