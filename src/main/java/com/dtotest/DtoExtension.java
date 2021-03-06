package com.dtotest;

import com.dtotest.bind.annotation.DtoPackage;
import com.dtotest.factory.NullPropertyValueFactory;
import com.dtotest.factory.PropertyValueInitializer;
import com.dtotest.factory.RandomPropertyValueFactory;
import com.dtotest.utils.InstanceUtil;
import com.dtotest.utils.PackageUtil;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

/**
 * Created by liyf
 **/
public class DtoExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {

  }

  private static NullPropertyValueFactory nullPropertyValueFactory = new NullPropertyValueFactory();
  private static RandomPropertyValueFactory randomPropertyValueFactory = new RandomPropertyValueFactory();

  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    DtoPackage dtoPackage = AnnotationUtils
        .findAnnotation(context.getRequiredTestMethod(), DtoPackage.class)
        .orElse(null);
    if (dtoPackage == null) {
      return;
    }

    for (String packageName : dtoPackage.value()) {
      List<Class> classList = PackageUtil.getClasses(packageName, dtoPackage.ignoreClasses());
      for (Class clazz : classList) {
        if (dtoPackage.echoClass()) {
          System.out.println("test dto class: " + clazz.getName());
        }
        BeanInfo bi = Introspector.getBeanInfo(clazz, Object.class);
        PropertyDescriptor[] props = bi.getPropertyDescriptors();
        Object obj = InstanceUtil.newInstance(clazz, props, randomPropertyValueFactory);
        callGetterSuccess(obj, props, randomPropertyValueFactory);
      }
      if (dtoPackage.checkNull()) {
        for (Class clazz : classList) {
          BeanInfo bi = Introspector.getBeanInfo(clazz, Object.class);
          PropertyDescriptor[] props = bi.getPropertyDescriptors();
          Object obj = InstanceUtil.newInstance(clazz, props, nullPropertyValueFactory);
          callGetterSuccess(obj, props, nullPropertyValueFactory);
        }

      }
    }
  }

  private void callGetterSuccess(Object obj, PropertyDescriptor[] props,
      PropertyValueInitializer propertyValueInitializer)
      throws InvocationTargetException, IllegalAccessException {
    for (PropertyDescriptor prop : props) {
      if (prop.getReadMethod() == null) {
        continue;
      }
      Object getResult = prop.getReadMethod().invoke(obj);
      Object expect = prop.getWriteMethod() == null ? null
          : propertyValueInitializer.createPropertyValue(prop.getPropertyType());
      if (prop.getPropertyType().isPrimitive()) {
        Assertions.assertEquals(expect, getResult);
      } else {
        Assertions.assertSame(expect, getResult);
      }
    }
  }

}
