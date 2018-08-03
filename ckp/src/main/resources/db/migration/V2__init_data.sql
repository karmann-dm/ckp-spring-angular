insert into departments (id,
                         created_at,
                         updated_at,
                         created_by,
                         updated_by,
                         full_name,
                         short_name) values (
  1,
  '2018-07-05 00:00:00',
  '2018-07-05 00:00:00',
  1,
  1,
  'Не задано',
  'Не задано'
);

insert into degrees (id,
                     created_at,
                     updated_at,
                     created_by,
                     updated_by,
                     name) values (
  1,
  '2018-07-05 00:00:00',
  '2018-07-05 00:00:00',
  1,
  1,
  'Не указана'
);

insert into organizations (id,
                           created_at,
                           updated_at,
                           created_by,
                           updated_by,
                           full_name,
                           info,
                           short_name,
                           department_id)  values (
  1,
  '2018-07-05 00:00:00',
  '2018-07-05 00:00:00',
  1,
  1,
  'Не указана',
  null,
  'Не указана',
  1
);

insert into positions (id,
                       created_at,
                       updated_at,
                       created_by,
                       updated_by,
                       name) values (
  1,
  '2018-07-05 00:00:00',
  '2018-07-05 00:00:00',
  1,
  1,
  'Не указана'
);

insert into ranks (id,
                   created_at,
                   updated_at,
                   created_by,
                   updated_by,
                   name) VALUES (
  1,
  '2018-07-05 00:00:00',
  '2018-07-05 00:00:00',
  1,
  1,
  'Не указана'
);

insert into roles (id, name) values (
    1, 'ROLE_USER'
);

insert into roles(id, name) VALUES (
    2, 'ROLE_MODERATOR'
);

insert into roles (id, name) values (
    3, 'ROLE_ADMIN'
);



