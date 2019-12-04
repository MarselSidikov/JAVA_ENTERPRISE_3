package ru.itis.services;

import ru.itis.repositories.DataRepository;

public class SignUpServiceImpl implements SignUpService {

    private DataRepository dataRepository;

    public SignUpServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void signUp(String data) {
        dataRepository.save(data);
        System.out.println("In SignUp " + data);
    }
}
