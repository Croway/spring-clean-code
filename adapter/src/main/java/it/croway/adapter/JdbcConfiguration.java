package it.croway.adapter;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;

import it.croway.project.User;

@Configuration
public class JdbcConfiguration {

	private final RelationalMappingContext context;

	public JdbcConfiguration(RelationalMappingContext context) {
		this.context = context;
	}

	@PostConstruct
	void init() {
		RelationalPersistentEntity<?> rpe = context.getPersistentEntity(User.class);
		
//		context.getNamingStrategy();
//		
//		RelationalPersistentProperty rpp = rpe.getPersistentProperty("username");
//		
//		try {
//			Class<?> clazz = Class.forName("org.springframework.data.relational.core.mapping.BasicRelationalPersistentProperty");
//			
//			Field aField= clazz.getDeclaredField("keyColumnName");
//			aField.setAccessible(true);
//			aField.set(rpp, new Lazy<Optional<String>>(() -> Optional.of("username")));
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}

		System.out.println(rpe);
	}

}
