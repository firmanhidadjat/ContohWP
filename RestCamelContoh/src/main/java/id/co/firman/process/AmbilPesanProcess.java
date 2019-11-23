package id.co.firman.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import id.co.firman.dto.PesanReq;
import id.co.firman.dto.PesanResp;

@Component
public class AmbilPesanProcess implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// Ambil data pada exchange body yang merupakan object PesanReq
		PesanReq requestData = exchange.getIn().getBody(PesanReq.class);
		
		String nama = requestData.getNama();
		
		PesanResp response = PesanResp.builder()
		.kode("7000")
		.message("Hallo, "+nama+". Ini pesan statis dari aplikasi REST Camel: DODOL").build();
		
		exchange.getIn().setBody(response);		
	}

}
