import com.example.spring_prepare.entity.Memo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EntityStateTest {
    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("memo");
        em = emf.createEntityManager();
    }

    @Test
    @DisplayName("비영속과 영속 상태")
    void test1() {
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {

            Memo memo = new Memo(); // 비영속 상태
            memo.setId(1L);
            memo.setUsername("Robbie");
            memo.setContents("비영속과 영속 상태");

            em.persist(memo);

            et.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
