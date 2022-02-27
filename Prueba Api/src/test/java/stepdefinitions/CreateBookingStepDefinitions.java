package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import questions.ValidarCreacion;
import questions.ValidarReserva;
import tasks.CrearReserva;

import java.util.List;
import java.util.Map;

public class CreateBookingStepDefinitions {

    @Dado("^que establece el url base del api$")
    public void queEstableceElUrlBaseDelApi(List<String> web) {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(web.get(0)));

    }

    @Cuando("^el usuario crea las nuevas reservas para el api$")
    public void elUsuarioCreaLasNuevasReservasParaElApi(Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(CrearReserva.datos(datos));


    }

    @Entonces("^se valida que la reserva se cree correctamente$")
    public void seValidaQueLaReservaSeCreeCorrectamente() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCreacion.ValidarReservaCreacion(),
                IsNot.not(Matchers.nullValue())));

    }
}
