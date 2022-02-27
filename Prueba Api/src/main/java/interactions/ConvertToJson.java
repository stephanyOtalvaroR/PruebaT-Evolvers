package interactions;

import java.util.Map;

public class ConvertToJson {
    public String json;

    public ConvertToJson(Map<String, String> datos) {

        this.json = "{\"firstname\" : \"" + datos.get("firstname") + "\"," +
                "\"lastname\" : \"" + datos.get("lastname") + "\"," +
                "\"totalprice\" : " + datos.get("totalprice") + "," +
                "\"depositpaid\" : " + datos.get("depositpaid") + "," +
                "\"bookingdates\" : {" +
                "\"checkin\" : \"" + datos.get("checkin") + "\"," +
                "\"checkout\" : \"" + datos.get("checkout") + "\"" +
                "}," +
                "\"additionalneeds\" : \"" + datos.get("additionalneeds") + "\"}";
    }

    public String getJson() {
        return json;
    }

}
