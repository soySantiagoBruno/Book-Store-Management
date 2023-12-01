package com.ElAntiquario.bookStore.Repository;

import com.ElAntiquario.bookStore.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList, Long> {
}
