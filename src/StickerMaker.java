import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerMaker {
    
    public void create(InputStream image, String nameSticker) throws Exception {
        // Leitura da imagem;
        BufferedImage originalImage = ImageIO.read(image);

        // Criar imagem em memória com transparência e tamanho novo;
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        int newHeight = originalHeight + 200;
        BufferedImage newImage = new BufferedImage(originalWidth,newHeight,BufferedImage.TRANSLUCENT);
        
        // Copiar imagem original pra nova imagem em memória;
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        
        //configurar fonte:
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
        graphics.setColor(Color.YELLOW);
        
        // Escrever uma frase em uma imagem;
        graphics.drawString(nameSticker.substring(5), 100, newHeight - 100);
        
        // Escrever a nova imagem em arquivo;
        ImageIO.write(newImage,"png",new File("./assets/"+ nameSticker +".png"));
    }
}
