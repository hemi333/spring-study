package com.example.spring_prepare.repository;

import com.example.spring_prepare.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
