## Message Oriented Middleware

* Делает системы асинхронными

* Каждый модуль системы независим от реализации других модулей 

## Simple (or Streaming) Text Oriented Message Protocol (STOMP)

* Подписаться на что-либо
* Получать информацию от чего-либо
* Отправлять информацию куда-либо

* FRAME

```
COMMAND
header1:value1
header2:value2

Body^@
```

* Подключение к серверу

```
CONNECT
accept-version:1.0,1.1,2.0
host:stomp.github.org

^@
```



* Подписка на URL

```
SUBSCRIBE
destination:/topic

^@
```

* Получение сообщения от URL

```
MESSAGE

{"ticker":"MMM","price":129.45}^@
```

* Отправка сообщения

```
SEND
destination:/queue/trade
content-type:application/json
content-length:44

{"action":"BUY","ticker":"MMM","shares",44}^@
```