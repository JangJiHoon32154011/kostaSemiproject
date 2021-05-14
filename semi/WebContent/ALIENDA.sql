
drop table answer;
drop table member;
drop table hint;
drop table question;
drop table answer_like;


--MEMBER--
-- status : 관리자  : 1 , 회원  : 0 --
create table member(
id varchar2(100) primary key,
name varchar2(100) not null,
password varchar2(100) not null,
email varchar2(100) not null,
stamp number default 0,
coupon number default 0,
status number default 0 
)

insert into member(id,name,password, email, stamp,status) values('jang','지훈','1','jang@java.com',1,0);
insert into member(id,name,password, email, stamp,status) values('bae','지예','1','bae@java.com',99,0);
insert into member(id,name,password, email, stamp,status) values('leelee','승연','1','lee@java.com',77,0);

insert into member(id,name,password, email, stamp,status) values('lee','희은','1','lee@java.com',77,1);

-- web test할때 id : yang,형조,1,yang@java.com -> 시연을 yang으로

delete from member where id='yang';

select * from member;

--QUESTION--
create table question(
	question_no number primary key,
	title varchar2(100) not null,
	contents varchar2(100) not null,
	category varchar2(100),
	hits number default 0,
	answercount number default 0,
	picture varchar2(100)
)
drop sequence question_seq;
create sequence question_seq;

insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'JAVA란 무엇인가요?','디테일하게 서술하시오','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'객체지향의 주요 개념 중 Encapsulation의 특징은?','디테일하게 서술하시오','se');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'sql이 뭔가요','디테일하게 서술하시오','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'insert 어떻게 하나요','디테일하게 서술하시오','jdbc');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'css 어떻게 꾸미나요','디테일하게 서술하시오','web');
insert into QUESTION(question_no,title,contents,category) values(question_seq.nextval,'jsp와 servlet의 차이점은 무엇일까요?','두드러진 특징을 설명하시오','web');

-- 기존 테이블에서 select한 정보로 insert를 해본다 4번 실행 (갯수를 늘리는 것)--
insert into QUESTION(question_no,title,contents,category) select question_seq.nextval,title,contents,category from QUESTION

select * from question

--ANSWER--

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
drop sequence answer_seq;
create sequence answer_seq;

select * from answer;

-- 기존 테이블에서 select한 정보로 insert를 해본다 4번 실행 (갯수를 늘리는 것)--
insert into Answer(id,,contents,category) select question_seq.nextval,title,contents,category from QUESTION

--HINT--
drop table hint;
alter table answer drop constraint question_no_fk

create table hint(
	question_no number not null,
	hint_content varchar2(100) not null,
	constraint question_no_fk_hint foreign key(question_no) references question(question_no),
	constraint pk_hint primary key(question_no)
)

insert into hint(question_no,hint_content) values (2,'캡슐화를 상세히 설명하시오');

select hint_content from hint where question_no=1;


--LIKE--
drop table answer_like
create table answer_like(
	id varchar2(100), 
	answer_no number, 
		CONSTRAINT fk_like_mid FOREIGN KEY(id) REFERENCES member(id),
	CONSTRAINT fk_like_ano FOREIGN KEY(answer_no) REFERENCES answer(answer_no),
	constraint pk_answer_like primary key(id, answer_no)
	)

insert into ANSWER_LIKE(id,answer_no) values('jang',5);
insert into ANSWER_LIKE(id,answer_no) values('2',10);
insert into ANSWER_LIKE(id,answer_no) values('3',23);
insert into ANSWER_LIKE(id,answer_no) values('4',44);


	select id,answer_no from answer_like where id='4' and answer_no=4 
	SELECT id from member
	select answer_no from answer

	update answer_like set ans
	
	u
	select * from answer_like
	update answer set like_count=like_count+1 where answer_no=5
	
	update answer set hits=hits+1 where answer_no=5

	
	
-- test
select question_no, title from question order by question_no desc
create table t1(
	id varchar2(100) not null,
	name varchar2(100) not null,
	constraint unique_test1 unique(id, name)
)
insert into t1 values('java','아이유');
insert into t1 values('java','어');

drop table answer
update answer set hits=hits+1 where answer_no=1
update answer set hits=hits+1 where answer_no=1
select * from answer

select like_count from answer where answer_no=9

update answer set hits=hits+1 where answer_no=1
select * from member
select id, answer_content, answer_date, hits, like_count
from answer
where answer_no=1

update member set stamp=3,coupon=2 where id='1'
-- 이게말이야 스템프 / 쿠폰이 있어. 한잔은 스탬프 1잔 무료는 쿠폰
-- 회원이 마이페이지 : side navBar 를 내가푼 문제 / 쿠폰함이 있을 텐데 스템프 : 쿠폰 몇개 
select like_count from answer where answer_no=5
select coupon from member where id='dong'



-- paging
SELECT B.question_no,B.title
FROM ( 
SELECT row_number() over(ORDER BY question_no DESC) as rnum, 
question_no,title
FROM question 
WHERE category = 'se'
) 
WHERE  rnum BETWEEN 1 AND 10;

select id, name from member where status = 0

SELECT B.id,B.name
FROM ( 
SELECT row_number() over(ORDER BY id DESC) as rnum, 
id, name
FROM member 
WHERE status = 0
) B
WHERE  rnum BETWEEN 1 AND 10;


--flag 가 있으면 if(flag==0){ 
delete from ANSWER_LIKE where id='1' and answer_no=5
delete fro
select a.question_no, a.id, a.answer_date, a.answer_content,a.answer_no
from answer a, member m, question q 
where a.id=m.id and q.question_no=2 and a.question_no=2 

select * from ANSWER_LIKE
select answ

select count(*) from answer where question_no=37 and id='java'
select count(*) from answer where question_no=31 and id='java'


select password from member;
select * from member;
SELECT * FROM member WHERE id='did' AND name='양' AND EMAIL='did';


select id, question_no, answer_no, answer_content, answer_date,hits,like_count 
from answer where answer_no=366;

