# Приложение "Файлообменник"
## Задача:
Необходимо реализовать микросервис, который будет выполнять роль хранилища различных файлов и их атрибутов.

Микросервис должен предоставлять HTTP API и принимать/отдавать запросы/ответы в формате JSON.
Разработка UI-интерфейса не требуется. 

Для тестирования можно использовать Postman или аналог.
Должны быть реализованы следующие API-методы:

1. Создание файла. (/create)

    На вход методу отправляется JSON, включающий в себя файл (в формате base64) и его атрибуты (название - title, дата и время отправки - creation_date, краткое описание документа - description), на выходе метод возвращает id созданного файла.


2. Получение файла. (/find)

    На вход методу отправляется id файла, на выходе метод возвращает JSON, включающий в себя файл (в формате base64) и его атрибуты (название - title, дата и время отправки - creation_date, краткое описание документа - description)

Дополнительно был реализован API-метод /files, который выдает список всех файлов.

## Инструкция по запуску проекта
Проект поддерживает контейнеризацию при помощи docker.
1. Клонируйте данный репозиторий в свою IDE 
2. В терминале перейдите в директорию [docker](docker)
3. Введите следующую команду: `docker-compose up`
4. Запустите [FileStorageApplication.java](src/main/java/ru/rosatom/edu/bratyshevTD/fileStorage/FileStorageApplication.java).

URL-адрес, по которому происходит обращение: 
`localhost:8081/app`

## Тестирование API
В папке [postman](postman) размещен json файл [Testing API.postman_collection.json](postman%2FTesting%20API.postman_collection.json), с помощью которого можно протестировать приложение. 

Имеются следующие запросы:

* POST (create): создание файла (передача JSON в метод)
`localhost:8081/app/create`
* GET (get): получение файла, исходя из id
`localhost:8081/app/get?id=4`
* GET (all files): получение всех файлов
`localhost:8081/app/files`
* GET (pagination): пагинация (параметры: size - размер, page - номер страницы)
`localhost:8081/app/files?page=0&size=2`
* GET (sorting): сортировка полей по датам (параметры: sortedBy - по какой переменной сортируем; direction - вид сортировки: asc - от старой к новой, dsc - от новой к старой)
`localhost:8081/app/files?direction=dsc`

## Описание решения

* Подразумевается, что на вход подается файл в формате Base64 (По сути, в JSON содержится строка Base64). При передаче файла на сторону сервера происходит преобразование в массив байтов, в таком ввиде файл хранится в БД. 
* При получении файла массив байтов преобразуется обратно в Base64. 
* Дата фиксируется с момента передачи файла на сервер
* Реализован метод получения списка всех файлов с пагинацией и сортировкой (см. Тестирование API).

