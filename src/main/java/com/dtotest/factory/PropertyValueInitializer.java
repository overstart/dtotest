package com.dtotest.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyf
 **/
public interface PropertyValueInitializer {

  Object createPropertyValue(Class<?> clazz);
}
