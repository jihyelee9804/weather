package zerobase.wether.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "memo")
public class Memo {
    @Id // 기본키 속성임을 알려준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 속성임을 알려준다.
    // GenerationType.AUTO : 키생성 전략을 자동으로 설정한다.
    // GenerationType.IDENTITY : 기본적인 키생성을 데이터베이스에게 맡긴다. 스프링부트는 키를 생성하지 않는다.
    private int id;
    private String text;
}
