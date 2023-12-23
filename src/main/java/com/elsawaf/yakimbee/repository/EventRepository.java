package com.elsawaf.yakimbee.repository;


import com.elsawaf.yakimbee.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}