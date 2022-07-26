import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class Program {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		// conex�o HTTP e buscar os top 250 filmes
		
		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD-JamesWebbSpaceTelescope.json";
		//ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();
		
		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
		
		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradorDeFigurinhas();
		
		for (int i = 0; i < 3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
			
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
			
			geradora.cria(inputStream, nomeArquivo);
			
			System.out.println(conteudo.getTitulo());
			System.out.println(conteudo.getUrlImagem());
			System.out.println();
		}
	}
}
