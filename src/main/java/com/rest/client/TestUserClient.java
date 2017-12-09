package com.rest.client;

import com.sun.jersey.api.client.*;

public class TestUserClient {

	public static void main(String[] args) {
		addUser();
		// getUser();
		// getUsers();
		// deleteUser();
	}

	private static void addUser() {
		String input = "{\"age\":34,\"gender\":null,\"name\":\"John\"}";
		Client c = Client.create();
		WebResource resource = c.resource("http://localhost:8080/SimpleREST/rest/app/create");
		ClientResponse response = resource.type("application/json").post(ClientResponse.class, input);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		System.out.println(response);
	}

	private static void getUser() {
		Client c = Client.create();
		WebResource resource = c.resource("http://localhost:8080/SimpleREST/rest/app/user/1");
		ClientResponse response = resource.type("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		System.out.println(resource.get(String.class) + "  " + response);
	}

	private static void getUsers() {
		Client c = Client.create();
		WebResource resource = c.resource("http://localhost:8080/SimpleREST/rest/app/users");
		ClientResponse response = resource.type("application/json").get(ClientResponse.class);
		System.out.println(resource.get(String.class));
		System.out.println(response);
	}

	public static void deleteUser() {
		Client c = Client.create();
		WebResource resource = c.resource("http://localhost:8080/SimpleREST/rest/app/delete/2");
		ClientResponse response = resource.type("application/json").delete(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		System.out.println(response);
	}
}
