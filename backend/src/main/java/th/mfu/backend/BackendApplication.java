package th.mfu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import th.mfu.backend.entity.Person;
import th.mfu.backend.repository.PersonDAO;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return runner -> {
			updateData(dao);
		};
	}

	public void saveData(PersonDAO dao) {
		Person obj1 = new Person("Yew", "Warit");
		dao.save(obj1);
		System.out.println("Insert Complete");
	}

	public void deleteData(PersonDAO dao) {
		int id=2;
		dao.delete(id);
		System.out.println("Delete Complete");
	}

	public void getData(PersonDAO dao) {
		int id=1;
		Person person = dao.get(id);
		System.out.println("Get Complete: " + person);
	}

	public void getAllData(PersonDAO dao){
		List<Person> data = dao.getAll();
		for(Person person : data){
			System.out.println(person);
		}
	}

	public void updateData(PersonDAO dao) {
		int id = 1;
		Person myPerson = dao.get(id);
		myPerson.setFname("ยิว");
		myPerson.setLname("วริทธิ์พล");
		dao.update(myPerson);
		System.out.println("Update Complete");
	}

}
