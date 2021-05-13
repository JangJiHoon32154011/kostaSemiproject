--MEMBER--
drop table member;
drop table answer;
drop table question;
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
insert into member(id,name,password, email, stamp,status) values('kim','미남','00','hi@naver.com',22,1);
select * from member;
select * from JANG_ANSWER
delete from member where id='2'
select id, name, stamp, coupon from member where id='kim'
--ANSWER--
drop table answer
select * from member -- 4 / 2 32
update member set stamp=stamp-10 where id='2';
select * from answer
create table answer(
	id varchar2(100) not null,
	question_no number not null,
	answer_no number primary key,
	answer_content varchar2(100) not null,
	answer_date varchar2(100) not null,
	hits number default 0,
	like_count number default 0,
	constraint id_fk foreign key(id) references member(id),
	constraint question_no_fk foreign key(question_no) references question(question_no),
	constraint answer_unique unique(id,question_no)
)
-- test
create table t1(
	id varchar2(100) not null,
	name varchar2(100) not null,
	constraint unique_test1 unique(id, name)
)
insert into t1 values('java','아이유');
insert into t1 values('java','어');
create sequence answer_seq;
drop table answer
update answer set hits=hits+1 where answer_no=1
update answer set hits=hits+1 where answer_no=1
select * from answer
drop sequence answer_seq;

select like_count from answer where answer_no=9

update answer set hits=hits+1 where answer_no=1
select * from member
select id, answer_content, answer_date, hits, like_count
from answer
where answer_no=1

update member set stamp=3,coupon=2 where id='1'
-- 이게말이야 스템프 / 쿠폰이 있어. 한잔은 스탬프 1잔 무료는 쿠폰
-- 회원이 마이페이지 : side navBar 를 내가푼 문제 / 쿠폰함이 있을 텐데 스템프 : 쿠폰 몇개 
select like_count from answer where answer_no=9
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
select id, name from member;
select distinct(category) from QUESTION
create sequence question_seq;
drop sequence question_seq;


select * from question

--HINT--
drop table hint;
alter table answer drop constraint question_no_fk

create table hint(
	question_no number not null,
	hint_content varchar2(100) not null,
	constraint question_no_fk_hint foreign key(question_no) references question(question_no),
	constraint pk_hint primary key(question_no)
)

insert into hint(question_no,hint_content) values (1,'hi');

select hint_content from hint where question_no=1;

select * from hint;

-- paging
SELECT B.question_no,B.title
FROM ( 
SELECT row_number() over(ORDER BY question_no DESC) as rnum, 
question_no,title
FROM question 
WHERE category = 'se'
) 
WHERE  rnum BETWEEN 1 AND 10;


drop table answer_like
create table answer_like(
	id varchar2(100), 
	answer_no number, 
		CONSTRAINT fk_like_mid FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT fk_like_ano FOREIGN KEY(answer_no) REFERENCES answer(answer_no),
	constraint pk_answer_like primary key(id, answer_no)
	)
	
	select id,answer_no from answer_like where id='4' and answer_no=4 
	SELECT id from member
	select answer_no from answer
	insert into ANSWER_LIKE(id,answer_no) values('1',5)
	update answer_like set ans
	
	u
	select * from answer
	update answer set like_count=like_count+1 where answer_no=5
	
	update answer set hits=hits+1 where answer_no=5

--flag 가 있으면 if(flag==0){ 
delete from ANSWER_LIKE where id='1' and answer_no=5
delete fro
select a.question_no, a.id, a.answer_date, a.answer_content,a.answer_no
from answer a, member m, question q 
where a.id=m.id and q.question_no=2 and a.question_no=2 

select * from ANSWER_LIKE
select answ
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');


drop table jang_answer
drop table member_answer

insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'java란?','뭘까요~?','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jdbc란?','뭘까요~?','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'web 이란?','뭘까요~?','web');



select count(*) from answer where question_no=37 and id='java'
select count(*) from answer where question_no=31 and id='java'


select password from member;
select * from member;
SELECT * FROM member WHERE id='did' AND name='양' AND EMAIL='did';



