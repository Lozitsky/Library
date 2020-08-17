DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS author CASCADE;
DROP TABLE IF EXISTS genre CASCADE;
DROP TABLE IF EXISTS publisher CASCADE;

create table if not exists author
(
    id bigint(20) auto_increment
        primary key,
    full_name varchar(300) not null,
    birthday date not null
);

create table if not exists genre
(
    id bigint(20) auto_increment
        primary key,
    name varchar(100) not null
);

create table if not exists publisher
(
    id bigint(20) auto_increment
        primary key,
    name varchar(100) not null
);

create table if not exists book
(
    id bigint(20) auto_increment
        primary key,
    name varchar(45) not null,
    content longblob not null,
    page_count int not null,
    isbn varchar(100) not null,
    genre_id bigint not null,
    author_id bigint not null,
    publish_year int not null,
    publisher_id bigint not null,
    image longblob null,
    description varchar(5000) null,
    rating int default 0 null,
    vote_count bigint default 0 null,
    constraint book_unique
        unique (id, isbn),
    constraint book_ibfk_1
        foreign key (author_id) references author (id),
    constraint book_ibfk_2
        foreign key (genre_id) references genre (id),
    constraint book_ibfk_3
        foreign key (publisher_id) references publisher (id)
);
