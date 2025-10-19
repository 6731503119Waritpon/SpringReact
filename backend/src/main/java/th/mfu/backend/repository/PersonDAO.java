package th.mfu.backend.repository;

import java.util.List;

import th.mfu.backend.entity.Person;

public interface PersonDAO {
    void save(Person person);
    void delete(Integer id);
    Person get(Integer id);
    List<Person> getAll();
    void update(Person person);
}
