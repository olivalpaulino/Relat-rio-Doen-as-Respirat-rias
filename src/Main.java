import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("hoje18.csv");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<Integer> quantidades = new ArrayList<Integer>();
		ArrayList<String> cids = new ArrayList<String>();
		ArrayList<String> nome_cids = new ArrayList<String>();
		char c;
		int i, j, contador, quantidade, index;
		String palavra, cid;
		String linha=br.readLine(); // Descricao
		linha=br.readLine(); // Comeca o conteudo
		
		while (linha != null) {
			palavra="";
			contador = 0;
			quantidade=0;
			for (i=0; i<linha.length(); i++) {
				c = linha.charAt(i);
				
				if (c != ';' && contador==0) {
					palavra+=c;
				} else if (c == ';' && contador==0) {
					palavra=palavra.substring(1,palavra.length()-1);
					
					index = palavra.indexOf('-');
					if (index == -1) {
						i=linha.length();
					} else {
						cids.add(palavra.substring(0, index-1));
						nome_cids.add(palavra.substring(index+2, palavra.length()));
						
//						System.out.println("CID: "+palavra.substring(0, index-1));
//						System.out.println("Nome CID: "+palavra.substring(index+2, palavra.length()));
						
						contador++;
						palavra="";
					}
				} else if (c != ';' && contador==1) {
					palavra+=c;					
				} else if (c == ';' && contador==1) {
					String temp = palavra.substring(1, palavra.length()-1);
					quantidade = Integer.parseInt(temp);
					quantidades.add(quantidade);
					i=linha.length();
				}
			}
		
			linha = br.readLine();
		}
		
		br.close();
		isr.close();
		is.close();
		
		// CIDS DE DOENÇAS RESPIRATORIAS + COVID-19 + DENGUE
		ArrayList<String> cids_doencas_respiratorias = new ArrayList<String>();
		cids_doencas_respiratorias.add("J00");cids_doencas_respiratorias.add("J029");
		cids_doencas_respiratorias.add("J459");cids_doencas_respiratorias.add("J111");
		cids_doencas_respiratorias.add("J189");cids_doencas_respiratorias.add("J020");
		cids_doencas_respiratorias.add("J158");
		cids_doencas_respiratorias.add("J118");cids_doencas_respiratorias.add("J159");
		cids_doencas_respiratorias.add("J441");cids_doencas_respiratorias.add("J450");
		cids_doencas_respiratorias.add("J451");cids_doencas_respiratorias.add("J180");
		cids_doencas_respiratorias.add("A492");cids_doencas_respiratorias.add("J449");
		cids_doencas_respiratorias.add("C119");cids_doencas_respiratorias.add("D106");
		cids_doencas_respiratorias.add("J129");cids_doencas_respiratorias.add("C109");
		cids_doencas_respiratorias.add("J028");
		cids_doencas_respiratorias.add("J101");cids_doencas_respiratorias.add("J209");
		cids_doencas_respiratorias.add("J219");cids_doencas_respiratorias.add("J440");
		cids_doencas_respiratorias.add("J81");cids_doencas_respiratorias.add("J110");
		cids_doencas_respiratorias.add("J100");cids_doencas_respiratorias.add("J154");
		cids_doencas_respiratorias.add("J458");cids_doencas_respiratorias.add("J80");
		cids_doencas_respiratorias.add("B974");
		cids_doencas_respiratorias.add("C349");cids_doencas_respiratorias.add("I278");
		cids_doencas_respiratorias.add("J960");cids_doencas_respiratorias.add("J210");
		cids_doencas_respiratorias.add("J690");cids_doencas_respiratorias.add("J208");
		cids_doencas_respiratorias.add("J399");cids_doencas_respiratorias.add("J206");
		cids_doencas_respiratorias.add("J352");cids_doencas_respiratorias.add("J201");
		cids_doencas_respiratorias.add("J342");cids_doencas_respiratorias.add("J13");
		cids_doencas_respiratorias.add("J329");cids_doencas_respiratorias.add("J128");
		cids_doencas_respiratorias.add("J321");cids_doencas_respiratorias.add("J108");
		cids_doencas_respiratorias.add("J312");cids_doencas_respiratorias.add("J012");
		cids_doencas_respiratorias.add("J350");cids_doencas_respiratorias.add("U049");
		
		// A90 - DENGUE
		
		// COVID-19: U071 e B972
		
		ArrayList<String> covid = new ArrayList<String>();
		ArrayList<Integer> index_covid = new ArrayList<Integer>();
		
		ArrayList<String> doencas_respiratorias = new ArrayList<String>();
		ArrayList<Integer> index_doencas_respiratorias = new ArrayList<Integer>();
		
		ArrayList<String> dengue = new ArrayList<String>();
		ArrayList<Integer> index_dengue = new ArrayList<Integer>();
		
		String nome;
		for (i=0; i<cids.size(); i++) {
			
			for (j=0; j<cids_doencas_respiratorias.size(); j++) {
				// SE DENGUE
				// SE COVID
				if (cids.get(i).equals(cids_doencas_respiratorias.get(j))) {
					nome=nome_cids.get(i);
					nome=nome.replace("Ã§Ã£", "çã");
					nome=nome.replace("Ã­", "í");
					nome=nome.replace("Ã§Ãµ", "çõ");
					nome=nome.replace("Ã£", "ã");
					nome=nome.replace("Ã³", "ó");
					nome=nome.replace("Ã¡", "á");
					nome=nome.replace("Ã´", "ó");
					nome=nome.replace("Ã§", "ç");
					nome=nome.replace("Ã©", "e");
					nome=nome.replace("Ãª", "ê");
					
					System.out.println(cids.get(i)+": "+nome+ " - " + quantidades.get(i));
					j=cids_doencas_respiratorias.size();
				}
			}
		}

		System.out.println("-----------------------------------------------------------");
		// DENGUE
		for (i=0; i<cids.size(); i++) {
			if (cids.get(i).equals("A90")) {
				nome=nome_cids.get(i);
				nome=nome.replace("Ã¡", "á");
				System.out.println(cids.get(i)+": "+nome+ " - " + quantidades.get(i));
			} 
		}
		
		System.out.println("----------------------------------------------------------");
		// COVID-19
		for (i=0; i<cids.size(); i++) {
			if (cids.get(i).equals("U071")) {
				nome=nome_cids.get(i);
				nome=nome.replace("Ã§Ã£", "çã");
				nome=nome.replace("Ã­", "í");
				System.out.println(cids.get(i)+": "+nome+ " - " + quantidades.get(i));
			} 
		}
		// COVID-19
		for (i=0; i<cids.size(); i++) {
			if (cids.get(i).equals("B972")) {
				nome=nome_cids.get(i);
				nome=nome.replace("Ã­", "í");
				nome=nome.replace("Ã§", "ç");
				
				System.out.println(cids.get(i)+": "+nome+ " - " + quantidades.get(i));
			} 
		}
	}
}