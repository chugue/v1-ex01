package shop.mtcoding.blog.board;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import shop.mtcoding.blog.util.MyDateUtil;

import java.sql.Timestamp;

@Data
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String username;
    private Timestamp createdAt;

    public String getTime(){
        return MyDateUtil.timestampFormat(createdAt);
    }
}
