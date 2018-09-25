create table if not exists services (
  id bigserial constraint services_pkey primary key,
  name varchar(250) not null constraint services_name_unique unique,
  description text not null,
  template_id bigint constraint services_template_fk references templates
);