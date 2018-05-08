package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCalculadora {

//mensaje de ayuda
	@RequestMapping({"/sumar","/restar","/multiplicar","/dividir"})
	public ModelAndView sumar(){
		ModelMap modelo = new ModelMap();
		String mensaje="Debe introducir los operandos en la ruta del navegador"
				+ "<br>Elemplo para sumar: /sumar/3/mas/4"
				+ "<br>Elemplo para restar: /restar/3/menos/4"
				+ "<br>Elemplo para multiplicar: /multiplicar/3/por/4"
				+ "<br>Elemplo para dividir: /dividir/3/por/4";
		modelo.put("mensaje",mensaje);
		
		return new ModelAndView("calculadora",modelo);
	}
//operacion de suma
	@RequestMapping("/sumar/{primero}/mas/{segundo}")
	public ModelAndView sumar(@PathVariable Double primero,@PathVariable Double segundo){
		ModelMap modelo = new ModelMap();
		Double resultado=primero+segundo;
		modelo.put("primero",primero);
		modelo.put("segundo", segundo);
		modelo.put("resultado", resultado);
		modelo.put("operacion", "suma");
		
		return new ModelAndView("calculadora",modelo);
	}

//operacion de resta
	@RequestMapping("/restar/{primero}/menos/{segundo}")
	public ModelAndView restar(@PathVariable Double primero,@PathVariable Double segundo){
		ModelMap modelo = new ModelMap();
		Double resultado=primero-segundo;
		modelo.put("primero",primero);
		modelo.put("segundo", segundo);
		modelo.put("resultado", resultado);
		modelo.put("operacion", "resta");
		
		return new ModelAndView("calculadora",modelo);
	}

//operacion de resta
		@RequestMapping("/multiplicar/{primero}/por/{segundo}")
		public ModelAndView multiplicar(@PathVariable Double primero,@PathVariable Double segundo){
			ModelMap modelo = new ModelMap();
			Double resultado=primero*segundo;
			modelo.put("primero",primero);
			modelo.put("segundo", segundo);
			modelo.put("resultado", resultado);
			modelo.put("operacion", "multiplicacion");
			
			return new ModelAndView("calculadora",modelo);
		}
		
//operacion de resta
		@RequestMapping("/dividir/{primero}/dividido/{segundo}")
		public ModelAndView dividir(@PathVariable Double primero,@PathVariable Double segundo){
			ModelMap modelo = new ModelMap();
			Double resultado=primero/segundo;
			modelo.put("primero",primero);
			modelo.put("segundo", segundo);
			modelo.put("resultado", resultado);
			modelo.put("operacion", "division");
			
			return new ModelAndView("calculadora",modelo);
		}
	
	
}
