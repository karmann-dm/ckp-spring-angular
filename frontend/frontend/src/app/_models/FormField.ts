import FormGenerator from "../_tools/form-generator";
declare var $:any;

export default class FormField {
  _$container: any;
  _type: string;
  _name: string;
  _value: any;
  callbacks = [];

  constructor(field: any, container: any) {
    this.Name = field.name;
    this.Type = field.type;

    switch (field.type) {
      case "text_short": {
        let _$field = this.generateTextShortField(field);
        container.append(_$field);
      }
    }
  }

  Change(callback) {
    this.callbacks.push(callback);
  }

  onChange() {
    this.callbacks.forEach(callback => {
      callback(this.Value);
    });
  }

  generateTextShortField(field) {
    let fieldContainer = $('<div></div>').attr({
      class: 'form-group'
    });
    fieldContainer.append($(`<label>${field.title}</label>`));
    let newField = $('<input/>').attr({
      type: 'text',
      id: field.name,
      name: field.name,
      class: 'form-control'
    });
    newField.on('change', (e) => {
      this.Value = e.target.value;
      this.onChange();
    });
    fieldContainer.append(newField);
    return fieldContainer;
  }

  get Name() {
    return this._name;
  }

  set Name(name) {
    this._name = name;
  }

  get Type() {
    return this._type;
  }

  set Type(type) {
    this._type = type;
  }

  get Value() {
    return this._value;
  }

  set Value(value) {
    this._value = value;
  }
}
