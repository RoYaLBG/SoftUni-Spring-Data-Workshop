package com.example.demoWeb.services.util;

public interface DataConverter {

    <T> T deserialize(String input, Class<T> type);

    String serialize(Object o);

}
