package com.example.java.stringUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilsTest {

	@Test
	@DisplayName("StringUtils 의 isBlank() 테스트 빈 값인 경우")
	void StringUtilsIsBlankTest() {
	    // given
	    String str = "";
	    // when
		boolean result = StringUtils.isBlank(str);
		// then
		assertEquals(result, true);
	}

	@Test
	@DisplayName("StringUtils 의 isBlank() 테스트 널 값인 경우")
	void StringUtilsIsBlankTest2() {
		// given
		String str = null;
		// when
		boolean result = StringUtils.isBlank(str);
		// then
		assertEquals(result, true);
	}

	@Test
	void StringIsBlankTest() {
	    // given
	    String str = null;
	    // when
		// then
		assertThrows(NullPointerException.class, () -> str.isBlank());
	}
}
