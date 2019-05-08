/*�̹����� �ҷ����� �۾� ��ü�� �ߺ��Ǹ鼭 ���������Ƿ� ���� ���ɼ��� ���̰� �ڵ��� �������� ����
 * Ŭ������ ���� ������
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
