package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.IIOException;

import com.sun.xml.internal.ws.streaming.SourceReaderFactory;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.Resizers;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;

public class ThumbTest {
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\","origin.jpg");
		Thumbnails
		.of(file)
		.sourceRegion(Positions.CENTER, 200,200)
		.size(200,200)
		.toFile(new File("C:\\thumb","thumb.jpg"));
//		String contentType = Files.probeContentType(file.toPath());
//		System.out.println(contentType);
//		System.out.println(contentType.startsWith("image"));
	}
	
}
