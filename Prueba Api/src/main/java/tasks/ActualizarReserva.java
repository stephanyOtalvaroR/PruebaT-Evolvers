package tasks;

import interactions.ConvertToJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarReserva implements Task {

    private ConvertToJson convertJson;

    private String idReserva;

    private Map<String, String> requestBody;

    public ActualizarReserva(Map<String, String> requestBody, String idReserva) {
        this.requestBody = requestBody;
        this.idReserva = idReserva;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        convertJson = new ConvertToJson(requestBody);
        actor.attemptsTo(Put.to("/booking/" + idReserva).with(Actualizar -> Actualizar
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + actor.recall("token").toString())
                        .body(convertJson.getJson())
                )

        );

    }

    public static ActualizarReserva actualizacion(Map<String, String> requestBody, String idReserva) {
        return instrumented(ActualizarReserva.class, requestBody, idReserva);
    }

}
