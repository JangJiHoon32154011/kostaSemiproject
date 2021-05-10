drop table board_member;
drop table board;

drop sequence board_seq;
create sequence board_seq;

create table board_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null
)
create table board(
	no number primary key,
	title varchar2(100) not null,
	content clob not null,
	hits number default 0,
	time_posted date not null,
	id varchar2(100) not null,
	constraint myboard_fk foreign key(id) references board_member(id)
)
insert into board_member(id,password,name)
values('java','a','아이유');
insert into board_member(id,password,name)
values('spring','a','공유');
select * from board_member;
select * from board;

insert into board(no,title,content,time_posted,id) 
values(board_seq.nextval,'방가','ㅋㅋ',sysdate,'java');

insert into board(no,title,content,time_posted,id) 
values(board_seq.nextval,'안녕','치맥',sysdate,'spring');

insert into board(no,title,content,time_posted,id) 
values(board_seq.nextval,'즐거운 프로젝트','복분자 맛있어요^^',sysdate,'java');

SELECT b.no,b.title,b.hits,to_char(time_posted,'YYYY.MM.DD') as time_posted,m.id,m.name 
FROM board b , board_member m
WHERE b.id=m.id
order by no desc

























