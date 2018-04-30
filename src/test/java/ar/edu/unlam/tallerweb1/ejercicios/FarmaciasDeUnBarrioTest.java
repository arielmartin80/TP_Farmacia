package ar.edu.unlam.tallerweb1.ejercicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

public class FarmaciasDeUnBarrioTest extends SpringTest{

	@Test @Transactional @Rollback
	@SuppressWarnings ("unchecked")
	public void buscarFarmaciasDeUnBario(){
		
//		instanciamos los objetos
		Barrio barrio1 = new Barrio();
		barrio1.setNombre("Atalaya");
		Barrio barrio2 = new Barrio();
		barrio2.setNombre("San Justo");
		Barrio barrio3 = new Barrio();
		barrio3.setNombre("Casanova");
		
		Comuna comuna1 = new Comuna();
		comuna1.setNombre("La Matanza");
		comuna1.addBarrio(barrio1);
		comuna1.addBarrio(barrio2);
		comuna1.addBarrio(barrio3);
		
		Direccion direccion1 = new Direccion("Cristiania",1834);
		direccion1.setBarrio(barrio1);
		Direccion direccion2 = new Direccion("Florencia Varela",1903);
		direccion2.setBarrio(barrio2);
		Direccion direccion3 = new Direccion("Juan Manuel de Rosas",6800);
		direccion3.setBarrio(barrio3);
		Direccion direccion4 = new Direccion("Arieta",3000);
		direccion4.setBarrio(barrio2);
		
		Farmacia farmacia1 = new Farmacia("Farmacia Atalaya","viernes");
		farmacia1.setDireccion(direccion1);
		Farmacia farmacia2 = new Farmacia("Farmacia San Justo","martes");
		farmacia2.setDireccion(direccion2);
		Farmacia farmacia3 = new Farmacia("Farmacia Casanova","jueves");
		farmacia3.setDireccion(direccion3);
		Farmacia farmacia4 = new Farmacia("Farmacia Arieta","viernes");
		farmacia4.setDireccion(direccion4);
		
//		guardamos
		Session session = getSession();
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(farmacia4);
		
//		verificamos
		List<Farmacia> farmacias=
		session.createCriteria(Farmacia.class)
		.createAlias("direccion", "direccion")
		.createAlias("direccion.barrio", "barrio")
		.add(Restrictions.eq("barrio.nombre","San Justo"))
		.list();
		
//		verificamos que haya 2 elementos en la lista farmacias 
		assertThat(farmacias).hasSize(2);
		
//		verificamos que las farmacias de la lista sean de San Justo
		for (Farmacia lista: farmacias) {
			assertEquals("San Justo",lista.getDireccion().getBarrio().getNombre());
		}
	}
	
	
}
