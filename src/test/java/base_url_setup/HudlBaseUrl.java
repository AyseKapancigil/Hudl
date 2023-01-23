package base_url_setup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class HudlBaseUrl {

    public static RequestSpecification spec;

    public static void hudlSetup() {


        spec = new RequestSpecBuilder().setBaseUri("https://hudl.com").build();

    }

}
