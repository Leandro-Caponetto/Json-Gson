package com.leandro.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SpringBootApplication
public class JsonGsonApplication {

	public static void main(String[] args)  {

		SpringApplication.run(JsonGsonApplication.class, args);

		// Crear un objeto Libro
		Libro lib = new Libro();
		lib.setTitulo("Una breve historia de Casi todo");
		lib.setAutor("Bill Crimson");
		lib.setNumPaginas(640);

		// Crear el objeto Gson
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lib);
		System.out.println(json);


		//Guardar el json en un archivo
        try (PrintWriter pw = new PrintWriter(new File("libro.json"))){

			pw.println(json);
			pw.flush();

		} catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
