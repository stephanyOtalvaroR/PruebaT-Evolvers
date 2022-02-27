package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.core.IsEqual;
import questions.ValidarReserva;
import tasks.GetReserva;

import java.util.List;

public class GetBookingStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Step");

    }

    @Dado("^que Establece el url base del api$")
    public void queEstableceElUrlBaseDelApi(List<String> api) {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(api.get(0)));

    }


    @Cuando("^el usuario busca una reserva con el id \"([^\"]*)\"$")
    public void elUsuarioBuscaUnaReservaConElId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetReserva.detalles(id));

    }

    @Entonces("^el usuario valida la respuesta del servicio \"([^\"]*)\"$")
    public void elUsuarioValidaLaRespuestaDelServicio(String statusCode) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarReserva.ReservaValidacion(),
                IsEqual.equalTo(Integer.parseInt(statusCode))));
    }

}
