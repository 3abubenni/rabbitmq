# Пример использования RabbitMQ

В данном примере имеется два модуля: 
- RabbitMQProducer - модуль, который посылает сообщения
- RabbitMQConsumer - модуль, который обрабатывает сообщения

## RabbitMQProducer
Модуль, посылающий сообщения в очереди RabbitMQ через REST-методы 

При запуске подключается к RabbitMQ серверу по указанным данным в *application.properties*:
```
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.password=guest
spring.rabbitmq.username=guest
```

## RabbitMQConsumer
Обрабатывает сообщения из двух очередей. Настройки подключения к RabbitMQ и названия очередей также, как и в *RabbitMQProducer* указаны в *application.properties*.

## Примечания
- Убедитесь, что RabbitMQ сервер запущен и доступен по указанным параметрам.
- Настройки очередей можно легко изменять через файл application.properties, что позволяет гибко управлять конфигурацией приложения.
- После успешного запуска *RabbitMQProducer*, перейдя по endpoint */swagger-ui/index.html#*, можно будет опробовать методы контроллера. 

