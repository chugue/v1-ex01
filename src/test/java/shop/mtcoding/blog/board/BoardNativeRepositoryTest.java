package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardNativeRepository.class)
@DataJpaTest
public class BoardNativeRepositoryTest {
    @Autowired
    private EntityManager em;


    @Test
    public void findById_test(){
        // given
        int boardId = 4;
        // when
        String q = """
                select * from board_tb b where b.id = ? 
                """;
        Query query = em.createNativeQuery(q, Board.class);
        query.setParameter(1, boardId);
        // then

    }

    @Test
    public void findAll_test(){
        // given

        // when
        String q = """
                select * from board_tb b order by b.id desc
                """;
        Query query = em.createNativeQuery(q);
        // then

    }

    @Test
    public void save_test(){
        // given
        String title = "테스트1";
        String content = "테스트2";
        String username = "테스트3";
        // when
        String q = """
                insert into board_tb (title, content, username, created_at) values (?,?,?, NOW())
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1,title);
        query.setParameter(2,content);
        query.setParameter(3,username);
        query.executeUpdate();
        // then

    }
}
