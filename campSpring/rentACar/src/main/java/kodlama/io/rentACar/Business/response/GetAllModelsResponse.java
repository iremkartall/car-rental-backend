package kodlama.io.rentACar.Business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllModelsResponse {

		private int id;
		private String name;
		private String brandName;
		
}
