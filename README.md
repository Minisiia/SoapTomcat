## SoapTomcat
Soap example from lecture with Tomcat

## 6. Web service. rest & soap

## Заметки

### Запрос 

```
<?xml version="1.0" encoding="UTF-8"?><S:Envelope
xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <S:Body xmlns:ns2="http://service/">
        <ns2:f2c>
           <degrees>10</degrees>
        </ns2:f2c>
    </S:Body>
</S:Envelope>
```

### Ответ 

```
<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:f2cResponse xmlns:ns2="http://service/">
            <return>32.0</return>
        </ns2:f2cResponse>
    </S:Body>
</S:Envelope>
```

![55123](https://github.com/Minisiia/SoapTomcat/assets/113467640/dc619b65-adc8-4a66-9212-b9b50b7b43b6)

### com.sun.xml.ws.transport.http.servlet.WSServlet

Класс com.sun.xml.ws.transport.http.servlet.WSServlet является частью библиотеки Metro, которая является реализацией технологии JAX-WS (Java API for XML Web Services). Этот сервлет предоставляет инфраструктуру для обработки входящих SOAP-запросов, основываясь на стандарте Java Servlet.

WSServlet действует как точка входа для веб-служб JAX-WS, принимая SOAP-запросы от клиентов и передавая их на соответствующие веб-службы для обработки. Он обрабатывает различные фазы обработки, такие как разбор входящего сообщения, создание объекта запроса JAX-WS, вызов соответствующего метода веб-службы и формирование ответного сообщения SOAP.

Основными функциями com.sun.xml.ws.transport.http.servlet.WSServlet являются следующие:

 - Прием и обработка входящих SOAP-запросов: WSServlet прослушивает входящие запросы от клиентов и перенаправляет их на соответствующие веб-службы JAX-WS для обработки.

 - Создание экземпляров веб-служб: При получении запроса WSServlet создает экземпляр соответствующей веб-службы JAX-WS, на основе информации, содержащейся в запросе. Этот экземпляр используется для вызова метода веб-службы и обработки запроса.

 - Управление жизненным циклом веб-службы: WSServlet отвечает за управление жизненным циклом веб-службы, включая создание и уничтожение экземпляров веб-службы в соответствии с потребностями обработки запросов.

 - Генерация ответов: WSServlet собирает ответные данные, полученные от веб-службы, и формирует исходящее SOAP-сообщение в соответствии с протоколом SOAP и соответствующими стандартами WSDL (Web Services Description Language).

### WSServletContenxtListener:

Упомянутый выше класс слушателя ( com.sun.xml.ws.transport.http.servlet.WSServletContextListener ) является прослушивателем контекста веб-службы, который инициализирует контекст веб-службы при инициализации контекста приложения и создает делегат веб-службы, который используется. делегировать все будущие запросы веб-сервисов и направлять их к соответствующей реализации конечной точки, определенной в файле sun-jaxws.xml, указанном ниже. Это сохраняет созданный делегат в контексте сервлета контейнера, так что к делегату могут обращаться другие сервлеты.

### WSServlet:

Определение сервлета и его отображение используется для перехвата шаблона url, который следует рассматривать как запрос веб-службы.

Класс ( com.sun.xml.ws.transport.http.servlet.WSServlet ) действует как диспетчер отправки, который направляет запрос в соответствующий класс реализации через делегат, полученный из контекста сервлета, созданного слушателем, как указано выше.

Дескриптор развертывания веб-службы ( sun-jaxws.xml ) в папке WEB-INF. Этот файл необходим эталонной реализации JAX-WS для сопоставления класса реализации сервиса с интерфейсом сервиса. Содержание этого файла упомянуто ниже.

```
<?xml version="1.0" encoding="UTF-8"?>
<endpoints
        xmlns="http://java.sun.com/xml/ns/jax-ws/ri/runtime"
        version="2.0">

    <endpoint
            name="service.TempConverter"
            implementation="service.TempConverterImpl"
            url-pattern="/soap"/>
</endpoints>
```
Дескриптор sun-jaxws.xml. Каждое определение конечной точки в этом дескрипторе указывает имя веб-службы, класс реализации и шаблон URL-адреса, который маршрутизирует к этому вызову веб-службы. Это читается прослушивателем контекста и передается созданному им делегату веб-службы, чтобы делегат знал, какой класс реализации вызывать при поступлении запроса веб-службы.
