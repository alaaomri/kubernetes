create sequence bookmark_id_seq start with 1 increment by 50;
create table bookmarks (
    id bigint default nextval('bookmark_id_seq'),
    title varchar(255) not null,
    url varchar(255) not null,
    description text,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    primary key (id)
);