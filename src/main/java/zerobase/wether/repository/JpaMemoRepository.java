package zerobase.wether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.wether.domain.Memo;

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> { // 데이터가 변환될 자바 객체 타입

}
