package com.github.pomona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.application.AlimentoApplicationService;
import com.github.pomona.application.CardapioApplicationService;
import com.github.pomona.application.ConsultaApplicationService;
import com.github.pomona.application.PacienteApplicationService;
import com.github.pomona.application.SubstanciaApplicationService;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarCategoriaAlimentoCommand;
import com.github.pomona.application.command.alimento.CadastrarPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorMetabolicoCommand;
import com.github.pomona.application.command.cardapio.CadastrarItemNoCardapioCommand;
import com.github.pomona.application.command.consulta.AgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand;
import com.github.pomona.application.command.consulta.DefinirMetaDaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarAntropometriaPesoAlturaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarDiretrizAlimentarNaConsultaCommand;
import com.github.pomona.application.command.diretrizAlimentar.AdicionarNormaADiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.CadastrarDiretrizAlimentarCommand;
import com.github.pomona.application.command.divisaoRefeicao.AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.CadastrarDivisaoRefeicaoCommand;
import com.github.pomona.application.command.paciente.AdicionarPerfilAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.CriarPlanoAlimentarDoPacienteCommand;
import com.github.pomona.application.command.substancia.AtualizarFatorEnergeticoDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaOrdenadaCommand;
import com.github.pomona.domain.model.*;
import com.github.pomona.domain.reference.PreferenciaConsumo;
import com.github.pomona.domain.reference.TipoCorPele;
import com.github.pomona.domain.reference.TipoMeta;
import com.github.pomona.domain.reference.TipoNorma;
import com.github.pomona.domain.reference.TipoRefeicao;
import com.github.pomona.domain.reference.TipoSexo;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.domain.service.AlimentoBuilder;
import com.github.pomona.domain.service.CalculaEnergiaAlimento;
import com.github.pomona.domain.service.CalculaEnergiaBuilder;
import com.github.pomona.domain.service.CalculaIMC;
import com.github.pomona.domain.service.CalculaREE;
import com.github.pomona.domain.service.CalculaTMB;
import com.github.pomona.domain.service.CalculosNutricaoBuilder;
import com.github.pomona.domain.service.CardapioBuilder;
import com.github.pomona.domain.service.ConsultaBuilder;
import com.github.pomona.domain.service.DiretrizAlimentarBuilder;
import com.github.pomona.domain.service.DivisaoRefeicaoBuilder;
import com.github.pomona.domain.service.PlanoAlimentarBuilder;
import com.github.pomona.domain.service.RelatorioPlanoReeducacaoAlimentar;
import com.github.pomona.domain.service.SubstanciaBuilder;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.CardapioCommandHandler;
import com.github.pomona.service.commandHandler.ConsultaCommandHandler;
import com.github.pomona.service.commandHandler.PacienteCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

public class ModelTest {

	public static void main(String[] args) throws ParseException {
		//SubstanciaApplicationService
		SubstanciaRepo substanciaRepoImpl = new SubstanciaRepoImpl();
		EnergiaSubstanciaRepo energiaSubstanciaRepoImpl = new EnergiaSubstanciaRepoImpl();
		DiretrizAlimentarRepo diretrizAlimentarRepoImpl = new DiretrizAlimentarRepoImpl();
		
		//AlimentoApplicationService
		AlimentoRepo alimentoRepoImpl = new AlimentoRepoImpl();
		TipoMedidaRepo tipoMedidaRepoImpl = new TipoMedidaRepoImpl();
		TipoPreparoRepo tipoPreparoRepoImpl = new TipoPreparoRepoImpl();
		PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepoImpl = new PreparoMedidaAlimentoRepoImpl();
		CategoriaAlimentoRepo categoriaAlimentoRepoImpl = new CategoriaAlimentoRepoImpl();
		
		//CardapioApplicationService
		EnergiaAlimentoRepo energiaAlimentoRepoImpl = new EnergiaAlimentoRepoImpl();
		DivisaoRefeicaoRepo divisaoRefeicaoRepoImpl = new DivisaoRefeicaoRepoImpl();
		CardapioRepo cardapioRepoImpl = new CardapioRepoImpl();
		
		//ConsultaApplicationService
		ClassificacaoIMCRepo classificacaoIMCRepoImpl = new ClassificacaoIMCRepoImpl();
		FatorAtividadeFisicaRepo fatorAtividadeFisicaRepoImpl = new FatorAtividadeFisicaRepoImpl();
		FatorMetabolicoRepo fatorMetabolicoRepoImpl = new FatorMetabolicoRepoImpl();
		ConsultaRepo consultaRepoImpl = new ConsultaRepoImpl();
		
		//PacienteApplicationService
		PlanoAlimentarRepo planoAlimentarRepoImpl = new PlanoAlimentarRepoImpl();
		PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepoImpl = new PerfilAlimentarPacienteRepoImpl();
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		
		SubstanciaCommandHandler sch = new SubstanciaApplicationService(diretrizAlimentarRepoImpl, energiaSubstanciaRepoImpl, substanciaRepoImpl);
		String fibraId = sch.handle(new CadastrarSubstanciaComumCommand("Fibra", UnidadeSubstancia.g)).id;
		String ferroId = sch.handle(new CadastrarSubstanciaComumCommand("Ferro", UnidadeSubstancia.mg)).id;
		String vitaminaCId = sch.handle(new CadastrarSubstanciaComumCommand("Vitamina C", UnidadeSubstancia.mg)).id;
		String sodioId = sch.handle(new CadastrarSubstanciaComumCommand("Sódio", UnidadeSubstancia.mg)).id;
		String potassioId = sch.handle(new CadastrarSubstanciaComumCommand("Potássio", UnidadeSubstancia.mg)).id;
		String fosforoId = sch.handle(new CadastrarSubstanciaComumCommand("Fosforo", UnidadeSubstancia.mg)).id;
		String zincoId = sch.handle(new CadastrarSubstanciaComumCommand("Zinco", UnidadeSubstancia.mg)).id;
		String calcioId = sch.handle(new CadastrarSubstanciaComumCommand("Cálcio", UnidadeSubstancia.mg)).id;
		String magnesioId = sch.handle(new CadastrarSubstanciaComumCommand("Magnésio", UnidadeSubstancia.mg)).id;
		String carboidratoId = sch.handle(new CadastrarSubstanciaOrdenadaCommand("Carboidrato", UnidadeSubstancia.g, 0)).id;
		String proteinaId = sch.handle(new CadastrarSubstanciaOrdenadaCommand("Proteína", UnidadeSubstancia.g, 1)).id;
		String lipidioId = sch.handle(new CadastrarSubstanciaOrdenadaCommand("Lipídio", UnidadeSubstancia.g, 2)).id;

		sch.handle(new AtualizarFatorEnergeticoDaSubstanciaCommand(carboidratoId, 4f));
		sch.handle(new AtualizarFatorEnergeticoDaSubstanciaCommand(proteinaId, 4f));
		sch.handle(new AtualizarFatorEnergeticoDaSubstanciaCommand(lipidioId, 9f));
		
		String dirDiabeticoId = sch.handle(new CadastrarDiretrizAlimentarCommand("Diretriz Diabético")).id;
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirDiabeticoId, carboidratoId, TipoNorma.PERCENTUAL, 45f, 65f));
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirDiabeticoId, proteinaId, TipoNorma.PERCENTUAL, 10f, 35f));
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirDiabeticoId, lipidioId, TipoNorma.PERCENTUAL, 20f, 35f));

		String dirPadraoId = sch.handle(new CadastrarDiretrizAlimentarCommand("Diretriz Padrão")).id;
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirPadraoId, carboidratoId, TipoNorma.PERCENTUAL, 55f, 75f));
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirPadraoId, proteinaId, TipoNorma.PERCENTUAL, 10f, 15f));
		sch.handle(new AdicionarNormaADiretrizAlimentarCommand(dirPadraoId, lipidioId, TipoNorma.PERCENTUAL, 10f, 30f));
		
		
		AlimentoCommandHandler ach = new AlimentoApplicationService(alimentoRepoImpl, substanciaRepoImpl, tipoMedidaRepoImpl, tipoPreparoRepoImpl, preparoMedidaAlimentoRepoImpl, categoriaAlimentoRepoImpl);
		String catFrutaId = ach.handle(new CadastrarCategoriaAlimentoCommand("Fruta")).id;
		
		String abacateId = ach.handle(new CadastrarAlimentoGranelCommand("Abacate", UnidadeGranel.g, 100f, catFrutaId)).id;
		String sucoLaranjaId = ach.handle(new CadastrarAlimentoGranelCommand("Suco de Laranja Pera", UnidadeGranel.ml, 100f, catFrutaId)).id;
		
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, carboidratoId, 5.2f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, proteinaId, 1.9f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, lipidioId, 18.7f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, fibraId, 1.4f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, ferroId, 0.9f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, vitaminaCId, 11f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, sodioId, 46f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, potassioId, 340f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, fosforoId, 46f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, zincoId, 1.9f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, calcioId, 25f));
		ach.handle(new AdicionarComponenteAlimentarCommand(abacateId, magnesioId, 18f));
		
		String picadoId = ach.handle(new CadastrarTipoPreparoDoAlimentoGranelCommand("Picado")).id;
		String fatiadoId = ach.handle(new CadastrarTipoPreparoDoAlimentoGranelCommand("Fatiado")).id;
		
		String colherSopaId = ach.handle(new CadastrarTipoMedidaDoAlimentoGranelCommand("Colher de Sopa")).id;

		ach.handle(new CadastrarPreparoMedidaDoAlimentoGranelCommand(abacateId, picadoId, colherSopaId, 10f));
		
		
		PacienteCommandHandler pch = new PacienteApplicationService(alimentoRepoImpl, categoriaAlimentoRepoImpl, perfilAlimentarPacienteRepoImpl, planoAlimentarRepoImpl);
		String planoPedroId = pch.handle(new CriarPlanoAlimentarDoPacienteCommand("Pedro", (Date)format.parse("29/06/1978"), TipoSexo.MASCULINO, TipoCorPele.BRANCA)).id;
		pch.handle(new AdicionarPerfilAlimentarAoPacienteCommand(planoPedroId, abacateId, PreferenciaConsumo.REJEITA));

		
		ConsultaCommandHandler cch = new ConsultaApplicationService(planoAlimentarRepoImpl,  cardapioRepoImpl, classificacaoIMCRepoImpl, consultaRepoImpl, diretrizAlimentarRepoImpl, fatorAtividadeFisicaRepoImpl, fatorMetabolicoRepoImpl, divisaoRefeicaoRepoImpl);
		String fatSedentarioId = cch.handle(new CadastrarFatorAtividadeFisicaCommand("Sedentário", 1f)).id;
		cch.handle(new CadastrarFatorAtividadeFisicaCommand("Atividade Leve", 1.12f));
		cch.handle(new CadastrarFatorAtividadeFisicaCommand("Atividade Moderada", 1.27f));
		cch.handle(new CadastrarFatorAtividadeFisicaCommand("Atividade Intensa", 1.45f));
		CalculaREE.setFatoresAtividadeFisica(new ArrayList<FatorAtividadeFisica>());
		CalculaREE.getFatoresAtividadeFisica().addAll(fatorAtividadeFisicaRepoImpl.todosObjetos());
		
		cch.handle(new CadastrarClassificacaoIMCCommand("Muito Abaixo do Peso", null, 17f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Abaixo do Peso", 17f, 18.5f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Peso Normal", 18.5f, 25f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Acima do Peso", 25f, 30f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Obesidade I", 30f, 35f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Obesidade II (severa)", 35f, 40f));
		cch.handle(new CadastrarClassificacaoIMCCommand("Obesidade III (mórbida)", 40f, null));
		CalculaIMC.setClassificacoesIMC(new ArrayList<ClassificacaoIMC>());
		CalculaIMC.getClassificacoesIMC().addAll(classificacaoIMCRepoImpl.todosObjetos());
		
		cch.handle(new CadastrarFatorMetabolicoCommand(null, 3, 61f, -51, 60.3f, -54));
		cch.handle(new CadastrarFatorMetabolicoCommand(3, 10, 22.5f, 499, 22.7f, 495));
		cch.handle(new CadastrarFatorMetabolicoCommand(10, 18, 12.2f, 746, 17.5f, 651));
		cch.handle(new CadastrarFatorMetabolicoCommand(18, 30, 14.7f, 496, 15.3f, 679));
		cch.handle(new CadastrarFatorMetabolicoCommand(30, 60, 8.7f, 829, 11.6f, 879));
		cch.handle(new CadastrarFatorMetabolicoCommand(60, null, 10.5f, 596, 13.5f, 487));
		CalculaTMB.setFatoresMetabolicos(new ArrayList<FatorMetabolico>());
		CalculaTMB.getFatoresMetabolicos().addAll(fatorMetabolicoRepoImpl.todosObjetos());
		
		String divRefeicao4Id = cch.handle(new CadastrarDivisaoRefeicaoCommand("4 Refeições")).id;
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao4Id, TipoRefeicao.DESEJUM, 20f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao4Id, TipoRefeicao.ALMOCO, 40f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao4Id, TipoRefeicao.LANCHE, 10f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao4Id, TipoRefeicao.JANTAR, 30f, 40f));
		
		String divRefeicao6Id = cch.handle(new CadastrarDivisaoRefeicaoCommand("6 Refeições")).id;
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.DESEJUM, 15f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.COLACAO, 5f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.ALMOCO, 30f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.LANCHE, 15f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.JANTAR, 30f, 40f));
		cch.handle(new AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(divRefeicao6Id, TipoRefeicao.CEIA, 5f, 40f));
		
		String consultaId = cch.handle(new AgendarConsultaDoPacienteCommand(planoPedroId, new Date())).id;
		cch.handle(new AtualizarAntropometriaPesoAlturaNaConsultaCommand(consultaId, 90f, 1.71f));
		cch.handle(new AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand(consultaId, fatSedentarioId));
		cch.handle(new AtualizarDiretrizAlimentarNaConsultaCommand(consultaId, dirDiabeticoId));
		cch.handle(new DefinirMetaDaConsultaCommand(planoPedroId, consultaId, TipoMeta.IMC, 29f, new Date(), new Date(), divRefeicao4Id));
		
		String cardapioId = consultaRepoImpl.objetoDeId(new ConsultaId(consultaId)).getCardapios().get(0).cardapioId().id(); 

		CalculaEnergiaAlimento cea = new CalculaEnergiaAlimento();
		cea.setEnergiaSubstancia(new ArrayList<EnergiaSubstancia>());
		cea.getEnergiaSubstancia().addAll(energiaSubstanciaRepoImpl.todosObjetos());
		
		CardapioCommandHandler crch = new CardapioApplicationService(alimentoRepoImpl, cardapioRepoImpl, consultaRepoImpl, energiaAlimentoRepoImpl, energiaSubstanciaRepoImpl, perfilAlimentarPacienteRepoImpl, divisaoRefeicaoRepoImpl, tipoPreparoRepoImpl, cea);
		crch.handle(new CadastrarItemNoCardapioCommand(cardapioId, abacateId, picadoId, TipoRefeicao.ALMOCO, 200f));
		
		
/*		new CalculosNutricaoBuilder()
				.adicionarFatorAtividadeFisica("Sedentário", 1f)
				.adicionarFatorAtividadeFisica("Atividade Leve", 1.12f)
				.adicionarFatorAtividadeFisica("Atividade Moderada", 1.27f)
				.adicionarFatorAtividadeFisica("Atividade Intensa", 1.45f)
				
				.adicionarClassificacaoIMC("Muito Abaixo do Peso", null, 17f)
				.adicionarClassificacaoIMC("Abaixo do Peso", 17f, 18.49f)
				.adicionarClassificacaoIMC("Peso Normal", 18.5f, 25f)
				.adicionarClassificacaoIMC("Acima do Peso", 25f, 30f)
				.adicionarClassificacaoIMC("Obesidade I", 30f, 35f)
				.adicionarClassificacaoIMC("Obesidade II (severa)", 35f, 40f)
				.adicionarClassificacaoIMC("Obesidade III (mórbida)", 40f, null)
				
				.adicionarFatorMetabolico(null, 3, 60.3f, -54, 61f, -51)
				.adicionarFatorMetabolico(3, 10, 22.7f, 495, 22.5f, 499)
				.adicionarFatorMetabolico(10, 18, 17.5f, 651, 12.2f, 746)
				.adicionarFatorMetabolico(18, 30, 15.3f, 679, 14.7f, 496)
				.adicionarFatorMetabolico(30, 60, 11.6f, 879, 8.7f, 829)
				.adicionarFatorMetabolico(60, null, 13.5f, 487, 10.5f, 596)
				.construir();
*/
		

		Substancia carboidrato = new SubstanciaBuilder("Carboidrato", UnidadeSubstancia.g, 1).construir();
		Substancia proteina = new SubstanciaBuilder("Proteína", UnidadeSubstancia.g, 2).construir();
		Substancia lipidio = new SubstanciaBuilder("Lipídio", UnidadeSubstancia.g, 3).construir();
		Substancia fibra = new SubstanciaBuilder("Fibra", UnidadeSubstancia.g, 4).construir();
		Substancia ferro = new SubstanciaBuilder("Ferro", UnidadeSubstancia.mg, 5).construir();
		Substancia vitaminaC = new SubstanciaBuilder("Vitamina C", UnidadeSubstancia.mg, 6).construir();
		Substancia sodio = new SubstanciaBuilder("Sódio", UnidadeSubstancia.mg, 7).construir();
		Substancia potassio = new SubstanciaBuilder("Potássio", UnidadeSubstancia.mg, 8).construir();
		Substancia fosforo = new SubstanciaBuilder("Fosforo", UnidadeSubstancia.mg, 9).construir();
		Substancia zinco = new SubstanciaBuilder("Zinco", UnidadeSubstancia.mg, 10).construir();
		Substancia calcio = new SubstanciaBuilder("Cálcio", UnidadeSubstancia.mg, 11).construir();
		Substancia magnesio = new SubstanciaBuilder("Magnésio", UnidadeSubstancia.mg, 12).construir();

		
		AlimentoUnitario abacate = new AlimentoBuilder()
				.adicionarComponenteAlimentar(proteina, 1.9f)
				.adicionarComponenteAlimentar(lipidio, 18.7f)
				.adicionarComponenteAlimentar(carboidrato, 5.2f)
				.adicionarComponenteAlimentar(fibra, 1.4f)
				.adicionarComponenteAlimentar(ferro, 0.9f)
				.adicionarComponenteAlimentar(vitaminaC, 11f)
				.adicionarComponenteAlimentar(sodio, 46f)
				.adicionarComponenteAlimentar(potassio, 340f)
				.adicionarComponenteAlimentar(fosforo, 46f)
				.adicionarComponenteAlimentar(zinco, 1.9f)
				.adicionarComponenteAlimentar(calcio, 25f)
				.adicionarComponenteAlimentar(magnesio, 18f)
				.construir("Abacate");
		
		
		CalculaEnergiaAlimento calcEne = new CalculaEnergiaBuilder()
				.adicionarEnergiaSubstancia(proteina, 4f)
				.adicionarEnergiaSubstancia(lipidio, 9f)
				.adicionarEnergiaSubstancia(carboidrato, 4f)
				.adicionarEnergiaAlimento(abacate, 1.9f * 4 + 18.7f * 9 + 5.2f * 4)
				.construir();
		
		
		DiretrizAlimentar dirDiabetico = new DiretrizAlimentarBuilder("Diretriz Diabético")
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 25f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 20f, 35f)
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 45f, 65f)
				.construir();

		DiretrizAlimentar dirPadrao = new DiretrizAlimentarBuilder("Diretriz Padrão")
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 15f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 10f, 30f)
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 55f, 75f)
				.construir();

		
		DivisaoRefeicao div4Refeicoes = new DivisaoRefeicaoBuilder("4 Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.DESEJUM, 20f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 40f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.LANCHE, 10f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 30f, 40f)
				.construir();
		
		DivisaoRefeicao div6Refeicoes = new DivisaoRefeicaoBuilder("6 Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.DESEJUM, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.COLACAO, 5f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.LANCHE, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.CEIA, 5f, 40f)
				.construir();
		
		PlanoAlimentar planoPedro = new PlanoAlimentarBuilder(
				"Pedro", (Date)format.parse("29/06/1978"), TipoSexo.MASCULINO)
				.comPerfilAlimentar(abacate, PreferenciaConsumo.REJEITA)
				.construir();
		
		Consulta consPedro = new ConsultaBuilder(new Date(), 90f, 1.71f, dirDiabetico,
				CalculaREE.getFatoresAtividadeFisica().get(0), planoPedro)
				.definirMeta(TipoMeta.IMC, 29f)
				.construir();
		
		planoPedro.setConsultas(new ArrayList<Consulta>());
		planoPedro.getConsultas().add(consPedro);
		
		Cardapio cardPedro1 = new CardapioBuilder(new Date(), div4Refeicoes, calcEne)
				.adicionarAlimento(abacate, 2f, TipoRefeicao.DESEJUM)
				.construir();
		
		Cardapio cardPedro2 = new CardapioBuilder(new Date(), div6Refeicoes, calcEne)
				.adicionarAlimento(abacate, 2f, TipoRefeicao.ALMOCO)
				.construir();
		
		consPedro.setCardapios(new ArrayList<Cardapio>());
		consPedro.getCardapios().add(cardPedro1);
		consPedro.getCardapios().add(cardPedro2);
		
		System.out.println(new RelatorioPlanoReeducacaoAlimentar(planoPedro).toString());
		
		for(Object o : substanciaRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}
		
		for(Object o : energiaSubstanciaRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		
		}
		
		for(Object o : categoriaAlimentoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}
		
		for(Object o : alimentoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}
		
		for(Object o : diretrizAlimentarRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : tipoMedidaRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : tipoPreparoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : preparoMedidaAlimentoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : fatorAtividadeFisicaRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : classificacaoIMCRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : fatorMetabolicoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}

		for(Object o : divisaoRefeicaoRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}
		
		for(Object o : planoAlimentarRepoImpl.todosObjetos()){
			System.out.println(o.toString());
		}
		
		System.out.println(new RelatorioPlanoReeducacaoAlimentar(planoAlimentarRepoImpl.objetoDeId(new PlanoAlimentarId(planoPedroId))).toString());
		
	}
}
