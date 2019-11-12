# dtotest
> Junit5插件， 用于项目`DTO`单元测试， 无任何依赖，大小不到10k
## 目标
>目前的代码覆盖率统计工具智商堪忧，为了提高单元测试覆盖率，把所有的javabean都写一遍单元测试简直浪费生命。此工具可以帮用户自动完成这种无聊的事情。

## 使用方法

### 1. 工程中引入依赖包
maven: 
```xml
<dependency>
	<groupId>io.github.overstart</groupId>
	<artifactId>dtotest</artifactId>
	<version>1.0</version>
    <scope>test</scope>
</dependency>
```

gradle:
```groovy
testCompile 'io.github.overstart:dtotest:1.0'
```

### 2. 添加单元测试方法
```java
@ExtendWith(DtoExtension.class)
class SomeDtoTest {

  @Test
  @DtoPackage(value = "com.dtotest.demo.dto", echoClass = true)
  void testDto() {
    Assertions.assertTrue(true);
  }

}

```

### 3. @DtoPackage注解说明

```bash
 
  String[] value() default {}; // dto包名数组， 递归查找

  Class[] ignoreClasses() default {}; // 忽略类

  boolean echoClass() default false; // 是否显示测试涉及的dto
```