create table if not exists equipment (
  id bigserial not null constraint equipment_pkey primary key,
  name varchar(200) constraint equipment_unique_name unique,
  mark varchar(350),
  producer varchar(350),
  hour_price real,
  production_year varchar(50),
  description text
);