package org.kyrex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class Main {

	private static final String USERS_FILE = Objects.requireNonNull(Main.class.getResource("/users.txt")).getPath();


	public static void main(String[] args) throws IOException {
		Predicate<String> isValid = line -> Stream.of("usr", "eme", "psw", "age", "loc", "fll")
			.map(key -> " " + key + ":") // Keys must be preceded by one space and followed by a colon to be valid
			.allMatch(line::contains);   // A line is valid if contains all the keys

		List<String> users = Arrays.stream(Files.readString(Path.of(USERS_FILE)).split("\n\n")) // 2 EOFs -> New user
			.map(user -> user.replace('\n', ' '))         // Merge all the keys of a user in a single line
			.map(user -> user.replaceFirst("^", " "))     // Add a leading space to apply the filter more easily
			.filter(isValid)                              // Filter the lines that are valid
			.toList();

		String lastUsername = users.get(users.size() - 1) // Get the last valid user
			.replaceFirst("^.*usr:", "")                  // Remove all the chars until 'usr:' (included)
			.replaceFirst(" .*$", "");                    // Remove all the chars from the first space until the end

		System.out.println("submit " + users.size() + lastUsername);
	}

}
