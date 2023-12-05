package com.farma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**+
 *
 * Clase principal que maneja todo el proyecto mas bien ejecuta todo spring
 */
@SpringBootApplication
public class FarmaciaProyectoApplication extends WebMvcConfigurationSupport{

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaProyectoApplication.class, args);
	}

	// El paquete de guía de ruta para configurar archivos de recursos estáticos aquí se importa directamente de forma predeterminada.
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/static/**")
				.addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		registry
				.addResourceHandler("/webjars/**")
				.addResourceLocations("/webjars/").resourceChain(false);
		registry
				.addResourceHandler("/js/**")
				.addResourceLocations("/js/").resourceChain(false);

		registry
				.addResourceHandler("/css/**")
				.addResourceLocations("/css/").resourceChain(false);
		registry
				.addResourceHandler("/scss/**")
				.addResourceLocations("/scss/").resourceChain(false);
		registry
				.addResourceHandler("/vendor/**")
				.addResourceLocations("/vendor/").resourceChain(false);
		super.addResourceHandlers(registry);
	}

}
