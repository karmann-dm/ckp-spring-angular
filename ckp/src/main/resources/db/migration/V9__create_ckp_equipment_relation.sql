create table if not exists ckp_equipment_relation (
  ckp_id bigint constraint ckp_equipment_ckp_id_fk references ckps,
  equipment_id bigint constraint ckp_equipment_equipment_id references equipments,
  primary key (ckp_id, equipment_id)
);