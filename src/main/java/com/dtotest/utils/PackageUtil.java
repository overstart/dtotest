package com.dtotest.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 * Created by liyf
 **/
public class PackageUtil {

  public static List<Class> getClasses(String packageName, Class[] ignoreClasses)
      throws ClassNotFoundException, IOException {
    List<Class> ignoreClassList =
        ignoreClasses == null ? Collections.emptyList() : Arrays.asList(ignoreClasses);

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    String path = packageName.replace(".", File.separator);
    Enumeration<URL> resources = classLoader.getResources(path);
    List<Class> classList = new ArrayList<>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      File dir = new File(Objects.requireNonNull(resource).getFile());
      classList.addAll(findClasses(dir, packageName, ignoreClassList));
    }

    return classList;
  }

  private static List<Class> findClasses(File directory, String packageName,
      List<Class> ignoreClasseList) throws ClassNotFoundException {
    if (!directory.exists()) {
      return Collections.<Class>emptyList();
    }
    List<Class> classes = new ArrayList<>();
    File[] files = directory.listFiles();

    for (File file : Objects.requireNonNull(files)) {
      if (file.isDirectory()) {
        classes.addAll(findClasses(file, packageName + "." + file.getName(), ignoreClasseList));
      } else if (file.getName().endsWith(".class")) {
        Class clazz = Class
            .forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
        boolean isIgnore = ignoreClasseList.contains(clazz);
        if (isIgnore) {
          continue;
        }
        classes.add(clazz);
      }
    }
    return classes;
  }
}
