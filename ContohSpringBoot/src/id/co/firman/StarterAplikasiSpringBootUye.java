package id.co.firman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterAplikasiSpringBootUye {
	public static void main(String[] args) {
		SpringApplication.run(StarterAplikasiSpringBootUye.class, args);
		System.out.println("Aplikasi Spring Boot berhasil dijalankan.");
		System.out.println("Sekarang aplikasi shut down.");
	}

}
