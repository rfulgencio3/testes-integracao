package br.com.alura.leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.leilao.integracao.dao.LanceDao;
import br.com.alura.leilao.integracao.dao.LeilaoDao;
import br.com.alura.leilao.integracao.dao.UsuarioDao;
import br.com.alura.leilao.dto.NovoLanceDto;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

@Service
public class LanceService {

	@Autowired
	private LanceDao lances;

	@Autowired
	private UsuarioDao usuarios;

	@Autowired
	private LeilaoDao leiloes;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuarios.buscarPorUsername(nomeUsuario);
		Leilao leilao = this.getLeilao(lanceDto.getLeilaoId());

		Lance lance = lanceDto.toLance(usuario, leilao);

		if (leilao.propoe(lance)) {
			lances.salvar(lance);
			return true;
		}

		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloes.buscarPorId(leilaoId);
	}

}