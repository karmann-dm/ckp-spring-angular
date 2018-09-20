import FormField from "./FormField";
import FormGenerator from "../_tools/form-generator";
declare var $:any;

export default class Form {
  fields = [];
  submitCallbacks = [];
  container: any;

  constructor(container: any, fields: any[]) {
    this.container = container;
    fields.forEach(field => {
      let newField = new FormField(field, container);
      this.fields.push(newField);
    });
    this.addSubmitButton();
  }

  Submit(callback) {
    this.submitCallbacks.push(callback);
  }

  addSubmitButton() {
    let submitButton = $('<button>Сохранить</button>').attr({
      class: 'btn btn-success'
    });
    submitButton.on('click', () => {
      this.onSubmit();
    });
    this.container.append(submitButton);
  }

  onSubmit() {
    this.submitCallbacks.forEach(callback => {
      callback(this.fields);
    });
  }
}
