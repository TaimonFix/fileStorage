package ru.rosatom.edu.bratyshevTD.fileStorage;

import org.junit.jupiter.api.Test;

import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileStorageApplicationTests {

	@Test
	void testOne() {
		String text = "abc=";
		System.out.println(Arrays.toString(text.getBytes()));
		FileStorage fileStorage = new FileStorage(1L, Base64.getEncoder().encode(text.getBytes()),"test.txt", new Date(), "test");
		byte[] dec = Base64.getDecoder().decode(fileStorage.getFile());
		assertEquals(new String(dec), text);
	}

	@Test
	void testTwo() {
		FileStorage fileStorage = new FileStorage(1L, new byte[]{97, 98, 99, 61}, "test2.txt", new Date(), "test");

		assertEquals(new String(fileStorage.getFile()), "abc=");

	}

}
