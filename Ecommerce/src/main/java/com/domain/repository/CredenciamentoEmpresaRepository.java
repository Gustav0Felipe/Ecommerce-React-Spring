package com.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.Credenciamento;

public interface CredenciamentoEmpresaRepository extends JpaRepository<Credenciamento, Integer>{

	Optional<Credenciamento> findById(Integer id);
}
