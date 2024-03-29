drop database ProyectoAdminHorario;
create database ProyectoAdminHorario;
use ProyectoAdminHorario;
drop table if exists Cursos;
create table Cursos(
    CLAVE varchar(10),
    SECC int,
    TITULO varchar(30),
    PROF varchar(30),
    primary key (CLAVE, SECC),
    constraint restriccion_de_seccion check (SECC>= 0)
);
drop table if exists Salones;
create table Salones(
    IDSALON varchar(8) not null primary key,
    CAPACIDAD int,
    TIPO varchar(3),
	constraint restriccion_de_capacidad check (CAPACIDAD > 0)
);

drop table if exists Periodos;
create table Periodos(
    TITULO varchar(20) not null primary key,
    FECHAINICIO date,
    FECHAFIN date
);

#Duracion no menor a 0#
drop table if exists Reservacionescursossalones;
create table Reservaciones(
    IDSALON varchar(8) not null,
	NOMBRE varchar(30) not null,
    FECHAHORA date not null,
    DURACION integer not null,
    constraint restriccion_de_duracion_reservaciones check (DURACION >= 0),
    #Define una llave foranea con el nombre FK_Salones, usando el atributo reservaciones.IDSALON
    #y este hace referencia al atributo IDSALON de la tabla Salon.
    constraint FK_Salones_Reservaciones foreign key (IDSALON) references Salones (IDSALON) on delete cascade,
    constraint PK_Reservaciones primary key (IDSALON, NOMBRE, FECHAHORA )
);

drop table if exists Horarios;
create table Horarios(
    CLAVE varchar(10) not null,
	SECC integer not null,
    DIASEM integer not null,
    HORA integer not null,
    MINUTO integer,
    DURACION integer,
    PERIODO varchar(20),
    SEMESTRE integer,
    IDSALON varchar(8),
    #restricción duracion dia de la semana que este entre 1 y 7
    constraint restriccion_de_diasem check (DIASEM >= 1 and DIASEM <=7),
    constraint restriccion_de_hora check (HORA >= 0 and HORA <=23),
    constraint restriccion_de_minuto check (MINUTO >=0 and MINUTO <=59),
    constraint restriccion_de_semestre check (SEMESTRE >=1 and SEMESTRE <=9),
    constraint restriccion_de_duracion_horarios check (DURACION >= 0),	
	# haciendo relacion con la tabla de cursos (derecha) y con la tabla Horarios (izquierda)
    ##foreign key= llave foránea
    constraint FK_Cursos_Horarios foreign key (CLAVE, SECC) references Cursos (CLAVE, SECC) on delete cascade,
    ##on delete cascade: si se borra salones, que se borre también aquí.
    constraint FK_Salones_Horarios foreign key (IDSALON) references Salones (IDSALON) on delete cascade,
	#primary key= llave primaria
	#indentificar registros y evitar que no se repitan.
    constraint PK_Cursos primary key (CLAVE, SECC, DIASEM, HORA),
    
     constraint FK_Periodos_Horarios foreign key (PERIODO) references Periodos (TITULO) on delete cascade

);

/*create table Periodos_tiene_Cursos(
    CLAVE varchar(10) not null,
	SECC integer not null,
    TITULO varchar(20) not null,
	constraint TieneCursos foreign key (CLAVE, SECC) references Cursos (CLAVE, SECC) on delete cascade,
    constraint TienePeriodos foreign key (TITULO) references Periodos (TITULO) on delete cascade 
);
*/

insert into Cursos (CLAVE, SECC, TITULO, PROF)
values ("LIS-2082", 01, "Análisis matemático 2", "Hugo Villanueva");

insert into Salones
values ("IA104", 20, "SC");
insert into Salones
values ("IA105", 30, "C");

insert into Periodos
values ("PRIMAVERA-23", "2023-01-10", "2023-05-07");

#
#insert into Periodos_tiene_cursos values ("LIS-2082", 01, "PRIMAVERA-23");
#select * FROM Periodos_tiene_cursos inner join Periodos Where Periodos_tiene_cursos.TITULO = periodos.TITULO;
drop table Periodos_tiene_cursos;
insert into Horarios values ("LIS-2082", 1, 1, 12, 30, 75, "PRIMAVERA-22", 4, "IA105");
#se hace una selección por parte de cursos y horarios.

select * FROM Cursos inner join Horarios Where Cursos.SECC = Horarios.SECC;

Select * FROM Salones;
Select * FROM Horarios;
Select * FROM Reservaciones;
Select * FROM Cursos;
Select IDSALON 
delimiter ** 
create procedure CrearReservacion (IDSALON varchar(8), NOMBRE varchar(30), FECHAHORA date, DURACION integer) 
begin 
   insert into Reservaciones (IDSALON, NOMBRE, FECHAHORA, DURACION) values (IDSALON, NOMBRE, FECHAHORA, DURACION);
   end; **
delimiter ;

call CrearReservacion ("IA104", "ARMANDO", "2022-01-10", 75); 
call CrearReservacion ("IA105", "ROBERTO", "2022-01-10", 75);

Select CLAVE, SECC FROM CURSOS;

drop procedure if exists VerificarPeriodosPorAnio;

delimiter ** 
create procedure VerificarPeriodosPorAnio(Anio varchar(4))
begin 

   #declare @CantidadDePeriodos integer(2); #concatenacion
   set @CantidadDePeriodos := (select count(*) FROM Periodos where year (FECHAINICIO) = Anio);
   if (@CantidadDePeriodos = 0) then 
	insert into Periodos values (concat("PRIMAVERA-",substring(Anio,3,3)),concat(Anio, "-01-10"), concat(Anio, "-05-07"));
    insert into Periodos values (concat("VERANO-", substring(Anio,3,3)),concat(Anio, "-05-17"), concat(Anio, "-06-07"));
    insert into Periodos values (concat("OTOÑO-", substring(Anio,3,3)),concat(Anio, "-08-6"), concat(Anio, "-11-24"));
    end if;
    select * FROM Periodos where  year (FECHAINICIO) >= Anio;
   end; **
delimiter ;

call VerificarPeriodosPorAnio ("2023");
select * FROM Periodos;
