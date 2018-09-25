create table if not exists templates(
  id bigserial constraint templates_pkey primary key,
  name varchar(300) constraint templates_unique_name unique,
  description text not null
);