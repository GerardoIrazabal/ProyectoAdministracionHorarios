create database Ejemplo;
use Ejemplo;
drop table Cursos;
create table Cursos(
    CLAVE varchar(10),
    SECC int,
    TITULO varchar(30),
    PROF varchar(30),
    primary key (CLAVE, SECC)
);
create table Salones(
    IDSALON varchar(8) not null primary key,
    CAPACIDAD int,
    TIPO varchar(3)
);
select *
FROM Cursos;
insert into Cursos
values (
        "LIS",
        208201,
        "Análisis matemático",
        "Hugo Villanueva"
    );
insert into Cursos
values (
        "lISS",
        208201,
        "Análisis matemático 2",
        "Hugo Villanueva"
    );
select IDSALON,
    CAPACIDAD
FROM Salones;
insert into Salones
values ("IA104", 5, "C");
select *
FROM Salones;
update Salones
set CAPACIDAD = 25
where IDSALON = "IA104";
insert into Salones
values ("IA105", 20, "SC");
select avg(CAPACIDAD)
FROM Salones;
create table PERIODOS(
    TITULO varchar(20) not null primary key,
    FECHAINICIO date,
    FECHAFIN date
);
drop table PERIODOS;
insert into PERIODOS
values ("Primavera", "2022-01-10", "2022-05-07");
select *
FROM PERIODOS;
insert into PERIODOS
values ("Primavera 2", curdate(), "2022-05-07");
delete FROM PERIODOS
insert into Reservaciones values ("LIS-0122", "ARMANDO", "2022-01-10", 60) 
where TITULO = "Primavera 2";
delete FROM PERIODOS;
SET SQL_SAFE_UPDATES = 0;