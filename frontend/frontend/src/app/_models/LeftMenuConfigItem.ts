export default class LeftMenuConfigItem {
  _title: string;
  _link: string;
  _icon: string;

  constructor(title: string, link: string, icon: string) {
    this._title = title;
    this._link = link;
    this._icon = icon;
  }

  get Title() { return this._title; }
  set Title(title) { this._title = title; }

  get Link() { return this._link; }
  set Link(link) { this._link = link; }

  get Icon() { return this._icon; }
  set Icon(icon) { this._icon = icon; }
}
