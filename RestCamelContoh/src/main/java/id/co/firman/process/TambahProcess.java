package id.co.firman.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import id.co.firman.dto.TambahReq;
import id.co.firman.dto.TambahResp;

@Component
public class TambahProcess implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// Ambil data pada exchange body yang merupakan object TambahReq
		TambahReq requestData = exchange.getIn().getBody(TambahReq.class);
		
		Integer bilanganPertama = requestData.getBilanganPertama();
		Integer bilanganKedua = requestData.getBilanganKedua();
		
		Integer hasilPenjumlahan = bilanganPertama + bilanganKedua;
		
		TambahResp response = TambahResp.builder()
		.hasil(hasilPenjumlahan)
		.build();
		
		exchange.getIn().setBody(response);		
	}

}
