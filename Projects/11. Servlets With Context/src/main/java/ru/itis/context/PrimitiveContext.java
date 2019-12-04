package ru.itis.context;

import ru.itis.repositories.DataRepository;
import ru.itis.repositories.DataRepositoryImpl;
import ru.itis.services.SignUpService;
import ru.itis.services.SignUpServiceImpl;

public class PrimitiveContext {
    public DataRepository dataRepository() {
        return new DataRepositoryImpl();
    }

    public SignUpService signUpService() {
        return new SignUpServiceImpl(dataRepository());
    }
}
