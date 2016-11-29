create database raolong default character set utf8;

/*用户登录信息表*/
drop table if exists user;
create table if not exists user(
      id int primary key auto_increment,
      userId varchar(10) unique,
      password varchar(15) not null,
      user_name varchar(30),
      class_abbr varchar(15),
      user_level char(1) not null
      )engine=InnoDB default charset=utf8;

set names gbk;
insert into user values(1,'109509308','123456','饶龙龙','09jk01','3');
insert into user values(2,'109509307','123456','王宇辉','09jk02','3');
insert into user values(3,'109509306','123456','乔超峰','09jk01','2');
insert into user values(4,'601409','123456','董建民','09jk01','1');
insert into user values(52,'1001','123456','','','0');
update user set user_name='次仁德吉' where userId='1001';


update user set userId='109509307',user_name='王宇辉',user_level='3',class_abbr='09jk01' where id=2;

/*用户权限表*/
drop table if exists level;
create table if not exists level(
      user_level char(1) primary key,
      user_identity varchar(10)
      )engine=InnoDB default charset=utf8;
      
set names gbk;
insert into level values('0','管理员');
insert into level values('1','班主任');
insert into level values('2','学委');
insert into level values('3','学生');

/*班级信息表*/
drop table if exists class;
create table if not exists class(
       id int primary key auto_increment,
       grade char(3) not null,
       edu_bg char(4) not null,
       major_ID char(4) not null,
       class_name char(4) not null,
       class_abbr varchar(15) unique
       )engine=InnoDB default charset=utf8;

set names gbk;
insert into class values(1,'09','本科','1000','一班','09jk01');

/*专业表*/
drop table if exists major;
create table if not exists major(
      major_ID char(4) primary key,
      major_name varchar(30) not null,
      edu_bg char(4) not null
      )engine=InnoDB default charset=utf8;

set names gbk;
insert into major values('1000','计算机科学与技术','本科');
insert into major values('1001','电子信息科学与技术','本科');
insert into major values('1002','通信工程','本科');
insert into major values('1003','工业工程','本科');
insert into major values('1004','网络工程','本科');
insert into major values('1005','信息管理与信息系统','本科');
insert into major values('2000','计算机信息管理与信息系统','专科');


/*管理员信息表*/
drop table if exists admin;
create table if not exists admin(
      )engine=InnoDB default charset=utf8;
      
      
/*特殊加分表*/
drop table if exists peculiar;
create table if not exists peculiar(
      userId varchar(10) primary key,
      score_1 int default 0,
      score_2 int default 0,
      score_3 int default 0,
      score_4 int default 0,
      score_5 int default 0
      )engine=InnoDB default charset=utf8;     
insert into peculiar(userId)values('109509308');      
  
drop table if exists progress;
create table if not exists progress(
      userId varchar(10) primary key,
      score_1 int default 0,
      score_2 int default 0,
      score_3 int default 0,
      score_4 int default 0,
      score_5 int default 0,
      score_6 int default 0,
      score_7 int default 0,
      score_8 int default 0,
      score_9 int default 0,
      score_10 int default 0
      )engine=InnoDB default charset=utf8;  
insert into progress(userId)values('109509308');  
  
drop table if exists deyu;
create table if not exists deyu(
      userId varchar(10) primary key,
      score_1 int default 0,
      score_2 int default 0,
      score_3 int default 0,
      score_4 int default 0,
      score_5 int default 0,
      score_6 int default 0,
      score_7 int default 0,
      score_8 int default 0,
      score_9 int default 0,
      score_10 int default 0,
      score_11 int default 0,
      score_12 int default 0,
      score_13 int default 0,
      score_14 int default 0,
      score_15 int default 0,
      score_16 int default 0,
      score_17 int default 0,
      score_18 int default 0,
      score_19 int default 0,
      score_20 int default 0,
      score_21 int default 0,
      score_22 int default 0,
      score_23 int default 0,
      score_24 int default 0,
      score_25 int default 0,
      score_26 int default 0
      )engine=InnoDB default charset=utf8;

drop table if exists zhiyu;
create table if not exists zhiyu(
      userId varchar(10) primary key,
      score_1 int default 0,
      score_2 int default 0,
      score_3 int default 0,
      score_4 int default 0,
      score_5 int default 0,
      score_6 int default 0,
      score_7 int default 0,
      score_8 int default 0,
      score_9 int default 0,
      score_10 int default 0,
      score_11 int default 0,
      score_12 int default 0
      )engine=InnoDB default charset=utf8; 
insert into zhiyu(userId)values('109509308');
insert into zhiyu(userId)values('109509307');
insert into zhiyu(userId)values('109509306');


drop table if exists tiyu;
create table if not exists tiyu(
      userId varchar(10) primary key,
      score_1 int default 0,
      score_2 int default 0,
      score_3 int default 0,
      score_4 int default 0,
      score_5 int default 0,
      score_6 int default 0,
      score_7 int default 0
      )engine=InnoDB default charset=utf8;























delete from peculiar where userId='109509306';
  
      
      
select c.id,c.grade,c.edu_bg,m.major_name,c.class_name,c.class_abbr 
           from class c 
           join major m  
           on c.major_ID=m.major_ID 
           where c.grade="09";
 
select u.id,u.userId,u.password,u.user_name,l.user_identity,c.grade,c.edu_bg,m.major_name,c.class_name from user as u 
          join level l on u.user_level=l.user_level 
          join class c on u.class_abbr=c.class_abbr 
          join major m on c.major_ID=m.major_ID 
          where (u.user_level='3' or u.user_level='2') and u.class_abbr='09jk01' 
          order by u.userId;
          