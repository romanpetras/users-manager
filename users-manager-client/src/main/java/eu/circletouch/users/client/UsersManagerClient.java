package eu.circletouch.users.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import eu.circletouch.users.beans.Credentials;
import eu.circletouch.users.beans.LoginResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class UsersManagerClient {

    private static final String REST_SERVICE_PATH = "/users-manager-service";
    private static final String AUTH_PATH = "/auth";
    public static final String APPLICATION_JSON = "application/json";

    private Client client;
    private WebTarget restUriWebTarget;

    private String baseUrl;

    public UsersManagerClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void initClient() {
        client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        restUriWebTarget = client.target(baseUrl + REST_SERVICE_PATH);
    }

    public LoginResponse createAuthenticationToken(Credentials credentials) {
        initClient();
        LoginResponse loginResponse = restUriWebTarget.path(AUTH_PATH).path("/").request(APPLICATION_JSON).post(Entity.entity(credentials, APPLICATION_JSON), LoginResponse.class);
        client.close();
        return loginResponse;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public WebTarget getRestUriWebTarget() {
        return restUriWebTarget;
    }

    public void setRestUriWebTarget(WebTarget restUriWebTarget) {
        this.restUriWebTarget = restUriWebTarget;
    }
}
