package clothingstore.controller.web.login;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import clothingstore.constant.GoogleAuthentication;
import clothingstore.model.UserGoogleDTO;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class LoginGoogle {
    public static String getToken(String code) throws IOException {
        String response = Request.Post(GoogleAuthentication.GOOGLE_LINK_GET_TOKEN)
            .bodyForm(
                Form.form()
                    .add("client_id", GoogleAuthentication.GOOGLE_CLIENT_ID)
                    .add("client_secret", GoogleAuthentication.GOOGLE_CLIENT_SECRET)
                    .add("redirect_uri", GoogleAuthentication.GOOGLE_REDIRECT_URI)
                    .add("code", code)
                    .add("grant_type", GoogleAuthentication.GOOGLE_GRANT_TYPE)
                    .build()
            )
            .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    // receive the information of account when pass the accessToken
    public static UserGoogleDTO getUserInfo(final String accessToken) throws IOException {
        String link = GoogleAuthentication.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);
        return googlePojo;
    }
}
