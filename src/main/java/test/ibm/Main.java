package test.ibm;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.ibm.entity.Provider;
import test.ibm.services.DatabaseService;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private final DatabaseService databaseService;

	public Main(final DatabaseService dbService) {
		this.databaseService = dbService;
	}

	public static void main(final String[] args) {
		final SpringApplication app = new SpringApplication(Main.class);
// disable spring banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(final String... args) throws Exception {
		final Provider p = new Provider(1, "Coca-cola", 5, LocalDateTime.now());
		final Provider p2 = new Provider(2, "Pepsi", 5, LocalDateTime.now());
		final Provider p3 = new Provider(3, "Redbull", 6, LocalDateTime.now());

		databaseService.CreateProvider(p);
		databaseService.CreateProvider(p2);
		databaseService.CreateProvider(p3);

		final List<Provider> resultado = databaseService.GetAll();
		final List<Provider> finalResult = resultado.stream()
				.filter(x -> x.getCustomerId().equals(Integer.parseInt(args[0]))).collect(Collectors.toList());
		if (finalResult.isEmpty()) {
			System.out.println("El cliente no tiene proveedores asignados");
		} else {
			final FileWriter writer = new FileWriter("Proveedores.csv");
			writer.write("ID;NOMBRE;CLIENTE;FECHA\n");

			finalResult.forEach(provider -> {
				final String prov = String.format("%s;%s;%s;%s\n", provider.getId(), provider.getName(),
						provider.getCustomerId(), provider.getCreationDate());
				try {
					writer.write(prov);
				} catch (final IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			writer.close();
		}
	}
}
