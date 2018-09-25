create table if not exists form_template_relation (
  form_id bigint constraint form_template_form_id_fk references forms,
  template_id bigint constraint form_template_template_id_fk references templates,
  primary key (form_id, template_id)
);