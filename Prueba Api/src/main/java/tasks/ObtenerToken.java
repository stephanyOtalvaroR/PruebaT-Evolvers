package tasks;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerToken implements Task {

    private Map<String, String> credenciales;

    public ObtenerToken(Map<String, String> credenciales) {
        this.credenciales = credenciales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        String json = gson.toJson(credenciales);

        actor.attemptsTo(Post.to("/auth").with(request -> request
                .header("Content-Type", "application/json")
                .body(json)));

        actor.remember("token", SerenityRest.lastResponse().jsonPath().get("token").toString());

    }

    public static ObtenerToken token(Map<String, String> credenciales) {
        return instrumented(ObtenerToken.class, credenciales);
    }
}
