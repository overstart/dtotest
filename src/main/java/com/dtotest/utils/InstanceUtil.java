package com.dtotest.utils;

import com.dtotest.factory.PropertyValueInitializer;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liyf
 **/
public class InstanceUtil {

  private InstanceUtil() {
    super();
  }

  public static <T> T newInstance(Class<T> clazz, PropertyDescriptor[] props,
      PropertyValueInitializer propertyValueInitializer)
      throws IllegalAccessException, InstantiationException, InvocationTargetException {
    T obj = clazz.newInstance();
    for (PropertyDescriptor prop : props) {
      if (prop.getWriteMethod() != null) {
        prop.getWriteMethod().invoke(obj,
            propertyValueInitializer.createPropertyValue(prop.getPropertyType()));
      }
    }
    return obj;
  }
}
