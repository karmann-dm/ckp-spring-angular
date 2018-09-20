declare var $:any;

export default class DictionaryFilterItem {
  _fieldName: string;
  _$fieldInput: any;
  _value: any;

  constructor(fieldName, $fieldInput, $acceptButton, callback) {
    this._fieldName = fieldName;
    this._$fieldInput = $fieldInput;
    $acceptButton.on('click', () => {
      if($fieldInput.val()!== this._value) {
        this._value = $fieldInput.val();
        callback(this._value);
      }
    });
  }

  get FieldName() {return this._fieldName;}
  set FieldName(fieldName) {this._fieldName = fieldName;}

  get Value() {return this._value;}
}
