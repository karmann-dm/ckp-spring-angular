declare var $:any;
import Form from '../_models/Form';

export default class FormGenerator {
  static generate(fields) {
    let out = $('<div class="generation-container"></div>');
    return new Form(out, fields);
  }
}
