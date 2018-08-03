create table degrees
(
  id         bigserial not null
    constraint degrees_pkey
    primary key,
  created_at timestamp not null,
  updated_at timestamp not null,
  created_by bigint,
  updated_by bigint,
  name       varchar(255)
    constraint ukaqsotmoewehkbpjo21fpek1oy
    unique
);

create table departments
(
  id         bigserial not null
    constraint departments_pkey
    primary key,
  created_at timestamp not null,
  updated_at timestamp not null,
  created_by bigint,
  updated_by bigint,
  full_name  text,
  short_name varchar(255)
    constraint ukr4x268kq9wg6j7nw4kd11pxmn
    unique
);

create table organizations
(
  id            bigserial not null
    constraint organizations_pkey
    primary key,
  created_at    timestamp not null,
  updated_at    timestamp not null,
  created_by    bigint,
  updated_by    bigint,
  full_name     text,
  info          varchar(255),
  short_name    varchar(255)
    constraint ukdul6pm2ulr9tb7rkj07tc9ol1
    unique,
  department_id bigint
    constraint fk5ll2yd3ub4hv6rdi89rr7kijy
    references departments
);

create table positions
(
  id         bigserial not null
    constraint positions_pkey
    primary key,
  created_at timestamp not null,
  updated_at timestamp not null,
  created_by bigint,
  updated_by bigint,
  name       varchar(255)
    constraint uk3vhyopdpf9huqh1t67ho6nayj
    unique
);

create table ranks
(
  id         bigserial not null
    constraint ranks_pkey
    primary key,
  created_at timestamp not null,
  updated_at timestamp not null,
  created_by bigint,
  updated_by bigint,
  name       varchar(255)
    constraint ukpiy81b80jgcxgq7uop71l4k47
    unique
);

create table roles
(
  id   bigserial not null
    constraint roles_pkey
    primary key,
  name varchar(60)
    constraint uk_nb4h0p6txrmfc0xbrd1kglp9t
    unique
);

create table users
(
  id              bigserial not null
    constraint users_pkey
    primary key,
  created_at      timestamp not null,
  updated_at      timestamp not null,
  email           varchar(255)
    constraint uk6dotkott2kjsp8vw4d0m25fb7
    unique,
  first_name      varchar(255),
  last_name       varchar(255),
  password        varchar(100),
  phone           varchar(255),
  second_name     varchar(255),
  degree_id       bigint    not null
    constraint fkhe4bgmqbn7jkmlgb2t6d3v143
    references degrees,
  organization_id bigint    not null
    constraint fkqpugllwvyv37klq7ft9m8aqxk
    references organizations,
  position_id     bigint    not null
    constraint fk6ph6xiiydudp6umjf2xckbbmi
    references positions,
  rank_id         bigint    not null
    constraint fknd21ucuvu0vt5qt0w40s2j68q
    references ranks
);

create table users_roles
(
  user_id bigint not null
    constraint fk2o0jvgh89lemvvo17cbqvdxaa
    references users,
  role_id bigint not null
    constraint fkj6m8fwv7oqv74fcehir1a9ffy
    references roles,
  constraint users_roles_pkey
  primary key (user_id, role_id)
);