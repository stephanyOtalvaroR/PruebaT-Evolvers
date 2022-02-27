package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.ActualizarReserva;
import tasks.ObtenerToken;

import java.util.Map;

public class UpdateBookingStepDefinitions {

    @Dado("^obtiene el token de acceso con los datos necesarios$")
    public void obtieneElTokenDeAccesoConLosDatosNecesarios(Map<String, String> credenciales) {
        OnStage.theActorInTheSpotlight().attemptsTo(ObtenerToken.token(credenciales));

    }


    @Cuando("^el usuario actualiza los datos de la reserva \"([^\"]*)\"$")
    public void elUsuarioActualizaLosDatosDeLaReserva(String idReserva, Map<String, String> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(ActualizarReserva.actualizacion(datos, idReserva));

    }


}
