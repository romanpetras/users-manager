package eu.circletouch.users.client;

import eu.circletouch.users.beans.Credentials;
import eu.circletouch.users.beans.LoginResponse;

public class UsersManagerClientTest {

    public static void main(String[] args) {

//        String baseUrl = "http://users-manager-service";
        String baseUrl = "http://localhost:8081";
        UsersManagerClient umc = new UsersManagerClient(baseUrl);

        Credentials credentials = new Credentials();
        credentials.setUsername("admin");
        credentials.setPassword("circle1423");

        LoginResponse loginResponse = umc.createAuthenticationToken(credentials);

        if (loginResponse != null) {
            System.out.println("Username : " + loginResponse.getUser().getUsername());

            if (loginResponse.getUser() != null) {
                System.out.println("Token : " + loginResponse.getToken());
            }
        }

    }

}
