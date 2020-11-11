package com.psawesome.testcodeproject.functioninenum;

import org.junit.jupiter.api.Test;

class CallByEnumTest {

  @Test
  void testCallFunctionInEnum() {

  }

}



enum BaseballState {
  READY(),
  START(),
  END(),

}

enum UserAct {
  START(),
  SUBMIT(),
  QUIT()
}