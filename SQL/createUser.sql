CREATE TABLE user (
	id int,
	username VARCHAR(20), 
    password VARCHAR(512),
	species VARCHAR(20), 
    sex CHAR(1), 
    birth DATE, 
    death DATE,
    account_non_expired bool,
    account_non_locked bool,
    credentials_non_expired bool,
    enabled bool,
    PRIMARY KEY (id)
);

insert into user values(
	2,
	'username',
    'password',
	'species',
    '1',
    null,
    null,
    true,
    true,
    true,
    true
);