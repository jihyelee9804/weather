package zerobase.wether.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.wether.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 테스트코드임을 알려준다.
@Transactional // 테스트코드에 있는 @Transactional은 하위 메소드들이 작동했을 때 커밋되지 않고 롤백해서 DB에는 변화가 없다.
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo memo = new Memo(10, "This is JPA Memo");

        // when
        jpaMemoRepository.save(memo);

        // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        Memo newMemo = new Memo(11, "findById Test");

        //when
        /**
         * Memo 클래스의 id가 strategy = GenerationType.IDENTITY 이므로
         * id는 11이 아니라 DB에서 정한 값이다.
         */
        Optional<Memo> memo = jpaMemoRepository.findById(newMemo.getId());

        //then
        assertEquals(memo.get().getText(), "findById Test");
    }
}