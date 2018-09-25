create table if not exists service_equipment_relation (
  service_id bigint constraint service_equipment_service_id_fk references services,
  equipment_id bigint constraint service_equipment_equipment_id_fk references equipments,
  primary key (service_id, equipment_id)
);