package com.example.springsecuritypractice.notice.repository;

import com.example.springsecuritypractice.notice.dto.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}