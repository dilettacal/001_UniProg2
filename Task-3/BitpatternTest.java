
/*
 * 
 * Datum: 01.05.2017
 * 
 * Unit-Test/Testklasse fuer Bitpattern
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BitpatternTest {
	static int test = 0;

	@Test
	public void testSetBitNormalfall() {
		// Test Normalfall:
		// erfolgreich
		int z = 10;
		test = Bitpattern.setBit(z, 2); // 14
		assertEquals(test, 14); // true
		System.out.println(test);

		// Bit schon besetzt
		int z1 = 7;
		test = Bitpattern.setBit(z1, 2); // 7
		assertEquals(test, 7); // true
		System.out.println(test);
	}

	@Test
	public void testSetBitGrenzwerte() {
		int z1 = 0;
		int z2 = 2147483647;
		// ganzes Range besetzbar
		test = Bitpattern.setBit(z1, 0);
		assertEquals(test, 1);
		System.out.println(test);

		// kein freies Bit mehr moeglich
		test = Bitpattern.setBit(z2, 30);
		assertTrue(z2 == test);
		System.out.println(test);
	}

	// Test fuer unzulaessiges Argument
	@Test(expected = IllegalArgumentException.class)
	public void testSetBitException(){
		int z3 = 42;
		// Index ausserhalb des Range
		test = Bitpattern.setBit(z3, 37);

		// Argument negativ
		test = Bitpattern.setBit(z3, -5);

	}

	@Test
	public void testInBinaryNormalfall() {
		int[] testArray = null;
		testArray = Bitpattern.inBinary(10);
		int[] erwartetesArray = { 1, 0, 1, 0 };
		assertTrue(Arrays.equals(erwartetesArray, testArray)); //vergleicht Inhalt der Arrays
		Bitpattern.printBinpattern(testArray);

		testArray = Bitpattern.inBinary(127);
		int[] erwartetesArray2 = { 1, 1, 1, 1, 1, 1, 1 };
		assertTrue(Arrays.equals(erwartetesArray2, testArray));
		Bitpattern.printBinpattern(testArray);
	}

	@Test
	public void testInBinaryNullFall() {
		int[] testArray = null;
		testArray = Bitpattern.inBinary(0);
		int[] erwartetesArray = { 0 };
		assertTrue(Arrays.equals(erwartetesArray, testArray));
		Bitpattern.printBinpattern(testArray);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInBinaryException() {
		int[] testArray = null;
		int num = -12;
		testArray = Bitpattern.inBinary(num);
		num = 12;
		testArray = Bitpattern.inBinary(num);
	}

	@Test
	public void testEndsOnNormalfall() {
		boolean endsOn = false;
		// Test erfolgreicher Fall
		endsOn = Bitpattern.endsOn(7, "11");
		System.out.println(endsOn);
		assertEquals(endsOn, true);

		// Test erfolgloser Fall
		endsOn = Bitpattern.endsOn(10, "11");
		System.out.println(endsOn);
		assertEquals(endsOn, false);
	}
	
	//Test fuer zu langes Pattern
	@Test
	public void testEndsOnLangPattern() {
		boolean endsOn = false;
		// Test langes Pattern --> false
		endsOn = Bitpattern.endsOn(10, "11001010");
		System.out.println(endsOn);
		assertEquals(endsOn, false);
	}
	
	@Test(expected = NullPointerException.class)
	public void testPrintBitpatternException() {
		int[] array = null;
		Bitpattern.printBinpattern(array);		

	}

}
