import LeftMenuConfigItem from './LeftMenuConfigItem';

export default class LeftMenuConfig {
  _items: LeftMenuConfigItem[];
  _header: string;
  _name: string;

  constructor() {
  }

  get Header() { return this._header; }
  set Header(header) { this._header = header; }

  get Items() { return this._items; }
  set Items(items) { this._items = items; }

  get Name() { return this._name; }
  set Name(name) { this._name = name; }

  static createLeftMenuConfig(configObject: any) {
    let menuConfig = new LeftMenuConfig();
    menuConfig.Header = configObject.header;
    menuConfig.Name = configObject.name;
    let items = [];
    configObject.items.forEach((obj) => {
      let item = new LeftMenuConfigItem(obj.title, obj.link, obj.icon);
      items.push(item);
    });
    menuConfig.Items = items;
    return menuConfig;
  }
}
