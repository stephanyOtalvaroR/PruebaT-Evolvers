package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GetReserva implements Task {

    private String idReserva;

    public GetReserva (String idReserva){
        this.idReserva = idReserva;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource("/booking/"+idReserva)
                .with(peticion -> peticion.
                        header("Accept","application/json")));

    }
    public static GetReserva detalles(String idReserva){
        return instrumented(GetReserva.class, idReserva);
    }


}
