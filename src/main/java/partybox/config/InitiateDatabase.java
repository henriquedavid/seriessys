package partybox.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import partybox.Main;
import partybox.model.Category;
import partybox.model.Series;
import reactor.core.publisher.Flux;

public class InitiateDatabase {

	public Flux<Category> init(){
		return Flux.fromIterable(
				Arrays.asList(
						new Category(1, "Filme", 
								new ArrayList<Series>(
										Arrays.asList(
												new Series(1, "Doutor Estranho no Multiverso da Loucura",
														"O Mago Supremo, Stephen Strange (Benedict Cumberbatch) e seu parceiro Wong (Benedict Wong) precisam enfrentar uma poderosa e misteriosa ameaça.", new Date("2022/05/05")),
												new Series(2, "O Homem do Norte",
														"Depois de ver seu pai ser assasinado pelo seu tio, sua mãe sendo sequestrada e o seu reino sendo devastado, Amleth, um jovem príncipe foge e retorna vinte anos depois para cumprir sua vingança.", new Date("2022/05/12")),
												new Series(3, "Thor: Amor e Trovão",
														"Quarta aventura solo de Thor (Chris Hemsworth), personagem da Marvel.", new Date("2022/07/07")),
												new Series(4, "Top Gun: Maverick",
														"Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes no contemporâneo das guerras tecnológicas.", new Date("2022/05/26")),
												new Series(5, "Jurassic World Domínio",
														"Capítulo final da trilogia iniciada por Jurassic World - O Mundo dos Dinossauros.", new Date("2022/06/02"))
												))), 
						new Category(1, "Serie")
						));
	}
}
