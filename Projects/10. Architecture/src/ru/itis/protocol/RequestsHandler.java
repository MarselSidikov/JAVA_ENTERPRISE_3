package ru.itis.protocol;

import ru.itis.dispatcher.RequestsDispatcher;

// обрабатывает запрос на уровне протокола
public class RequestsHandler {

    private RequestsDispatcher dispatcher;

    public RequestsHandler() {
        this.dispatcher = new RequestsDispatcher();
    }

    // метод-реакция на запрос
    public Response<?> handleRequest(Request request) {
        // направление запроса куда-то дальше
        // чтобы диспетчер мог его перенаправить на слой логики
        // получили данные
        // обернули в протокол
        return Response.build(dispatcher.doDispatch(request));
    }
}
