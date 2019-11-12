package com.dtotest.demo;

import com.dtotest.DtoExtension;
import com.dtotest.bind.annotation.DtoPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by liyf
 **/
@ExtendWith(DtoExtension.class)
class SomeDtoTest {

  @Test
  @DtoPackage(value = "com.dtotest.demo.dto", echoClass = true)
  void testDto() {
    Assertions.assertTrue(true);
  }

}
