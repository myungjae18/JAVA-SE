/*이미지를 불러오는 작업 자체가 중복되면서 복잡해지므로 재사용 가능성을 높이고 코드의 간결함을 위해
 * 클래스로 따로 만들자
 * */
package p0110.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {
	public Image getImage(String filename) {
		BufferedImage img=null;
		URL url=this.getClass().getClassLoader().getResource(filename);
		try {
			img=ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
