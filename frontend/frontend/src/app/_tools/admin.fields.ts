let dictionaryControls = [

];

export default function DictionaryAdminFields(entityName) {
  return `
  <div style="display: flex; flex-direction: row">
    <a routerLink="{{'portal/' + entityName + '/edit}}">Редактировать</a>
    <a>Удалить</a>
  </div>
  `;
}
