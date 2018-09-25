create table if not exists service_statuses (
  id bigserial constraint service_statuses_pkey primary key,
  name varchar(200) constraint service_statuses_unique_name unique
);

alter table services add status bigint constraint service_statuses_fk references service_statuses;