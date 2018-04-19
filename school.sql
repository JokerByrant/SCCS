create table t_student(
   sid  int primary key auto_increment,
   name varchar(30) not null unique,
   password varchar(30) not null
);

create table t_course(
  cid varchar(20) primary key auto_increment,
  cname varchar(30) not null unique,
  tid int,
  constraint course_teacher_id foreign key(tid) references t_teacher(tid)
);

create table t_teacher(
  tid int primary key auto_increment,
  name varchar(30) not null unique,
  password varchar(30) not null
);

create table t_choose(
   sid int,
   cid varchar(20),
   tid int,
);


