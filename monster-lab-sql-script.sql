create table scientists(
	scientist_id varchar primary key,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	email varchar(255) unique not null,
	username varchar(50) unique not null,
	password varchar(50) not null 	
);

select * from scientists;

truncate table scientists ;
drop table scientists;

delete from scientists where first_name = 'valid';

create table monsters(
	monster_id varchar check (monster_id <> ''),
	monster_name varchar not null check (monster_name <> ''),
	monster_type varchar not null check (monster_type <> ''),
	strength varchar not null check (strength <> ''),
	dexterity varchar not null check (dexterity <> ''),
	intelligence varchar not null check (intelligence <> ''),
	creator_id varchar not null check (creator_id <> ''),
	constraint monsters_pk primary key (monster_id),
	constraint monster_creator_fk	foreign key  (creator_id)references scientists(scientist_id)
);
select * from monsters;
drop table monsters;

