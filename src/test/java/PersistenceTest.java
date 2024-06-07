import com.example.spring_prepare.entity.Memo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersistenceTest {
    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("memo");
        em = emf.createEntityManager();
    }

    @Test
    @DisplayName("1차 캐시 : Entity 저장")
    void test1() {
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {

            Memo memo = new Memo();
            memo.setId(1L);
            memo.setUsername("Robbie");
            memo.setContents("1차 캐시 Entity 저장");

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

    @Test
    @DisplayName("Entity 조회 : 캐시 저장소에 해당하는 Id가 존재하지 않은 경우")
    void test2() {
        try {

            Memo memo = em.find(Memo.class, 1);
            System.out.println("memo.getId() = " + memo.getId());
            System.out.println("memo.getUsername() = " + memo.getUsername());
            System.out.println("memo.getContents() = " + memo.getContents());


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    @Test
    @DisplayName("Entity 조회 : 캐시 저장소에 해당하는 Id가 존재하는 경우")
    void test3() {
        try {

            Memo memo1 = em.find(Memo.class, 1);
            System.out.println("memo1 조회 후 캐시 저장소에 저장\n");

            Memo memo2 = em.find(Memo.class, 1);
            System.out.println("memo2.getId() = " + memo2.getId());
            System.out.println("memo2.getUsername() = " + memo2.getUsername());
            System.out.println("memo2.getContents() = " + memo2.getContents());


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    @Test
    @DisplayName("객체 동일성 보장")
    void test4() {
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {
            Memo memo3 = new Memo();
            memo3.setId(2L);
            memo3.setUsername("Robbert");
            memo3.setContents("객체 동일성 보장");
            em.persist(memo3);

            Memo memo1 = em.find(Memo.class, 1);
            Memo memo2 = em.find(Memo.class, 1);
            Memo memo  = em.find(Memo.class, 2);

            System.out.println(memo1 == memo2);
            System.out.println(memo1 == memo);

            et.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    @Test
    @DisplayName("Entity 삭제")
    void test5() {
        EntityTransaction et = em.getTransaction();

        et.begin();

        try {

            Memo memo = em.find(Memo.class, 2);

            em.remove(memo);

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
