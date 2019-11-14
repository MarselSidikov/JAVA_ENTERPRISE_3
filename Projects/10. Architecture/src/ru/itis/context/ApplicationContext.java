package ru.itis.context;

// объект этого класса
// создает объекты
// всех интерфейсов Component с помощью рефлексии
public interface ApplicationContext {
    // при получении компонента, если у этого компонента
    // есть зависимости - то нужно их тоже проставить
    <T> T getComponent(Class<T> componentType, String name);
}
