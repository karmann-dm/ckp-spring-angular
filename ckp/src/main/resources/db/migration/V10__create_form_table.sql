create table if not exists forms (
  id bigserial constraint forms_pkey primary key,
  name varchar(300) constraint forms_unique_name unique,
  config text not null
);