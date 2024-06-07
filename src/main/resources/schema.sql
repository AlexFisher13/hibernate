create table student
(
    id         bigserial not null primary key,
    name       varchar,
    address_id bigint references address (id),
    company_id bigint references company (id)
);
create table company
(
    id   bigserial not null primary key,
    name varchar
);
create table address
(
    id          bigserial not null primary key,
    description varchar
);
create table course
(
    id    bigserial not null primary key,
    title varchar
);
create table student_course
(
    student_id bigint not null,
    course_id  bigint not null,
    primary key (student_id, course_id),
    foreign key (student_id) references student (id) on delete cascade,
    foreign key (course_id) references course (id) on delete cascade
);
