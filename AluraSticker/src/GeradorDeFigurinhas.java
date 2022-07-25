import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		
		// leitura imagem
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// criar nova imagem com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original para nova imagem
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);

		
		//escrever uma frase na nova imagem 
		String mensagem = "TOPZERA";
		graphics.drawString(mensagem, largura/15 * (15 - mensagem.length()), novaAltura - 100);
		
		// escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File( nomeArquivo));

	}
}
