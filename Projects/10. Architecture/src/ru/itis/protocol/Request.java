package ru.itis.protocol;

public class Request {

    public String getCommand() {
        return "signIn";
    }

    public String getParameter(String name) {
        if (name.equals("password")) {
            return "qwerty007";
        } else {
            return "marsel";
        }
    }
}
