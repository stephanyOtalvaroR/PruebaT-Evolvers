package tasks;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import interactions.ConvertToJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CrearReserva implements Task {

    private ConvertToJson convertJson;

    private Map<String, String> requestBody;

    public CrearReserva(Map<String, String> requestBody) {
        this.requestBody = requestBody;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        convertJson = new ConvertToJson(requestBody);
        actor.attemptsTo(Post.to("/booking").with(crear -> crear
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(convertJson.getJson()))
        );


    }

    public static CrearReserva datos(Map<String, String> requestBody) {
        return instrumented(CrearReserva.class, requestBody);
    }
}
