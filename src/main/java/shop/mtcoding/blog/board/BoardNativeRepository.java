package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardNativeRepository {
    private final EntityManager em;

    @Transactional
    public void updateById(Integer boardId, String username, String title, String content){
        String q = """
                UPDATE board_tb SET title =? , content = ? , username = ?  where id = ? 
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1,title);
        query.setParameter(2,content);
        query.setParameter(3,username);
        query.setParameter(4,boardId);
        query.executeUpdate();
    }


    @Transactional
    public void save (String title, String content, String username){
        String q = """
                insert into board_tb (title, content, username, created_at) values (?,?,?, NOW())
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1,title);
        query.setParameter(2,content);
        query.setParameter(3,username);
        query.executeUpdate();
    }

    public List<Board> findAll() {
        String q = """
                select * from board_tb b order by b.id desc
                """;
        Query query = em.createNativeQuery(q, Board.class);
        return query.getResultList();
    }

    public Board findById (Integer boardId){
        String q = """
                select * from board_tb b where b.id = ? 
                """;
        Query query = em.createNativeQuery(q, Board.class);
        query.setParameter(1, boardId);
        return (Board) query.getSingleResult();
    }

    @Transactional
    public void deleteById (Integer boardId){
        String q = """
                delete from board_tb b where b.id = ? 
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1,boardId);
        query.executeUpdate();
    }

}
