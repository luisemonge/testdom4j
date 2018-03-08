import java.io.File;

import org.dom.parser.Parser;
import org.dom4j.DocumentException;

public class testDom4j {
	
	

	public static void main(String[] args) {
		Parser parser = new Parser();
		
		try {
			parser.parserXML();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
