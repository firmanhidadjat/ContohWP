package id.co.firman;

import org.apache.camel.builder.RouteBuilder;

//@Component
public class CamelRouterPertama extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://dodol?fixedRate=true&period=1000")
		.to("log: Eksekusi dari Router Camel?level=INFO&showHeaders=false&showBodyType=false&showExchangePattern=false");
		
	}
}
