# levelup3
Данный репозиторий для выполнения домашних заданий группы Java Junior Developer LevelUP курс №3.

# homework1
1. Необходимо создать класс, описывающий сущность Работника (Employee), важными
   характеристиками которого являются ФИО и общий стаж работы в организации. Необходимо
   реализовать статический метод печати в консоль имен тех рабочих, которые имеют указанный
   стаж работы printEmployee(Collection<Employee> employees, int workAge), где employees -
   коллекция сотрудников, а workAge - стаж работы в организации. Дополнительным баллом
   будем считаться реализация метода с использованием Stream API.
   Естественным является заполнение коллекции десятком/сотней объектов класса Employee,
   которые создаются удобным для Вас способом (в цикле запрашиваю из консоли данные или
   внедрив в сам код). В качестве передаваемой на вход коллекции предполагается передача
   списка, множества и очереди.
   Дополнительно необходимо реализовать метод, удаляющий элементы коллекции, стоящие на
   нечетных позициях, обходя список с конца (допускаются преобразования).
2. Создать структуру данных Set<Employee>, который бы мог учесть логику добавления
   сотрудников из предыдущего задания таким образом, что первыми в множестве должны идти
   Employee с максимальным стажем и по убывающей.
3. Необходимо реализовать методы объединения и пересечения двух множеств
   union(Set<Employee> set1, Set<Employee> set2) и intersect(Set<Employee> set1, Set<Employee>
   set2), заполнив значения множества случайным образом. 

# homework2
Реализовать метод или полноценное приложение, которое принимает на вход некоторый
текст (например, из консоли), вычисляет частоту появления слов в этом тексте и после чего
выводит слова в убывающем порядке их частоты появления в тексте. • Под словом подразумевается любая непрерывная последовательность символов (до
пробела, точки, запятой, двоеточия и других разделителей), состоящая только из букв и
цифр, не учитывая регистр букв.
Например, в строке "Семь раз отмерь, 1 раз отрежь!" ровно
пять слов: "семь", "раз", "отмерь", "1", "отрежь" и вывод должен быть такой: • раз
• семь
• замерь
• 1
• отрежь
Для решения необходимо пользоваться возможностями StreamAPI, избегая использования циклов и условных операторов.

# homework3
Сгенерировать поток на 1000 целочисленных псевдослучайных значений. Необходимо
рассчитать максимальное, минимальное, а также среднее значения в этом потоке. Также
посчитать сумму всех нечетных элементов. Дополнительно можно преобразовать данный
поток к карте так, чтобы ключом выступало текущее число, а значением - сумма цифр в
этом числе или само число, если оно одноразрядное.

# homework4
Необходимо реализовать конвертер температур, позволяющий
переводить значения из одной системы в другую. В логике
программы следует предусмотреть конвертацию из Цельсий в
Кельвины и Фаренгейты, а также любой их комбинации. Объект,
получаемого конвертера, должен являться бином со скоупом
Singleton.

# homework5
Необходимо реализовать сервис, который вычисляет n-ый член
последовательности Фибоначчи. Данный параметр необходимо
запрашивать из консоли пользователя. Также требуется
предусмотреть отдельный конфигурационный параметр, с
помощью которого следует предусмотреть возможность
«получения» данных из кэша в памяти (если ранее такие
значения вычислялись или содержались в результате
предыдущих расчетов).

# homework6
Реализовать наполнение справочника городов (или любого
другого справочника), сохраняя информацию в БД и запрашивая
ее у пользователя через консоль. Среди атрибутов города следует
отметить код города, наименование на русском и английском
языке, численность проживающих. Манипулирование с данными
в БД следует осуществлять, используя технологию Spring JDBC.
Опционально* : можно реализовать связь городов с регионами,
предоставив возможность их заполнения и связывания

# homework7
Переделать задание со справочником городов на использование
JPA, опираясь на возможности Spring Data JPA. Добавление
связанной сущности в данном случае становится обязательным
условием. Также для CRUD-операций организовать поддержку
транзакционности. Первоначальное наполнение справочных
данных сделать с использованием liquibase.

# homework8
Предоставить REST API для привычных CRUD-операций при
работе со справочник городом.
Добавить поддержку транзакционности на уровне сервисов.
Предусмотреть валидацию входных данных и обработку
возникающих исключений во время работы приложения.

# homework9
Реализовать классическое MVC-приложение с набором CRUD-
операций для произвольного справочника (например, справочника
регионов/городов, товаров и т.д.) по аналогии с приведенным на
вебинаре примером. В качестве шаблонизатора использовать
Thymeleaf. Предусмотреть поддержку локализации используемых
на веб-страницах текстовых ресурсов.

# homework10
добавить поддержку авторизованного доступа к страницам и их элементам к предыдущему заданию.

# homework11
К одному из домашних заданий необходимо добавить поддержку
модульных тестов с использованием фреймворков JUnit4/5 и
Mockito (если потребуется создание заглушек)