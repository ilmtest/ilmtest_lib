package com.ilmtest.util.text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextUtilsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNormalizeString()
	{
		assertEquals( "Test Hi", TextUtils.normalize("Test (1) Hi", true) );
		assertEquals( "Test Hi", TextUtils.normalize("Test [1] Hi", true) );
		assertEquals( "This cool", TextUtils.normalize("Thi[s: ،* cool", true) );
		assertEquals( "This cool", TextUtils.normalize("Thi(s) cool", true) );
		assertEquals( "I am here", TextUtils.normalize("I am - \\ here", true) );
	}
}