package com.dtotest.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/**
 * Created by liyf
 **/
public class InstanceUtil {

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

    put(map, Boolean.class, Boolean.TRUE);
    put(map, Short.class, Short.parseShort("1"));
    put(map, Integer.class, Integer.parseInt("1"));
    put(map, Long.class, Long.parseLong("1"));
    put(map, Float.class, Float.parseFloat("1"));
    put(map, Double.class, Double.parseDouble("1"));
    put(map, Character.class, Character.valueOf('1'));
    put(map, Byte.class, Byte.parseByte("1"));

    put(map, String.class, "1");

    put(map, BigInteger.class, BigInteger.ONE);
    put(map, BigDecimal.class, BigDecimal.ONE);

    put(map, Date.class, new Date());
    put(map, LocalDateTime.class, LocalDateTime.now());

    /* Collection Types. */
    put(map, Set.class, Collections.emptySet());
    put(map, SortedSet.class, Collections.emptySortedSet());
    put(map, List.class, Collections.emptyList());
    put(map, Map.class, Collections.emptyMap());
    put(map, SortedMap.class, Collections.emptySortedMap());
  }

  public static <T> T newInstance(Class<T> clazz, PropertyDescriptor[] props)
      throws IllegalAccessException, InstantiationException, InvocationTargetException {
    T obj = clazz.newInstance();
    for (PropertyDescriptor prop : props) {
      if (prop.getWriteMethod() != null) {
        prop.getWriteMethod().invoke(obj, createPropertyValue(prop.getPropertyType()));
      }
    }
    return obj;
  }

  public static Object createPropertyValue(Class clazz) {
    if (clazz.isEnum()) {
      return clazz.getEnumConstants()[0];
    } else {
      return map.get(clazz);
    }
  }

  private static <T> void put(Map<Class<?>, Object> map, Class<T> clazz, T value) {
    map.put(clazz, value);
  }
}
