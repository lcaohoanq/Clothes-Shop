package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserGoogleDTO {

	private String id;
	private String email;
	private boolean verified_email;
	private String name;
	private String given_name;
	private String family_name;
	private String picture;

}
