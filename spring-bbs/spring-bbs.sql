-- 회원테이블
CREATE TABLE member
(
   email    varchar(60) PRIMARY KEY,
   passwd   varchar(20) NOT NULL,
   name     varchar(20) NOT NULL,
   mobile   varchar(20)
);

-- 게시판 종류

CREATE TABLE board
(
   boardcd   varchar(20),
   boardnm   varchar(40) NOT NULL,
   CONSTRAINT PK_BOARD PRIMARY KEY(boardcd)
);

-- 게시글

CREATE TABLE article
(
   articleno   int auto_increment,
   boardcd     varchar(20),
   title       varchar(20) NOT NULL,
   content     longblob,
   email       varchar(20),
   hit         int,
   regdate     date,
   CONSTRAINT PK_ARTICLE PRIMARY KEY(articleno),
   CONSTRAINT FK_ARTICLE FOREIGN KEY(boardcd) REFERENCES board(boardcd)
);
-- 게시글 번호 생성기
--create sequence SEQ_ARTICLE_NO
--increment by 1
--start with 1;

-- 덧글

CREATE TABLE comments
(
   commentno   int auto_increment,
   articleno   int,
   email       varchar(60),
   memo        varchar(4000),
   regdate     date,
   CONSTRAINT PK_COMMENTS PRIMARY KEY(commentno)
);

-- 덧글 번호 생성기
--create sequence SEQ_COMMENTS
--	increment by 1
--	start with 1;

--첨부파일

CREATE TABLE attachfile
(
   attachfileno   int auto_increment,
   filename       varchar(50) NOT NULL,
   filetype       varchar(30),
   filesize       int,
   articleno      int,
   CONSTRAINT PK_ATTACHFILE PRIMARY KEY(attachfileno)
);

--첨부파일 번호 생성기
--create sequence SEQ_ATTACHFILE
--	increment by 1
--	start with 1;
