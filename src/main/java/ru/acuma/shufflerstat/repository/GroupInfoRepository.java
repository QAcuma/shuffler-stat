package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.acuma.shufflerstat.model.entity.GroupInfo;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {
    List<GroupInfo> findAllByIsActiveTrue();
}
