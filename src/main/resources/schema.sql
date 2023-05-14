create table employee_history(
	id  SERIAL PRIMARY KEY,
	firstName varchar(30),
	lastName varchar(30),
	dateofBirth DATE,
	gender char,
	weight integer,
	height integer,
	date2  TIMESTAMP DEFAULT NOW(),
	indexResult integer,
	indexRange integer
)
