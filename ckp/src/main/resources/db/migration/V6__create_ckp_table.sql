create table if not exists ckp_statuses
(
  id bigserial not null constraint ckp_statuses_pkey primary key,
  name varchar(255) constraint ckp_statuses_name_unique unique
);

insert into ckp_statuses (id, name) values
  (1, 'Заявка подана'),
  (2, 'На рассмотрении'),
  (3, 'Подтвержден'),
  (4, 'Отклонён'),
  (5, 'Заблокирован');

create table if not exists ckps
(
  id bigserial not null
    constraint ckps_pkey
    primary key,
  created_at timestamp not null,
  updated_at timestamp not null,
  created_by bigint,
  updated_by bigint,
  short_name varchar(255) constraint ckps_short_name_unique unique,
  full_name text not null,
  organization_id bigint constraint organizations_ckp_fk references organizations,
  head_full_name varchar(255) not null,
  head_degree_id bigint constraint degrees_ckp_fk references degrees,
  head_rank_id bigint constraint ranks_ckp_fk references ranks,
  head_position_id bigint constraint positions_ckp_fk references positions,
  head_phone varchar(45) not null,
  head_fax varchar(45) not null,
  address text not null,
  status_id bigint constraint ckp_status_fk references ckp_statuses
);