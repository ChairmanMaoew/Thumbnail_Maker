import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
 


import javax.imageio.ImageIO;
 


import org.ghost4j.analyzer.AnalysisItem;
import org.ghost4j.analyzer.FontAnalyzer;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

public class ThumbGen {
	
	public ThumbGen(String file, String fileName) {
		
		try {
		
			PDFDocument document = new PDFDocument();
			document.load(new File(file));
			
			SimpleRenderer renderer = new SimpleRenderer();
			
			renderer.setResolution(25);
			//renderer.setAntialiasing(300);
			
			List<Image> images = renderer.render(document);
			//Image PDFImage = images.get(0);
			//Image thumbPDF = PDFImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			
			try {
                ImageIO.write((RenderedImage) images.get(0), "png", new File(fileName + 1 + ".png"));
               
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
		
		} catch (Exception e) {
		        System.out.println("ERROR: " + e.getMessage());
		}
	
	}

}
