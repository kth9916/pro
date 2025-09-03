package com.asan.pro.domain.shared;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.*;

public class JsonUtil {
    public static String toJson(Object target) {
        if (target == null) {
            return "";
        } else {
            String result = "";
            ObjectMapper mapper = getObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            try {
                ObjectWriter writer = mapper.writer().withoutAttribute("logger");
                return writer.writeValueAsString(target);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return result;
            }
        }
    }

    public static String toPrettyJson(Object target) {
        if (target == null) {
            return "";
        } else {
            String result = "";
            ObjectMapper mapper = getObjectMapper();

            try {
                ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter().withoutAttribute("logger");
                return writer.writeValueAsString(target);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return result;
            }
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json != null && json.trim().length() != 0) {
            if (clazz == String.class) {
                return (T)json;
            } else {
                T result = null;
                ObjectMapper mapper = getObjectMapper();
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                try {
                    result = (T)mapper.readValue(json, clazz);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                return result;
            }
        } else {
            return null;
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        if (json != null && json.trim().length() != 0) {
            if (typeReference.getType() == String.class) {
                return (T)json;
            } else {
                T result = null;
                ObjectMapper mapper = getObjectMapper();
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                try {
                    result = (T)mapper.readValue(json, typeReference);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                return result;
            }
        } else {
            return null;
        }
    }

    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        if (json != null && json.trim().length() != 0) {
            List<T> results = new ArrayList();
            ObjectMapper mapper = getObjectMapper();

            try {
                JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
                results = (List)mapper.readValue(json, type);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return results;
        } else {
            return Collections.emptyList();
        }
    }

    public static <T> Set<T> fromJsonSet(String json, Class<T> clazz) {
        if (json != null && json.trim().length() != 0) {
            Set<T> results = new HashSet();
            ObjectMapper mapper = getObjectMapper();

            try {
                JavaType type = mapper.getTypeFactory().constructCollectionType(Set.class, clazz);
                results = (Set)mapper.readValue(json, type);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return results;
        } else {
            return Collections.emptySet();
        }
    }

    public static boolean isValid(String json) {
        ObjectMapper mapper = getObjectMapper();

        try {
            mapper.readTree(json);
            return true;
        } catch (JacksonException var3) {
            return false;
        }
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = ((JsonMapper.Builder)((JsonMapper.Builder)((JsonMapper.Builder)JsonMapper.builder().enable(new MapperFeature[]{MapperFeature.PROPAGATE_TRANSIENT_MARKER})).disable(new DeserializationFeature[]{DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES})).disable(new SerializationFeature[]{SerializationFeature.FAIL_ON_EMPTY_BEANS})).build();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    private JsonUtil() {
    }
}
