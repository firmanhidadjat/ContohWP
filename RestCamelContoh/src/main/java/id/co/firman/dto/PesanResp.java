package id.co.firman.dto;

import java.io.Serializable;

import id.co.firman.dto.PesanReq.PesanReqBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PesanResp implements Serializable {
	private String kode;
	private String message;

}
