CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

insert into users(username, password)
values
('Kiro','pass'),
('Ivan','pass'),
('Niki','pass'),
('Bobi','pass'),
('Vovi','pass');

select * from users;