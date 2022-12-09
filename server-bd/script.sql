drop table if exists students;
create table students(
	dni char(8),
    nombres varchar(50),
    nota1 decimal(5,2),
    nota2 decimal(5,2),
    nota3 decimal(5,2),
    nota4 decimal(5,2),
    promedio decimal(5,2),
    primary key(dni)
);