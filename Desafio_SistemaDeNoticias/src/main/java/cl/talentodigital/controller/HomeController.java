package cl.talentodigital.controller;  //debe estar en su propio package

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.talentodigital.controller.HomeController;

@Controller //siempre escibir este estereotipo e importarlo, sirve para hacer las funciones de controlador de arranque

public class HomeController {
	private final static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/") //le estamos diciendo a donde debe ir
	public String Main (Model model ) {
		String nombre = "src/main/resources/static/noticias.txt";
		ArrayList<String> noticias = new ArrayList<String>(); //este arraylist tiene todas las filas
		try {
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			while (data != null) {
				noticias.add(data);
				log.info("la noticia fue agregada de forma correcta");
				data = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			log.error("Error leyendo el fichero " + nombre + ": " + e);
		}
		
		String noticias1[]= noticias.get(0).split("@@");  //arreglo estatico, que se forma por el split y en la posicion 0, tendra el primer elemento del arreglo dinamico
		String noticias2[]= noticias.get(1).split("@@");
		String noticias3[]= noticias.get(2).split("@@");
		String noticias4[]= noticias.get(3).split("@@");
		String noticias5[]= noticias.get(4).split("@@");
		
		model.addAttribute("noticias1", noticias1);  //los elemntos separados se pasan como un atributo
		model.addAttribute("noticias2", noticias2);
		model.addAttribute("noticias3", noticias3);
		model.addAttribute("noticias4", noticias4);
		model.addAttribute("noticias5", noticias5);
		

		return "sistemaDeNoticias"; //Aqui envio los datos a mi pagina creada en html
	}

		
	
	


}
