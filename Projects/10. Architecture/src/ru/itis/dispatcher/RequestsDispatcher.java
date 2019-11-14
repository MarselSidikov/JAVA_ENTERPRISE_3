package ru.itis.dispatcher;

import ru.itis.dto.Dto;
import ru.itis.protocol.Request;
import ru.itis.services.SignInService;

public class RequestsDispatcher {

    private SignInService service;

    public RequestsDispatcher(SignInService service) {
        this.service = service;
    }

    public Dto doDispatch(Request request) {
        if (request.getCommand().equals("signIn")) {
            return service.signIn(request.getParameter("login"),
                    request.getParameter("password"));
        } else throw new IllegalArgumentException();
    }
}
