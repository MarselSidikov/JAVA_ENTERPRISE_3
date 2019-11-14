package ru.itis.protocol;

// объект, который относится к протоколу

// например, HttpServletResponse
public class Response<T> {
    private T data;

    private Response(T data) {
        this.data = data;
    }

    public static <E> Response<E> build(E data) {
        return new Response<>(data);
    }
}
