package pe.com.bank.customer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="customer")
public class Customer {
	
	@Id
	private String id;
	private String customerType;	
	private String dateAssociated;
	private String category;

}
