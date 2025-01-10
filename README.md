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
Инициализирует две очереди в конфиге *RabbitMQConfig*:
```
rabbitmq.queue.name=message_queue
rabbitmq.queue_with_delay.name=delay_queue
```

Имеет два REST-метода.

### /message
Посылает сообщение в очередь message_queue или в ту очередь, которая будет указана в *application.properties* под переменной *rabbitmq.queue.name=message_queue*:
```
# Можете указать свою очередь
rabbitmq.queue.name=message_queue 
```

### /message/with_delay
Посылает сообщение в очередь delay_queue или в ту очередь, которая будет указана в *application.properties* под переменной *rabbitmq.queue_with_delay.name=delay_queue*:
```
# Можете указать свою очередь
rabbitmq.queue_with_delay.name=delay_queue
```

## RabbitMQConsumer
Обрабатывает сообщения из двух очередей. Настройки подключения к RabbitMQ и названия очередей также, как и в *RabbitMQProducer* указаны в *application.properties*.

Сообщения из mesage_queue (или той очереди, что указана в *application.properties*) обрабатывает без задержки.

Сообщения из delay_queue (или той очереди, что указана в *application.properties*) обрабатывает со случайной задержкой до 3-х секунд.

## Примечания
- Убедитесь, что RabbitMQ сервер запущен и доступен по указанным параметрам.
- Настройки очередей можно легко изменять через файл application.properties, что позволяет гибко управлять конфигурацией приложения.
- После успешного *RabbitMQProducer*, перейдя по endpoint */swagger-ui/index.html#*, можно будет опробовать методы контроллера. 

