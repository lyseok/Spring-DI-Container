package kr.or.ddit.case07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import kr.or.ddit.case07.conf.Case07ResourceLodingConfig;
import kr.or.ddit.case07.objs.ResourcesVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
public class Case07playground {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case07ResourceLodingConfig.class);
		ResourcesVO resVO = context.getBean(ResourcesVO.class);
		
//		Resource fR = context.getResource("file:/Users/eehdbs/Desktop/스크린샷 2025-05-25 21.29.21.png");
		Resource fR = resVO.getFR();
		printResourceInfo(fR);
		
//		Resource cR = context.getResource("classpath:kr/or/ddit/case05/conf/Case05-Context.xml");
		Resource cR = resVO.getCR();
		printResourceInfo(cR);
		
//		Resource wR = context.getResource("https://images.pexels.com/photos/17532029/pexels-photo-17532029.jpeg");
		Resource wR = resVO.getWR();
		printResourceInfo(wR);
//		String filename = cR.getFilename();
//		File file = new File("/Users/eehdbs/", filename);
//		WritableResource dest = new FileSystemResource(file);
		
//		copyResource2(cR, dest);
		
//		String filename = fR.getFilename();
//		File file = new File("/Users/eehdbs/", filename);
//		WritableResource dest = new FileSystemResource(file);
//		moveResource(fR, dest);
	}
	
	private static void moveResource(Resource fR, WritableResource dest) throws IOException {
		copyResource2(fR, dest);
		File file = fR.getFile();
		file.delete();
	}

	private static void copyResource1(Resource src, WritableResource dest) throws IOException {
		try (
			InputStream is = src.getInputStream();
			OutputStream os = dest.getOutputStream();
		) {
			// byte stream
			byte[] buffer = new byte[1024];
			int cnt = -1;
			 
			while((cnt = is.read(buffer)) != -1) { // -1 : EOF(End Of File) 문자 
				os.write(buffer, 0, cnt);
			}
			os.flush();
		}
		
	}
	
	private static void copyResource2(Resource src, WritableResource dest) throws IOException {
		try (
			InputStream is = src.getInputStream();
			OutputStream os = dest.getOutputStream();
		) {
			IOUtils.copy(is, os);
		}
		
	}
	
	private static void printResourceInfo(Resource res) throws IOException {
		log.info("로딩된 파일 : {}", res);
		log.info("파일 크기 : {}", res.contentLength());
		log.info("파일 이름 : {}", res.getFilename());
		log.info("파일의 존재 여부 : {}", res.exists());
	}
}
