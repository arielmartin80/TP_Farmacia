package ar.edu.unlam.tallerweb1.ejercicios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

public class FarmaciasDeUnaCalleTest extends SpringTest{

	@Test @Transactional @Rollback 
	@SuppressWarnings ("unchecked")
	public void buscarTodasLasFarmaciasDeUnaCalle(){
		
// 		creamos la session
		Session session = getSession();
		
// 		instanciamos las clases
		Direccion direccion1=new Direccion("Cristiania",2464);
		Direccion direccion2=new Direccion("Marconi",2464);
		Direccion direccion3=new Direccion("Cristiania",3215);
		
		Farmacia farmacia1=new Farmacia(direccion1);
		Farmacia farmacia2=new Farmacia(direccion2);
		Farmacia farmacia3=new Farmacia(direccion3);
		
//		salvamos en bd
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		
//		buscamos todas las farmacias de la calle Cristiania
		List<Farmacia> resultado=
		session.createCriteria(Farmacia.class)
		.createAlias("direccion", "direccion")
		.add(Restrictions.eq("direccion.calle", "Cristiania"))
		.list();
		
//		verificamos que la variable resultado contenga 2 elementos
		assertThat(resultado).hasSize(2);
		
	}
	
	
}
