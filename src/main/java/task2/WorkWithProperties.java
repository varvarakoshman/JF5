/*
Задание 2
Создать “универсальный” класс, позволяющий получить значение из любого properties-
файла. Физическое чтение файла должно происходить только один раз. Обработайте
следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.
 */
package task2;

import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class WorkWithProperties {
    private ResourceBundle bundle;
    private HashMap<String, String> keyMap;

    WorkWithProperties(String prop, Locale locale) throws NoPropFileException {
        try {
            this.bundle = ResourceBundle.getBundle(prop,locale);
            this.keyMap = new HashMap<>();
            bundle.keySet().forEach(key -> keyMap.put(key, (String) bundle.getObject(key)));
        } catch (MissingResourceException e) {
            throw new NoPropFileException(e);
        }
    }

    public String getValue(String key) throws NoKeyException {
        if (!keyMap.containsKey(key)) throw new NoKeyException("no such key");
        return this.keyMap.get(key);
    }

}
