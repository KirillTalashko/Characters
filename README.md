# Characters App. Тестовое задание

## Требования к задаче

1. Сверстать экран согласно предоставленному макету в Figma ([ссылка на макет](https://www.figma.com/file/6f8BQNhRhVRwOJxctuZcTt/Untitled?node-id=0%3A1)) .
2. Реализовать загрузку данных о персонажах из открытого API.
3. Наполнить экран данными.
4. Использовать Kotlin.

## Реализация

1. **Создание пользовательского интерфейса**:
   - Верстка экрана выполнена на основе XML.
   - Использовались CustomView для отображения карточек персонажей с уникальным дизайном.
   - Все текстовые, цветовые и размерные значения вынесены в ресурсы (`res/values`).

2. **Архитектура приложения**:
   - Реализована архитектура MVVM (Model-View-ViewModel) для разделения логики приложения и пользовательского интерфейса.
   - Использован подход MVI (Model-View-Intent) для управления состоянием экрана, что позволяет обрабатывать действия пользователя и обновлять экран в зависимости от состояния.

3. **Загрузка данных из API**:
   - Использован Retrofit для выполнения HTTP-запроса.
   - Создан репозиторий для обработки данных и их передачи в ViewModel.

4. **Работа с потоками данных**:
   - Kotlin Coroutines.
   - Использован LiveData для отслеживания изменений данных и обновления пользовательского интерфейса в реальном времени.

5. **Связывание данных с интерфейсом**:
   - Реализована DataBinding для упрощения взаимодействия между View и ViewModel.
   - Данные персонажей автоматически отображаются в соответствующих элементах интерфейса.

6. **Обработка ошибок**:
   - Добавлены механизмы обработки ошибок при загрузке данных из API (например, отображение сообщения об ошибке в случае недоступности сервера).

7. **Расширение функциональности**:
   - Реализованы Extension функции для упрощения работы с UI-элементами и повышения читаемости кода.

8. **Организация ресурсов**:
   - Все текстовые строки, цвета и размеры вынесены в `res/string` для упрощения локализации и редактирования.

## Контакты

LinkedIn: [Kirill Talashko](https://www.linkedin.com/in/kirill-talashko-53744833b/)
Telegram: [@talish03](https://t.me/talish03)
