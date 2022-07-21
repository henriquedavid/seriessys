package br.ufrn.programacaoreativa.entretainflix;

import java.util.function.Function;

public class Exchange implements Function<String, String>{
	
	@Override
	public String apply(String t) {
		if(t.equals("0".repeat(11)) || t.equals("1".repeat(11)) || t.equals("2".repeat(11)) ||
				t.equals("3".repeat(11)) || t.equals("4".repeat(11)) || t.equals("5".repeat(11)) ||
				t.equals("6".repeat(11)) || t.equals("7".repeat(11)) || t.equals("8".repeat(11)) ||
				t.equals("9".repeat(11)) || t.length() != 11) {
			return "CPF inválido";
		} else {
			
			char d10, d11;
			int sm, i, r, num, peso;
			
			try {
				sm = 0;
				peso = 10;
				for(i = 0; i < 9; i++) {
					num = (int)(t.charAt(i)-48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}
				
				r = 11 - (sm % 11);
				if((r == 10) || (r == 11)) {
					d10 = '0';
				} else {
					d10 = (char)(r + 48);
				}
				
				sm = 0;
				peso = 11;
				for(i = 0; i < 10; i++) {
					num = (int) (t.charAt(i) - 48);
					sm = sm + (num*peso);
					peso = peso - 1;
				}
				
				r = 11 - (sm % 11);
				if((r == 10) || (r == 11))
					d11 = '0';
				else d11 = (char)(r+48);
				
				if((d10 == t.charAt(9)) && (d11 == t.charAt(10)))
					return "CPF válido";
				else return "CPF inválido";
			} catch (Exception e) {
				return "Não foi possível validar, analise a entrada!";
			}
		}
	}

}
