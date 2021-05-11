drop table player;
create table player(
 no number primary key,
 title varchar2(100) not null,
 singer varchar2(30) not null,
 price number not null
)

select * from player;

create sequence mp3_seq;

insert into player(no,title,singer,price) values(mp3_seq.nextval,'가을아침','아이유',700);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'noting better','양형조',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'밤편지','김지은',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'연결고리','장지훈',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'No matter where','김수권',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'피 땀 눈물','BTS',500);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'연가','정우',600);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'i am','nirinjan kaur',1000);
commit
select count(*) from player;

/*
 		Oracle row_number() over() : 조회된 ROW(행)에 대한 순차적인 번호를 제공하는 오라클 함수 
 		
 		Inline View : SQL 문장에서 From 절에 사용되는 Subquery 
 					   FROM 절에 서브쿼리로 SELECT 되는 조회결과를 테이블처럼 사용 
 					   
 		EX)    SELECT 
 				FROM (
 					서브쿼리 
 				) 별칭 			   
 		
 */
-- 내림차순 정렬 
select * from player order by no desc;

-- row_number() over(정렬) 
select row_number() over(order by no desc) as rnum,no,title from player;

delete from player where title='연결고리';

-- row_number()는 조회된 결과행에 대해서 행번호를 매긴다 
-- 아래의 where 조건절에서는 사용할 수 없다 
select row_number() over(order by no desc) as rnum,no,title from player
where rnum<=3;

-- SubQuery의 InlineView를 이용하면 된다 
select rnum,no,title from(
	select row_number() over(order by no desc) as rnum,no,title from player
) where rnum<=3;
-- rnum이 4이상 6이하인  곡들을 조회 
select rnum,no,title from(
	select row_number() over(order by no desc) as rnum,no,title from player
) where rnum between 4 and 6;
----board ddl----
create table board(
	no number primary key,
	title varchar2(100) not null,
	content clob not null,
	hits number default 0,
	time_posted date not null,
	id varchar2(100) not null,
	constraint myboard_fk foreign key(id) references board_member(id)
)
-- Board Paging SQL 
-- 게시물 rnum 이 1 이상 5 이하인 게시물 정보를 조회 
/*
	SELECT B.*,M.NAME 
	FROM(
	
	) B , MEMBER M 
	WHERE 조인조건 AND rnum between 1 and 5 
*/
-- step1 : 게시물을 내림차순 정렬하고 row number를 생성한다 
SELECT row_number() over(ORDER BY NO DESC) as rnum,no,title,hits,to_char(time_posted,'YYYY.MM.DD') as time_posted,id
FROM board
-- step2 : step1을 인라인뷰로 이용하고 member 와 join 한다 
SELECT B.*,M.name
FROM (
	SELECT row_number() over(ORDER BY NO DESC) as rnum,
	no,title,hits,to_char(time_posted,'YYYY.MM.DD') as time_posted,id
	FROM board
) B, board_member M
WHERE  B.id=M.id AND rnum BETWEEN 1 AND 5;















