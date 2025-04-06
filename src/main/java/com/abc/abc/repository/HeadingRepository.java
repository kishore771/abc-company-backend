package com.abc.abc.repository;

import com.abc.abc.model.Heading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This annotation indicates that this interface is a Spring Data repository, which will be used to perform CRUD operations on the Heading entity.
public interface HeadingRepository extends JpaRepository<Heading, Integer> {

}
