import org.example.model.Address;
import org.example.model.Company;
import org.example.model.Course;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HubernateRunnerTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        prepareTestData();
    }

    @Test
    public void testH2() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1L);
        Company company = session.get(Company.class, 1L);
        Address address = session.get(Address.class, 1L);
        Course course = session.get(Course.class, 1L);
        session.getTransaction().commit();

        assertEquals("Ivan", student.getName());
        assertEquals("Rustaveli 6", address.getDescription());
        assertEquals("Google", company.getName());
        assertEquals("System Design", course.getTitle());
    }

    public static void prepareTestData() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student ivan = Student.builder()
                .name("Ivan")
                .address(new Address("Rustaveli 6"))
                .company(new Company("Google"))
                .courses(List.of(new Course("System Design")))
                .build();
        session.save(ivan);
        session.getTransaction().commit();
    }


}
