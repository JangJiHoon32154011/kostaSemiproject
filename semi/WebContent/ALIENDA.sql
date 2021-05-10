--MEMBER--
drop table member;

create table member(
id varchar2(100) primary key,
name varchar2(100) not null,
password varchar2(100) not null,
email varchar2(100) not null,
coupon number default 0,
status number default 0 
)

select * from member;

--ANSWER--
drop table answer

create table answer(
	id varchar2(100) not null,
	question_no number not null,
	answer_no number,
	answer_content varchar2(100) not null,
	answer_date varchar2(100) not null,
	hits number default 0,
	like_count number default 0,
	constraint id_fk foreign key(id) references member(id),
	constraint question_no_fk foreign key(question_no) references question(question_no),
	constraint pk_jang_answer primary key(id, question_no)
)
create sequence answer_seq;

drop sequence answer_seq;

--QUESTION--
drop table question;

create table question(
	question_no number primary key,
	title varchar2(100) not null,
	contents varchar2(100) not null,
	category varchar2(100),
	hits number default 0,
	answercount number default 0
)
create sequence question_seq;

drop sequence question_seq;