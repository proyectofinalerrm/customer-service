package pe.com.bank.customer.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import pe.com.bank.customer.client.entity.AccountEntity;
import reactor.core.publisher.Flux;

@Component
public class AccountRestClient {
	
	private WebClient webClient;		
	  
	  public AccountRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.accountUrl}")
	  private String accountUrl;
	  

	  public Flux<AccountEntity> getAccountByCustomerId(String customerId){
		  var url = accountUrl.concat("/customer/{id}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId)
	                .retrieve()
	                .bodyToFlux(AccountEntity.class)
	                .log();

	  }
	  
	  public Flux<AccountEntity> getAccountByCustomerIdAndProductId(String customerId,String productId){
		  var url = accountUrl.concat("/customerId/{customerId}/productId/{productId}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId,productId)
	                .retrieve()
	                .bodyToFlux(AccountEntity.class)
	                .log();

	  }
	  
	  
}
