package fileEncryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utility.ConsoleInput;

public class FileEncryptionDemo {

	private static final String FILE_NAME = "data.txt";
	private static final int KEY = 3;

	public static String encrypt(String data) {
		StringBuilder result = new StringBuilder();

		for (char ch : data.toCharArray()) {
			result.append((char) (ch + KEY));
		}

		return result.toString();
	}

	public static String decrypt(String data) {
		StringBuilder result = new StringBuilder();

		for (char ch : data.toCharArray()) {
			result.append((char) (ch - KEY));
		}

		return result.toString();
	}

	public static void main(String[] args) {

		System.out.print("Enter data: ");
		String data = ConsoleInput.getString();

		String encryptedData = encrypt(data);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

			writer.write(encryptedData);

			System.out.println("Encrypted data saved in file.");

		} catch (IOException e) {

			System.out.println("Error while writing file.");

		}

		String fileData = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

			fileData = reader.readLine();

		} catch (IOException e) {

			System.out.println("Error while reading file.");

		}

		String decryptedData = decrypt(fileData);

		System.out.println("Encrypted Data: " + fileData);
		System.out.println("Decrypted Data: " + decryptedData);
	}}
