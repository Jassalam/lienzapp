create table book (
                                  id bigint not null,
                                  name varchar(255) not null,
                                  primary key (id)
);

create table author (
                          id bigint not null,
                          name varchar(100) not null,
                          email_address varchar(255),
                          primary key (id)
);

ALTER TABLE book ADD CONSTRAINT author_id FOREIGN KEY (author_id) REFERENCES
    author (id);


