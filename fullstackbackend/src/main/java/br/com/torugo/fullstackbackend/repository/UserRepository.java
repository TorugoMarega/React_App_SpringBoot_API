package br.com.torugo.fullstackbackend.repository;

import br.com.torugo.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{}
