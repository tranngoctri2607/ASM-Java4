use master
go

create database [ASMJava4]
go

use ASMJava4
go

drop table history

drop table video

create table [User]
(
	id int primary key identity,
	username nvarchar(50) unique not null,
	[password] nvarchar(50) not null,
	email nvarchar(50) unique not null,
	isAdmin bit not null default 0,
	isActive bit not null default 1
)
go

create table Video
(
	id int primary key identity,
	title nvarchar(255) not null,
	href varchar(50) unique not null,
	poster varchar(255) null,
	[views] int not null default 0,
	share int not null default 0,
	[description] nvarchar(255) not null,
	isActive bit not null default 1
)
go

create table History
(
	id int primary key identity,
	userID int foreign key references [user](id),
	vidID int foreign key references video(id),
	viewDate datetime not null default getDate(),
	isLiked bit not null default 0,
	likedDate datetime null
)
go

insert into [User] (username, [password], email, isAdmin) values
('triadmin', 'admin', 'admin@gmail.com', 1),
('tricute', 'tricute', 'tricute@gmail.com', 0)

insert into video (title, href, poster, [description]) values
(N'Nhạc Phim Siêu Nhân Gao Vietsub lyric Gaoranger Hoero Yukio Yamagata Live', 'ZYKEL-9dxMg', 'https://i.ytimg.com/vi/ZYKEL-9dxMg/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&amp;rs=AOn4CLARgU5y79Qo3gry-DN9y0Whb2EnPQ', '31 thg 12, 2017'),
(N'Nhạc Siêu nhân Cuồng Phong ✔', 'sqwcr2a4hO8', 'https://i.ytimg.com/vi/sqwcr2a4hO8/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDTf8B1kQXSgjLqCaId7P9kTcjRhQ' , '17 thg 7, 2018'),
(N'Nhạc Phim siêu nhân deka - TOKUSOU SENTAI DEKARANGER - Psychic Lover', 'v--kH6yd1lg', 'https://i.ytimg.com/vi/v--kH6yd1lg/hqdefault.jpg?sqp=-oaymwE2CNACELwBSFXyq4qpAygIARUAAIhCGAFwAcABBvABAfgB1AaAAuADigIMCAAQARh_IBMoIjAP&rs=AOn4CLCuveecNbMD1NtGGd1uWm4OScmrVg', '23 thg 3, 2013')
go

insert into history (userID, vidID, isLiked, likedDate) values
(2, 1, 1, GETDATE()),
(2, 3, 0, null)
go