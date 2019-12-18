package com.dtotest.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyf
 **/
public class NullPropertyValueFactory implements PropertyValueInitializer {
  private static Map<Class<?>, Object> map = new HashMap<>();

  static {
    put(map, boolean.class, true);
    put(map, short.class, (short) 1);
    put(map, int.class, 1);
    put(map, long.class, 1L);
    put(map, float.class, 1F);
    put(map, double.class, 1D);
    put(map, char.class, '1');
    put(map, byte.class, (byte) 1);
  }
  @Override
  public Object createPropertyValue(Class<?> clazz) {
    if (clazz.isPrimitive()) {
      return map.get(clazz);
    }
    return null;
  }

  private static <T> void put(Map<Class<?>, Object> map, Class<T> clazz, T value) {
    map.put(clazz, value);
  }
}
