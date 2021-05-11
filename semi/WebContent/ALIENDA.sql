--MEMBER--
drop table member;

create table member(
id varchar2(100) primary key,
name varchar2(100) not null,
password varchar2(100) not null,
email varchar2(100) not null,
stamp number default 0,
coupon number default 0,
status number default 0 
)
insert into member(id,name,password, email, stamp,status) values('2','님','1','java@java.com',15,0);
select * from member;
select * from JANG_ANSWER
--ANSWER--
drop table answer
select * from member -- 4 / 2 32
update member set stamp=stamp-10 where id='2';
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
	constraint pk_answer primary key(id, question_no)
)
create sequence answer_seq;

update answer set hits=hits+1 where answer_no=1
update answer set hits=hits+1 where answer_no=1
select * from answer
drop sequence answer_seq;

select id, answer_content, answer_date, hits, like_count
from answer
where answer_no=1

update member set stamp=3,coupon=2 where id='1'
-- 이게말이야 스템프 / 쿠폰이 있어. 한잔은 스탬프 1잔 무료는 쿠폰
-- 회원이 마이페이지 : side navBar 를 내가푼 문제 / 쿠폰함이 있을 텐데 스템프 : 쿠폰 몇개 

select coupon from member where id='dong'
--QUESTION--
drop table question;
update member set coupon=coupon+3 where id='d'
select * from member
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
<<<<<<< HEAD

<<<<<<< HEAD
drop sequence question_seq;

select * from question
-- paging
SELECT B.question_no,B.title
FROM ( 
SELECT row_number() over(ORDER BY question_no DESC) as rnum, 
question_no,title
FROM question 
WHERE category = 'se'
) B
WHERE  rnum BETWEEN 1 AND 10;






=======
select a.question_no, a.id, a.answer_date, a.answer_content,a.answer_no
from answer a, member m, question q 
where a.id=m.id and q.question_no=2 and a.question_no=2 

select answ
>>>>>>> branch 'main' of https://github.com/JangJiHoon32154011/kostaSemiproject.git
