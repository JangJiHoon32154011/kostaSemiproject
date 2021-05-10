
drop table member;

create table member(
id varchar2(100) primary key,
name varchar2(100) not null,
password varchar2(100) not null,
email varchar2(100) not null,

coupon number default 0,
status number default 0 
)
--회원가입 
insert into member(id,name,password, email) values('back','백경성','1234','java@java.com')
insert into member(id,name,password, email, status) values('manager','관리자','1234','java@java.com',1);
insert into member(id,name,password, email, status) values('java','관리자2','1234','java@java.com',1);

delete from member
-- 회원정보 수정
UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]

select question_no,title, contents from question where question_no=4

select * from member
drop table question;
create table question(
	question_no number primary key,
	title varchar2(100) not null,
	contents varchar2(100) not null,
	category varchar2(100),
	hits number default 0,
	answercount number default 0
)

select title, contents from question where question_no=10
select * from member
create sequence question_seq;

update question set contents='제대로~' where question_no=3;


drop sequence question_seq;
--ORA-01400: cannot insert NULL : not null이라 생기는 문제
-- 관리자가 질문 삽입 
insert into question(question_no, title, contents, category) values(question_seq.nextval,'자바란 무엇인가요','디테일하게 서술하시오','se');

insert into question(question_no, title, contents, category) values(question_seq.nextval,'제임스고슬링이 누군가요','디테일하게 서술','se');

insert into question(question_no, title, contents, category) values(question_seq.nextval,'sql이 뭔가요','디테일하게 서술하시오','jdbc');

insert into question(question_no, title, contents, category) values(question_seq.nextval,'insert 어떻게 하나요','디테일하게 서술하시오','jdbc');

insert into question(question_no, title, contents, category) values(question_seq.nextval,'css 어떻게 꾸미나요','디테일하게 서술하시오','web');

insert into question(question_no, title, contents, category)
values(question_seq.nextval,'jsp는 뭔가요','디테일하게 서술하시오','web');
-- 상세보기 

select question_no, title from question where category= 'se' order by question_no desc
select * from question
delete from question
commit
drop table answer;
create table answer(
	answer_no number primary key,
	ans_contents varchar2(100) not null,
	hits number default 0,
	like_count number default 0,
	question_no number not null,
	constraint question_no_fk foreign key(question_no) references question(question_no)
)
create sequence answer_seq;
drop sequence answer_seq;

-- 답안 제출하기 
insert into answer(answer_no,ans_contents,question_no) values (answer_seq.nextval,'모르겠어요',1);
-- 답안 보기 
select * from answer;

select answer_no, ans_contents, question_no
from answer
order by answer_no desc;



drop table member_answer

select ans_contents,question_no,hits,like_count 
from answer where answer_no=1

alter table answer drop constraint id_fk 
create table member_answer(
	id varchar2(100) ,
	answer_no number ,
	answer_contents varchar2(100) not null,
	ans_date date not null,
	constraint id_fk foreign key(id) references member(id),
	constraint answer_no_fk foreign key(answer_no) references answer(answer_no),
	constraint pk_member_answer primary key(id, answer_no)
)
drop sequence member_answer_seq;
create sequence member_answer_seq;
insert into member_answer(id,answer_no,answer_contents,ans_date) values('java',member_answer_seq.nextval,'제임스고슬링이 만든언어', TO_CHAR(sysdate,'YYYY-MM-DD'))
delete from member_answer
delete from member_answer where answer_no=1;
select * from member_answer
select ma.id, ma.answer_no, ma.answer_contents, ma.ans_date
from member_answer ma, member m
where ma.id=m.id
order by ma.answer_no desc



select name from member where id='java' and password='1234'

select * from question
-- question_no, title, id, contents, category, hits, answercount 

select * from member
-- id, name, password, email, phone, coupon, status 

select * from answer
--answer_no, ans_contents, hits, like_count, question_no  
select * from member_answer
-- id, answer_no, ans_date
select id, answer_no,answer_contents,to_char(ans_date,'yyyy.mm.dd') as ans_date
from member_answer

select question_no, title, contents from question

select ma.id, ma.answer_no, ma.answer_contents, ma.ans_date
from member_answer ma, member m
where ma.id=m.id and ma.id='java'
order by ma.answer_no desc

-- foreign key 지우는 법 
alter table answer drop constraint question_no_fk

-- 장지훈식 answer table
create table jang_answer(
	id varchar2(100) not null,
	question_no number not null,
	answer_nuuo number,
	answer_content varchar2(100) not null,
	answer_date varchar2(100) not null,
	hits number default 0,
	like_count number default 0,
	constraint id_fk foreign key(id) references member(id),
	constraint question_no_fk foreign key(question_no) references question(question_no),
	constraint pk_jang_answer primary key(id, question_no)
);
create sequence janswer_seq;
drop table jang_answer
drop sequence janswer_seq;

select * from jang_answer
-- 답 추가하기 
insert into jang_answer(id,question_no,answer_no,answer_content,answer_date) 
values('java',1,janswer_seq.nextval,'몰라요',sysdate); 

delete  from jang_answer

select question_no, answer_date from jang_answer
where id='java' order by answer_no
-- 지금 이제 마이페이지에서 리스트 띄우면 댐

select id, question_no, answer_content, answer_date
from jang_answer where answer_no=2
-- answerNo 로 답 삭제하기 
delete from jang_answer where answer_no=1

--업데이트하기 
update board set title=?,content=? where no=?;
update jang_answer set answer_content='update' where  id= 'java' and question_no=1;

-- 해당 질문에 대한 답 모두 보기
select ja.question_no, ja.answer_date, q.title, q.contents
from jang_answer ja, member m, question q
where ja.id=m.id and q.question_no=1 and ja.question_no=1
