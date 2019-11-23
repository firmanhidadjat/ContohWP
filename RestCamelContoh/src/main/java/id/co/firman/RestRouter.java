package id.co.firman;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.firman.dto.PesanReq;
import id.co.firman.dto.TambahReq;
import id.co.firman.process.AmbilPesanProcess;
import id.co.firman.process.TambahProcess;

@Component
public class RestRouter extends RouteBuilder {
	
	@Autowired
	private AmbilPesanProcess getDataStatisProcess;
	
	@Autowired
	private TambahProcess tambahProcess;

	@Override
	public void configure() throws Exception {
		// Konfigurasi untuk menggunakan netty-http 
		restConfiguration().component("netty-http").host("0.0.0.0").port(8881)
		.bindingMode(RestBindingMode.json);
		
		// penggunaan rest DSL
		rest("/serviceRest")
		
		.post("/ambilPesan").consumes("application/json").produces("application/json")
		.type(PesanReq.class).to("seda:router_Jenis_Get")
		
		.post("/operasiTambah").consumes("application/json").produces("application/json")
		.type(TambahReq.class).to("seda:router_OperasiTambah");
		
		
		from("seda:router_Jenis_Get").process(getDataStatisProcess);
		
		
		from("seda:router_OperasiTambah").process(tambahProcess);
		
		
	}
}
