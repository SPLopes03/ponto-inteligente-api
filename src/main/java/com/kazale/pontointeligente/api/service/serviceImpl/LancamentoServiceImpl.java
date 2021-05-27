package com.kazale.pontointeligente.api.service.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.repositories.LancamentoRepository;
import com.kazale.pontointeligente.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{
	
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lan�amentos para o funcionário ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Cacheable("lancamentoPorId")
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lan�amento pelo ID {}", id);
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

	@CachePut("lancamentoPorId")
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lan�amento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo o lan�amento ID {}", id);
		this.lancamentoRepository.delete(id);
	}

}
